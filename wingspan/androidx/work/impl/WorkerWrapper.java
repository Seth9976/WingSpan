package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker.Result.Failure;
import androidx.work.ListenableWorker.Result.Retry;
import androidx.work.ListenableWorker.Result.Success;
import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo.State;
import androidx.work.WorkerParameters.RuntimeExtras;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class WorkerWrapper implements Runnable {
    public static class Builder {
        Context mAppContext;
        Configuration mConfiguration;
        ForegroundProcessor mForegroundProcessor;
        RuntimeExtras mRuntimeExtras;
        List mSchedulers;
        private final List mTags;
        WorkDatabase mWorkDatabase;
        WorkSpec mWorkSpec;
        TaskExecutor mWorkTaskExecutor;
        ListenableWorker mWorker;

        public Builder(Context context, Configuration configuration, TaskExecutor workTaskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase database, WorkSpec workSpec, List tags) {
            this.mRuntimeExtras = new RuntimeExtras();
            this.mAppContext = context.getApplicationContext();
            this.mWorkTaskExecutor = workTaskExecutor;
            this.mForegroundProcessor = foregroundProcessor;
            this.mConfiguration = configuration;
            this.mWorkDatabase = database;
            this.mWorkSpec = workSpec;
            this.mTags = tags;
        }

        public WorkerWrapper build() {
            return new WorkerWrapper(this);
        }

        public Builder withRuntimeExtras(RuntimeExtras runtimeExtras) {
            if(runtimeExtras != null) {
                this.mRuntimeExtras = runtimeExtras;
            }
            return this;
        }

        public Builder withSchedulers(List schedulers) {
            this.mSchedulers = schedulers;
            return this;
        }

        public Builder withWorker(ListenableWorker worker) {
            this.mWorker = worker;
            return this;
        }
    }

    static final String TAG;
    Context mAppContext;
    private Configuration mConfiguration;
    private DependencyDao mDependencyDao;
    private ForegroundProcessor mForegroundProcessor;
    SettableFuture mFuture;
    private volatile boolean mInterrupted;
    Result mResult;
    private RuntimeExtras mRuntimeExtras;
    private List mSchedulers;
    private List mTags;
    private WorkDatabase mWorkDatabase;
    private String mWorkDescription;
    WorkSpec mWorkSpec;
    private WorkSpecDao mWorkSpecDao;
    private final String mWorkSpecId;
    TaskExecutor mWorkTaskExecutor;
    ListenableWorker mWorker;
    final SettableFuture mWorkerResultFuture;

    static {
        WorkerWrapper.TAG = "WM-WorkerWrapper";
    }

    WorkerWrapper(Builder builder) {
        this.mResult = Result.failure();
        this.mFuture = SettableFuture.create();
        this.mWorkerResultFuture = SettableFuture.create();
        this.mAppContext = builder.mAppContext;
        this.mWorkTaskExecutor = builder.mWorkTaskExecutor;
        this.mForegroundProcessor = builder.mForegroundProcessor;
        WorkSpec workSpec0 = builder.mWorkSpec;
        this.mWorkSpec = workSpec0;
        this.mWorkSpecId = workSpec0.id;
        this.mSchedulers = builder.mSchedulers;
        this.mRuntimeExtras = builder.mRuntimeExtras;
        this.mWorker = builder.mWorker;
        this.mConfiguration = builder.mConfiguration;
        WorkDatabase workDatabase0 = builder.mWorkDatabase;
        this.mWorkDatabase = workDatabase0;
        this.mWorkSpecDao = workDatabase0.workSpecDao();
        this.mDependencyDao = this.mWorkDatabase.dependencyDao();
        this.mTags = builder.mTags;
    }

    private String createWorkDescription(List tags) {
        StringBuilder stringBuilder0 = new StringBuilder("Work [ id=");
        stringBuilder0.append(this.mWorkSpecId);
        stringBuilder0.append(", tags={ ");
        boolean z = true;
        for(Object object0: tags) {
            if(z) {
                z = false;
            }
            else {
                stringBuilder0.append(", ");
            }
            stringBuilder0.append(((String)object0));
        }
        stringBuilder0.append(" } ]");
        return stringBuilder0.toString();
    }

    public ListenableFuture getFuture() {
        return this.mFuture;
    }

    public WorkGenerationalId getWorkGenerationalId() {
        return WorkSpecKt.generationalId(this.mWorkSpec);
    }

    public WorkSpec getWorkSpec() {
        return this.mWorkSpec;
    }

    private void handleResult(Result result) {
        if(result instanceof Success) {
            Logger.get().info("WM-WorkerWrapper", "Worker result SUCCESS for " + this.mWorkDescription);
            if(this.mWorkSpec.isPeriodic()) {
                this.resetPeriodicAndResolve();
                return;
            }
            this.setSucceededAndResolve();
            return;
        }
        if(result instanceof Retry) {
            Logger.get().info("WM-WorkerWrapper", "Worker result RETRY for " + this.mWorkDescription);
            this.rescheduleAndResolve();
            return;
        }
        Logger.get().info("WM-WorkerWrapper", "Worker result FAILURE for " + this.mWorkDescription);
        if(this.mWorkSpec.isPeriodic()) {
            this.resetPeriodicAndResolve();
            return;
        }
        this.setFailedAndResolve();
    }

    public void interrupt() {
        this.mInterrupted = true;
        this.tryCheckForInterruptionAndResolve();
        this.mWorkerResultFuture.cancel(true);
        if(this.mWorker != null && this.mWorkerResultFuture.isCancelled()) {
            this.mWorker.stop();
            return;
        }
        Logger.get().debug("WM-WorkerWrapper", "WorkSpec " + this.mWorkSpec + " is already done. Not interrupting.");
    }

    private void iterativelyFailWorkAndDependents(String workSpecId) {
        LinkedList linkedList0 = new LinkedList();
        linkedList0.add(workSpecId);
        while(!linkedList0.isEmpty()) {
            String s1 = (String)linkedList0.remove();
            if(this.mWorkSpecDao.getState(s1) != State.CANCELLED) {
                this.mWorkSpecDao.setState(State.FAILED, s1);
            }
            linkedList0.addAll(this.mDependencyDao.getDependentWorkIds(s1));
        }
    }

    // 检测为 Lambda 实现
    void lambda$runWorker$0$androidx-work-impl-WorkerWrapper(ListenableFuture listenableFuture0) [...]

    void onWorkFinished() {
        if(!this.tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.beginTransaction();
            try {
                State workInfo$State0 = this.mWorkSpecDao.getState(this.mWorkSpecId);
                this.mWorkDatabase.workProgressDao().delete(this.mWorkSpecId);
                if(workInfo$State0 == null) {
                    this.resolve(false);
                }
                else if(workInfo$State0 == State.RUNNING) {
                    this.handleResult(this.mResult);
                }
                else {
                    this.rescheduleAndResolve();
                }
                this.mWorkDatabase.setTransactionSuccessful();
            }
            finally {
                this.mWorkDatabase.endTransaction();
            }
        }
        List list0 = this.mSchedulers;
        if(list0 != null) {
            for(Object object0: list0) {
                ((Scheduler)object0).cancel(this.mWorkSpecId);
            }
            Schedulers.schedule(this.mConfiguration, this.mWorkDatabase, this.mSchedulers);
        }
    }

    private void rescheduleAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setState(State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.setLastEnqueuedTime(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1L);
            this.mWorkDatabase.setTransactionSuccessful();
        }
        finally {
            this.mWorkDatabase.endTransaction();
            this.resolve(true);
        }
    }

    private void resetPeriodicAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setLastEnqueuedTime(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.setState(State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.resetWorkSpecRunAttemptCount(this.mWorkSpecId);
            this.mWorkSpecDao.incrementPeriodCount(this.mWorkSpecId);
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1L);
            this.mWorkDatabase.setTransactionSuccessful();
        }
        finally {
            this.mWorkDatabase.endTransaction();
            this.resolve(false);
        }
    }

    private void resolve(boolean needsReschedule) {
        this.mWorkDatabase.beginTransaction();
        try {
            if(!this.mWorkDatabase.workSpecDao().hasUnfinishedWork()) {
                PackageManagerHelper.setComponentEnabled(this.mAppContext, RescheduleReceiver.class, false);
            }
            if(needsReschedule) {
                this.mWorkSpecDao.setState(State.ENQUEUED, this.mWorkSpecId);
                this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1L);
            }
            if(this.mWorkSpec != null && this.mWorker != null && this.mForegroundProcessor.isEnqueuedInForeground(this.mWorkSpecId)) {
                this.mForegroundProcessor.stopForeground(this.mWorkSpecId);
            }
            this.mWorkDatabase.setTransactionSuccessful();
        }
        finally {
            this.mWorkDatabase.endTransaction();
        }
        this.mFuture.set(Boolean.valueOf(needsReschedule));
    }

    private void resolveIncorrectStatus() {
        State workInfo$State0 = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if(workInfo$State0 == State.RUNNING) {
            Logger.get().debug("WM-WorkerWrapper", "Status for " + this.mWorkSpecId + " is RUNNING; not doing any work and rescheduling for later execution");
            this.resolve(true);
            return;
        }
        Logger.get().debug("WM-WorkerWrapper", "Status for " + this.mWorkSpecId + " is " + workInfo$State0 + " ; not doing any work");
        this.resolve(false);
    }

    @Override
    public void run() {
        this.mWorkDescription = this.createWorkDescription(this.mTags);
        this.runWorker();
    }

    private void runWorker() {
        Data data0;
        if(this.tryCheckForInterruptionAndResolve()) {
            return;
        }
        this.mWorkDatabase.beginTransaction();
        try {
            if(this.mWorkSpec.state != State.ENQUEUED) {
                this.resolveIncorrectStatus();
                this.mWorkDatabase.setTransactionSuccessful();
                Logger.get().debug("WM-WorkerWrapper", this.mWorkSpec.workerClassName + " is not in ENQUEUED state. Nothing more to do");
                return;
            }
            if((this.mWorkSpec.isPeriodic() || this.mWorkSpec.isBackedOff()) && System.currentTimeMillis() < this.mWorkSpec.calculateNextRunTime()) {
                Logger.get().debug("WM-WorkerWrapper", String.format("Delaying execution for %s because it is being executed before schedule.", this.mWorkSpec.workerClassName));
                this.resolve(true);
                this.mWorkDatabase.setTransactionSuccessful();
                return;
            }
            this.mWorkDatabase.setTransactionSuccessful();
        }
        finally {
            this.mWorkDatabase.endTransaction();
        }
        if(this.mWorkSpec.isPeriodic()) {
            data0 = this.mWorkSpec.input;
        }
        else {
            InputMerger inputMerger0 = this.mConfiguration.getInputMergerFactory().createInputMergerWithDefaultFallback(this.mWorkSpec.inputMergerClassName);
            if(inputMerger0 == null) {
                Logger.get().error("WM-WorkerWrapper", "Could not create Input Merger " + this.mWorkSpec.inputMergerClassName);
                this.setFailedAndResolve();
                return;
            }
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(this.mWorkSpec.input);
            arrayList0.addAll(this.mWorkSpecDao.getInputsFromPrerequisites(this.mWorkSpecId));
            data0 = inputMerger0.merge(arrayList0);
        }
        WorkerParameters workerParameters0 = new WorkerParameters(UUID.fromString(this.mWorkSpecId), data0, this.mTags, this.mRuntimeExtras, this.mWorkSpec.runAttemptCount, this.mWorkSpec.getGeneration(), this.mConfiguration.getExecutor(), this.mWorkTaskExecutor, this.mConfiguration.getWorkerFactory(), new WorkProgressUpdater(this.mWorkDatabase, this.mWorkTaskExecutor), new WorkForegroundUpdater(this.mWorkDatabase, this.mForegroundProcessor, this.mWorkTaskExecutor));
        if(this.mWorker == null) {
            this.mWorker = this.mConfiguration.getWorkerFactory().createWorkerWithDefaultFallback(this.mAppContext, this.mWorkSpec.workerClassName, workerParameters0);
        }
        ListenableWorker listenableWorker0 = this.mWorker;
        if(listenableWorker0 == null) {
            Logger.get().error("WM-WorkerWrapper", "Could not create Worker " + this.mWorkSpec.workerClassName);
            this.setFailedAndResolve();
            return;
        }
        if(listenableWorker0.isUsed()) {
            Logger.get().error("WM-WorkerWrapper", "Received an already-used Worker " + this.mWorkSpec.workerClassName + "; Worker Factory should return new instances");
            this.setFailedAndResolve();
            return;
        }
        this.mWorker.setUsed();
        if(this.trySetRunning()) {
            if(this.tryCheckForInterruptionAndResolve()) {
                return;
            }
            WorkForegroundRunnable workForegroundRunnable0 = new WorkForegroundRunnable(this.mAppContext, this.mWorkSpec, this.mWorker, workerParameters0.getForegroundUpdater(), this.mWorkTaskExecutor);
            this.mWorkTaskExecutor.getMainThreadExecutor().execute(workForegroundRunnable0);
            ListenableFuture listenableFuture0 = workForegroundRunnable0.getFuture();
            WorkerWrapper..ExternalSyntheticLambda0 workerWrapper$$ExternalSyntheticLambda00 = () -> if(this.mWorkerResultFuture.isCancelled()) {
                listenableFuture0.cancel(true);
            };
            SynchronousExecutor synchronousExecutor0 = new SynchronousExecutor();
            this.mWorkerResultFuture.addListener(workerWrapper$$ExternalSyntheticLambda00, synchronousExecutor0);
            listenableFuture0.addListener(new Runnable() {
                @Override
                public void run() {
                    if(WorkerWrapper.this.mWorkerResultFuture.isCancelled()) {
                        return;
                    }
                    try {
                        listenableFuture0.get();
                        Logger.get().debug("WM-WorkerWrapper", "Starting work for " + WorkerWrapper.this.mWorkSpec.workerClassName);
                        ListenableFuture listenableFuture0 = WorkerWrapper.this.mWorker.startWork();
                        WorkerWrapper.this.mWorkerResultFuture.setFuture(listenableFuture0);
                    }
                    catch(Throwable throwable0) {
                        WorkerWrapper.this.mWorkerResultFuture.setException(throwable0);
                    }
                }
            }, this.mWorkTaskExecutor.getMainThreadExecutor());
            androidx.work.impl.WorkerWrapper.2 workerWrapper$20 = new Runnable() {
                @Override
                public void run() {
                    try {
                        Result listenableWorker$Result0 = (Result)WorkerWrapper.this.mWorkerResultFuture.get();
                        if(listenableWorker$Result0 == null) {
                            Logger.get().error("WM-WorkerWrapper", WorkerWrapper.this.mWorkSpec.workerClassName + " returned a null result. Treating it as a failure.");
                        }
                        else {
                            Logger.get().debug("WM-WorkerWrapper", WorkerWrapper.this.mWorkSpec.workerClassName + " returned a " + listenableWorker$Result0 + ".");
                            WorkerWrapper.this.mResult = listenableWorker$Result0;
                        }
                    }
                    catch(CancellationException cancellationException0) {
                        Logger.get().info("WM-WorkerWrapper", this.mWorkDescription + " was cancelled", cancellationException0);
                    }
                    catch(InterruptedException | ExecutionException interruptedException0) {
                        Logger.get().error("WM-WorkerWrapper", this.mWorkDescription + " failed because it threw an exception/error", interruptedException0);
                    }
                    finally {
                        WorkerWrapper.this.onWorkFinished();
                    }
                }
            };
            SerialExecutor serialExecutor0 = this.mWorkTaskExecutor.getSerialTaskExecutor();
            this.mWorkerResultFuture.addListener(workerWrapper$20, serialExecutor0);
            return;
        }
        this.resolveIncorrectStatus();
    }

    void setFailedAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.iterativelyFailWorkAndDependents(this.mWorkSpecId);
            Data data0 = ((Failure)this.mResult).getOutputData();
            this.mWorkSpecDao.setOutput(this.mWorkSpecId, data0);
            this.mWorkDatabase.setTransactionSuccessful();
        }
        finally {
            this.mWorkDatabase.endTransaction();
            this.resolve(false);
        }
    }

    private void setSucceededAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setState(State.SUCCEEDED, this.mWorkSpecId);
            Data data0 = ((Success)this.mResult).getOutputData();
            this.mWorkSpecDao.setOutput(this.mWorkSpecId, data0);
            long v1 = System.currentTimeMillis();
            for(Object object0: this.mDependencyDao.getDependentWorkIds(this.mWorkSpecId)) {
                String s = (String)object0;
                if(this.mWorkSpecDao.getState(s) == State.BLOCKED && this.mDependencyDao.hasCompletedAllPrerequisites(s)) {
                    Logger.get().info("WM-WorkerWrapper", "Setting status to enqueued for " + s);
                    this.mWorkSpecDao.setState(State.ENQUEUED, s);
                    this.mWorkSpecDao.setLastEnqueuedTime(s, v1);
                }
            }
            this.mWorkDatabase.setTransactionSuccessful();
        }
        finally {
            this.mWorkDatabase.endTransaction();
            this.resolve(false);
        }
    }

    private boolean tryCheckForInterruptionAndResolve() {
        if(this.mInterrupted) {
            Logger.get().debug("WM-WorkerWrapper", "Work interrupted for " + this.mWorkDescription);
            if(this.mWorkSpecDao.getState(this.mWorkSpecId) == null) {
                this.resolve(false);
                return true;
            }
            this.resolve(true);
            return true;
        }
        return false;
    }

    private boolean trySetRunning() {
        boolean z;
        this.mWorkDatabase.beginTransaction();
        try {
            if(this.mWorkSpecDao.getState(this.mWorkSpecId) == State.ENQUEUED) {
                this.mWorkSpecDao.setState(State.RUNNING, this.mWorkSpecId);
                this.mWorkSpecDao.incrementWorkSpecRunAttemptCount(this.mWorkSpecId);
                z = true;
            }
            else {
                z = false;
            }
            this.mWorkDatabase.setTransactionSuccessful();
            return z;
        }
        finally {
            this.mWorkDatabase.endTransaction();
        }
    }
}

