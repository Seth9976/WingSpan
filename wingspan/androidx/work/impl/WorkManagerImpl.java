package androidx.work.impl;

import android.app.PendingIntent;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.work.Configuration.Provider;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger.LogcatLogger;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.R.bool;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters.RuntimeExtras;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec.WorkInfoPojo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.PruneWorkRunnable;
import androidx.work.impl.utils.RawQueries;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import androidx.work.multiprocess.RemoteWorkManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class WorkManagerImpl extends WorkManager {
    static class Api24Impl {
        static boolean isDeviceProtectedStorage(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    public static final int MAX_PRE_JOB_SCHEDULER_API_LEVEL = 22;
    public static final int MIN_JOB_SCHEDULER_API_LEVEL = 23;
    public static final String REMOTE_WORK_MANAGER_CLIENT = "androidx.work.multiprocess.RemoteWorkManagerClient";
    private static final String TAG;
    private Configuration mConfiguration;
    private Context mContext;
    private boolean mForceStopRunnableCompleted;
    private PreferenceUtils mPreferenceUtils;
    private Processor mProcessor;
    private volatile RemoteWorkManager mRemoteWorkManager;
    private BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    private List mSchedulers;
    private final Trackers mTrackers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;
    private static WorkManagerImpl sDefaultInstance;
    private static WorkManagerImpl sDelegatedInstance;
    private static final Object sLock;

    static {
        WorkManagerImpl.TAG = "WM-WorkManagerImpl";
        WorkManagerImpl.sDelegatedInstance = null;
        WorkManagerImpl.sDefaultInstance = null;
        WorkManagerImpl.sLock = new Object();
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor workTaskExecutor) {
        this(context, configuration, workTaskExecutor, context.getResources().getBoolean(bool.workmanager_test_configuration));
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor workTaskExecutor, WorkDatabase database) {
        Context context1 = context.getApplicationContext();
        Logger.setLogger(new LogcatLogger(configuration.getMinimumLoggingLevel()));
        Trackers trackers0 = new Trackers(context1, workTaskExecutor);
        this.mTrackers = trackers0;
        List list0 = this.createSchedulers(context1, configuration, trackers0);
        this.internalInit(context, configuration, workTaskExecutor, database, list0, new Processor(context, configuration, workTaskExecutor, database, list0));
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor workTaskExecutor, WorkDatabase workDatabase, List schedulers, Processor processor) {
        this(context, configuration, workTaskExecutor, workDatabase, schedulers, processor, new Trackers(context.getApplicationContext(), workTaskExecutor));
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor workTaskExecutor, WorkDatabase workDatabase, List schedulers, Processor processor, Trackers trackers) {
        this.mTrackers = trackers;
        this.internalInit(context, configuration, workTaskExecutor, workDatabase, schedulers, processor);
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor workTaskExecutor, boolean useTestDatabase) {
        this(context, configuration, workTaskExecutor, WorkDatabase.create(context.getApplicationContext(), workTaskExecutor.getSerialTaskExecutor(), useTestDatabase));
    }

    @Override  // androidx.work.WorkManager
    public WorkContinuation beginUniqueWork(String uniqueWorkName, ExistingWorkPolicy existingWorkPolicy, List work) {
        if(work.isEmpty()) {
            throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
        }
        return new WorkContinuationImpl(this, uniqueWorkName, existingWorkPolicy, work);
    }

    @Override  // androidx.work.WorkManager
    public WorkContinuation beginWith(List work) {
        if(work.isEmpty()) {
            throw new IllegalArgumentException("beginWith needs at least one OneTimeWorkRequest.");
        }
        return new WorkContinuationImpl(this, work);
    }

    @Override  // androidx.work.WorkManager
    public Operation cancelAllWork() {
        CancelWorkRunnable cancelWorkRunnable0 = CancelWorkRunnable.forAll(this);
        this.mWorkTaskExecutor.executeOnTaskThread(cancelWorkRunnable0);
        return cancelWorkRunnable0.getOperation();
    }

    @Override  // androidx.work.WorkManager
    public Operation cancelAllWorkByTag(String tag) {
        CancelWorkRunnable cancelWorkRunnable0 = CancelWorkRunnable.forTag(tag, this);
        this.mWorkTaskExecutor.executeOnTaskThread(cancelWorkRunnable0);
        return cancelWorkRunnable0.getOperation();
    }

    @Override  // androidx.work.WorkManager
    public Operation cancelUniqueWork(String uniqueWorkName) {
        CancelWorkRunnable cancelWorkRunnable0 = CancelWorkRunnable.forName(uniqueWorkName, this, true);
        this.mWorkTaskExecutor.executeOnTaskThread(cancelWorkRunnable0);
        return cancelWorkRunnable0.getOperation();
    }

    @Override  // androidx.work.WorkManager
    public Operation cancelWorkById(UUID id) {
        CancelWorkRunnable cancelWorkRunnable0 = CancelWorkRunnable.forId(id, this);
        this.mWorkTaskExecutor.executeOnTaskThread(cancelWorkRunnable0);
        return cancelWorkRunnable0.getOperation();
    }

    @Override  // androidx.work.WorkManager
    public PendingIntent createCancelPendingIntent(UUID id) {
        Intent intent0 = SystemForegroundDispatcher.createCancelWorkIntent(this.mContext, id.toString());
        return Build.VERSION.SDK_INT < 0x1F ? PendingIntent.getService(this.mContext, 0, intent0, 0x8000000) : PendingIntent.getService(this.mContext, 0, intent0, 0xA000000);
    }

    public List createSchedulers(Context context, Configuration configuration, Trackers trackers) {
        return Arrays.asList(new Scheduler[]{Schedulers.createBestAvailableBackgroundScheduler(context, this), new GreedyScheduler(context, configuration, trackers, this)});
    }

    public WorkContinuationImpl createWorkContinuationForUniquePeriodicWork(String uniqueWorkName, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWork) {
        return existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP ? new WorkContinuationImpl(this, uniqueWorkName, ExistingWorkPolicy.KEEP, Collections.singletonList(periodicWork)) : new WorkContinuationImpl(this, uniqueWorkName, ExistingWorkPolicy.REPLACE, Collections.singletonList(periodicWork));
    }

    @Override  // androidx.work.WorkManager
    public Operation enqueue(List requests) {
        if(requests.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new WorkContinuationImpl(this, requests).enqueue();
    }

    @Override  // androidx.work.WorkManager
    public Operation enqueueUniquePeriodicWork(String uniqueWorkName, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWork) {
        return existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.UPDATE ? WorkerUpdater.enqueueUniquelyNamedPeriodic(this, uniqueWorkName, periodicWork) : this.createWorkContinuationForUniquePeriodicWork(uniqueWorkName, existingPeriodicWorkPolicy, periodicWork).enqueue();
    }

    @Override  // androidx.work.WorkManager
    public Operation enqueueUniqueWork(String uniqueWorkName, ExistingWorkPolicy existingWorkPolicy, List work) {
        return new WorkContinuationImpl(this, uniqueWorkName, existingWorkPolicy, work).enqueue();
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    @Override  // androidx.work.WorkManager
    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    @Deprecated
    public static WorkManagerImpl getInstance() {
        synchronized(WorkManagerImpl.sLock) {
            WorkManagerImpl workManagerImpl0 = WorkManagerImpl.sDelegatedInstance;
            if(workManagerImpl0 != null) {
                return workManagerImpl0;
            }
        }
        return WorkManagerImpl.sDefaultInstance;
    }

    public static WorkManagerImpl getInstance(Context context) {
        synchronized(WorkManagerImpl.sLock) {
            WorkManagerImpl workManagerImpl0 = WorkManagerImpl.getInstance();
            if(workManagerImpl0 == null) {
                Context context1 = context.getApplicationContext();
                if(!(context1 instanceof Provider)) {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
                WorkManagerImpl.initialize(context1, ((Provider)context1).getWorkManagerConfiguration());
                return WorkManagerImpl.getInstance(context1);
            }
            return workManagerImpl0;
        }
    }

    @Override  // androidx.work.WorkManager
    public ListenableFuture getLastCancelAllTimeMillis() {
        ListenableFuture listenableFuture0 = SettableFuture.create();
        this.mWorkTaskExecutor.executeOnTaskThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Long long0 = this.mPreferenceUtils.getLastCancelAllTimeMillis();
                    ((SettableFuture)listenableFuture0).set(long0);
                }
                catch(Throwable throwable0) {
                    ((SettableFuture)listenableFuture0).setException(throwable0);
                }
            }
        });
        return listenableFuture0;
    }

    @Override  // androidx.work.WorkManager
    public LiveData getLastCancelAllTimeMillisLiveData() {
        return this.mPreferenceUtils.getLastCancelAllTimeMillisLiveData();
    }

    public PreferenceUtils getPreferenceUtils() {
        return this.mPreferenceUtils;
    }

    public Processor getProcessor() {
        return this.mProcessor;
    }

    public RemoteWorkManager getRemoteWorkManager() {
        if(this.mRemoteWorkManager == null) {
            Object object0 = WorkManagerImpl.sLock;
            synchronized(object0) {
                if(this.mRemoteWorkManager == null) {
                    this.tryInitializeMultiProcessSupport();
                    if(this.mRemoteWorkManager == null && !TextUtils.isEmpty(this.mConfiguration.getDefaultProcessName())) {
                        throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
                    }
                }
                return this.mRemoteWorkManager;
            }
        }
        return this.mRemoteWorkManager;
    }

    public List getSchedulers() {
        return this.mSchedulers;
    }

    public Trackers getTrackers() {
        return this.mTrackers;
    }

    public WorkDatabase getWorkDatabase() {
        return this.mWorkDatabase;
    }

    @Override  // androidx.work.WorkManager
    public ListenableFuture getWorkInfoById(UUID id) {
        StatusRunnable statusRunnable0 = StatusRunnable.forUUID(this, id);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(statusRunnable0);
        return statusRunnable0.getFuture();
    }

    @Override  // androidx.work.WorkManager
    public LiveData getWorkInfoByIdLiveData(UUID id) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(Collections.singletonList(id.toString())), new Function() {
            public WorkInfo apply(List input) {
                return input == null || input.size() <= 0 ? null : ((WorkInfoPojo)input.get(0)).toWorkInfo();
            }

            @Override  // androidx.arch.core.util.Function
            public Object apply(Object input) {
                return this.apply(((List)input));
            }
        }, this.mWorkTaskExecutor);
    }

    @Override  // androidx.work.WorkManager
    public ListenableFuture getWorkInfos(WorkQuery workQuery) {
        StatusRunnable statusRunnable0 = StatusRunnable.forWorkQuerySpec(this, workQuery);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(statusRunnable0);
        return statusRunnable0.getFuture();
    }

    LiveData getWorkInfosById(List workSpecIds) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(workSpecIds), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override  // androidx.work.WorkManager
    public ListenableFuture getWorkInfosByTag(String tag) {
        StatusRunnable statusRunnable0 = StatusRunnable.forTag(this, tag);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(statusRunnable0);
        return statusRunnable0.getFuture();
    }

    @Override  // androidx.work.WorkManager
    public LiveData getWorkInfosByTagLiveData(String tag) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForTag(tag), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override  // androidx.work.WorkManager
    public ListenableFuture getWorkInfosForUniqueWork(String uniqueWorkName) {
        StatusRunnable statusRunnable0 = StatusRunnable.forUniqueWork(this, uniqueWorkName);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(statusRunnable0);
        return statusRunnable0.getFuture();
    }

    @Override  // androidx.work.WorkManager
    public LiveData getWorkInfosForUniqueWorkLiveData(String uniqueWorkName) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForName(uniqueWorkName), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override  // androidx.work.WorkManager
    public LiveData getWorkInfosLiveData(WorkQuery workQuery) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.rawWorkInfoDao().getWorkInfoPojosLiveData(RawQueries.toRawQuery(workQuery)), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    public TaskExecutor getWorkTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    @Override  // androidx.work.WorkManager
    public static void initialize(Context context, Configuration configuration) {
        synchronized(WorkManagerImpl.sLock) {
            WorkManagerImpl workManagerImpl0 = WorkManagerImpl.sDelegatedInstance;
            if(workManagerImpl0 != null && WorkManagerImpl.sDefaultInstance != null) {
                throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
            }
            if(workManagerImpl0 == null) {
                Context context1 = context.getApplicationContext();
                if(WorkManagerImpl.sDefaultInstance == null) {
                    WorkManagerImpl.sDefaultInstance = new WorkManagerImpl(context1, configuration, new WorkManagerTaskExecutor(configuration.getTaskExecutor()));
                }
                WorkManagerImpl.sDelegatedInstance = WorkManagerImpl.sDefaultInstance;
            }
        }
    }

    private void internalInit(Context context, Configuration configuration, TaskExecutor workTaskExecutor, WorkDatabase workDatabase, List schedulers, Processor processor) {
        Context context1 = context.getApplicationContext();
        this.mContext = context1;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = workTaskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = schedulers;
        this.mProcessor = processor;
        this.mPreferenceUtils = new PreferenceUtils(workDatabase);
        this.mForceStopRunnableCompleted = false;
        if(Build.VERSION.SDK_INT >= 24 && Api24Impl.isDeviceProtectedStorage(context1)) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        this.mWorkTaskExecutor.executeOnTaskThread(new ForceStopRunnable(context1, this));
    }

    @Override  // androidx.work.WorkManager
    public static boolean isInitialized() {
        return WorkManagerImpl.getInstance() != null;
    }

    public void onForceStopRunnableCompleted() {
        synchronized(WorkManagerImpl.sLock) {
            this.mForceStopRunnableCompleted = true;
            BroadcastReceiver.PendingResult broadcastReceiver$PendingResult0 = this.mRescheduleReceiverResult;
            if(broadcastReceiver$PendingResult0 != null) {
                broadcastReceiver$PendingResult0.finish();
                this.mRescheduleReceiverResult = null;
            }
        }
    }

    @Override  // androidx.work.WorkManager
    public Operation pruneWork() {
        PruneWorkRunnable pruneWorkRunnable0 = new PruneWorkRunnable(this);
        this.mWorkTaskExecutor.executeOnTaskThread(pruneWorkRunnable0);
        return pruneWorkRunnable0.getOperation();
    }

    public void rescheduleEligibleWork() {
        SystemJobScheduler.cancelAll(this.getApplicationContext());
        this.getWorkDatabase().workSpecDao().resetScheduledState();
        Schedulers.schedule(this.getConfiguration(), this.getWorkDatabase(), this.getSchedulers());
    }

    public static void setDelegate(WorkManagerImpl delegate) {
        synchronized(WorkManagerImpl.sLock) {
            WorkManagerImpl.sDelegatedInstance = delegate;
        }
    }

    public void setReschedulePendingResult(BroadcastReceiver.PendingResult rescheduleReceiverResult) {
        synchronized(WorkManagerImpl.sLock) {
            BroadcastReceiver.PendingResult broadcastReceiver$PendingResult1 = this.mRescheduleReceiverResult;
            if(broadcastReceiver$PendingResult1 != null) {
                broadcastReceiver$PendingResult1.finish();
            }
            this.mRescheduleReceiverResult = rescheduleReceiverResult;
            if(this.mForceStopRunnableCompleted) {
                rescheduleReceiverResult.finish();
                this.mRescheduleReceiverResult = null;
            }
        }
    }

    public void startWork(StartStopToken workSpecId) {
        this.startWork(workSpecId, null);
    }

    public void startWork(StartStopToken workSpecId, RuntimeExtras runtimeExtras) {
        this.mWorkTaskExecutor.executeOnTaskThread(new StartWorkRunnable(this, workSpecId, runtimeExtras));
    }

    public void stopForegroundWork(WorkGenerationalId id) {
        this.mWorkTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this, new StartStopToken(id), true));
    }

    public void stopWork(StartStopToken workSpecId) {
        this.mWorkTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this, workSpecId, false));
    }

    private void tryInitializeMultiProcessSupport() {
        try {
            this.mRemoteWorkManager = (RemoteWorkManager)Class.forName("androidx.work.multiprocess.RemoteWorkManagerClient").getConstructor(Context.class, WorkManagerImpl.class).newInstance(this.mContext, this);
        }
        catch(Throwable throwable0) {
            Logger.get().debug("WM-WorkManagerImpl", "Unable to initialize multi-process support", throwable0);
        }
    }

    @Override  // androidx.work.WorkManager
    public ListenableFuture updateWork(WorkRequest request) {
        return WorkerUpdater.updateWorkImpl(this, request);
    }
}

