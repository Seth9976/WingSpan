package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0014\u001A\u00020\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0016\u0010\u0019\u001A\u00020\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u001A\u001A\u00020\u0015H\u0016J\b\u0010\u001B\u001A\u00020\u0015H\u0002J\u000E\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00100\u001DH\u0016R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u000B\u001A\u0004\u0018\u00010\u00012\b\u0010\n\u001A\u0004\u0018\u00010\u00018G@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR2\u0010\u000E\u001A&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u000F0\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2 = {"Landroidx/work/impl/workers/ConstraintTrackingWorker;", "Landroidx/work/ListenableWorker;", "Landroidx/work/impl/constraints/WorkConstraintsCallback;", "appContext", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "areConstraintsUnmet", "", "<set-?>", "delegate", "getDelegate", "()Landroidx/work/ListenableWorker;", "future", "Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "kotlin.jvm.PlatformType", "lock", "", "onAllConstraintsMet", "", "workSpecs", "", "Landroidx/work/impl/model/WorkSpec;", "onAllConstraintsNotMet", "onStopped", "setupAndRunConstraintTrackingWork", "startWork", "Lcom/google/common/util/concurrent/ListenableFuture;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {
    private volatile boolean areConstraintsUnmet;
    private ListenableWorker delegate;
    private final SettableFuture future;
    private final Object lock;
    private final WorkerParameters workerParameters;

    public ConstraintTrackingWorker(Context context0, WorkerParameters workerParameters0) {
        Intrinsics.checkNotNullParameter(context0, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters0, "workerParameters");
        super(context0, workerParameters0);
        this.workerParameters = workerParameters0;
        this.lock = new Object();
        this.future = SettableFuture.create();
    }

    public final ListenableWorker getDelegate() {
        return this.delegate;
    }

    @Override  // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List list0) {
        Intrinsics.checkNotNullParameter(list0, "workSpecs");
    }

    @Override  // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List list0) {
        Intrinsics.checkNotNullParameter(list0, "workSpecs");
        Logger.get().debug("WM-ConstraintTrkngWrkr", "Constraints changed for " + list0);
        synchronized(this.lock) {
            this.areConstraintsUnmet = true;
        }
    }

    @Override  // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker0 = this.delegate;
        if(listenableWorker0 != null && !listenableWorker0.isStopped()) {
            listenableWorker0.stop();
        }
    }

    private final void setupAndRunConstraintTrackingWork() {
        if(this.future.isCancelled()) {
            return;
        }
        String s = this.getInputData().getString("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        Logger logger0 = Logger.get();
        Intrinsics.checkNotNullExpressionValue(logger0, "get()");
        if(s == null || s.length() == 0) {
            logger0.error("WM-ConstraintTrkngWrkr", "No worker to delegate to.");
            Intrinsics.checkNotNullExpressionValue(this.future, "future");
            ConstraintTrackingWorkerKt.setFailed(this.future);
            return;
        }
        ListenableWorker listenableWorker0 = this.getWorkerFactory().createWorkerWithDefaultFallback(this.getApplicationContext(), s, this.workerParameters);
        this.delegate = listenableWorker0;
        if(listenableWorker0 == null) {
            logger0.debug("WM-ConstraintTrkngWrkr", "No worker to delegate to.");
            Intrinsics.checkNotNullExpressionValue(this.future, "future");
            ConstraintTrackingWorkerKt.setFailed(this.future);
            return;
        }
        WorkManagerImpl workManagerImpl0 = WorkManagerImpl.getInstance(this.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(workManagerImpl0, "getInstance(applicationContext)");
        WorkSpecDao workSpecDao0 = workManagerImpl0.getWorkDatabase().workSpecDao();
        String s1 = this.getId().toString();
        Intrinsics.checkNotNullExpressionValue(s1, "id.toString()");
        WorkSpec workSpec0 = workSpecDao0.getWorkSpec(s1);
        if(workSpec0 == null) {
            Intrinsics.checkNotNullExpressionValue(this.future, "future");
            ConstraintTrackingWorkerKt.setFailed(this.future);
            return;
        }
        Trackers trackers0 = workManagerImpl0.getTrackers();
        Intrinsics.checkNotNullExpressionValue(trackers0, "workManagerImpl.trackers");
        WorkConstraintsTrackerImpl workConstraintsTrackerImpl0 = new WorkConstraintsTrackerImpl(trackers0, this);
        workConstraintsTrackerImpl0.replace(CollectionsKt.listOf(workSpec0));
        String s2 = this.getId().toString();
        Intrinsics.checkNotNullExpressionValue(s2, "id.toString()");
        if(workConstraintsTrackerImpl0.areAllConstraintsMet(s2)) {
            logger0.debug("WM-ConstraintTrkngWrkr", "Constraints met for delegate " + s);
            try {
                ListenableWorker listenableWorker1 = this.delegate;
                Intrinsics.checkNotNull(listenableWorker1);
                ListenableFuture listenableFuture0 = listenableWorker1.startWork();
                Intrinsics.checkNotNullExpressionValue(listenableFuture0, "delegate!!.startWork()");
                listenableFuture0.addListener(() -> {
                    Intrinsics.checkNotNullParameter(this, "this$0");
                    Intrinsics.checkNotNullParameter(listenableFuture0, "$innerFuture");
                    synchronized(this.lock) {
                        if(this.areConstraintsUnmet) {
                            Intrinsics.checkNotNullExpressionValue(this.future, "future");
                            ConstraintTrackingWorkerKt.setRetry(this.future);
                        }
                        else {
                            this.future.setFuture(listenableFuture0);
                        }
                    }
                }, this.getBackgroundExecutor());
            }
            catch(Throwable throwable0) {
                logger0.debug("WM-ConstraintTrkngWrkr", "Delegated worker " + s + " threw exception in startWork.", throwable0);
                synchronized(this.lock) {
                    if(this.areConstraintsUnmet) {
                        logger0.debug("WM-ConstraintTrkngWrkr", "Constraints were unmet, Retrying.");
                        Intrinsics.checkNotNullExpressionValue(this.future, "future");
                        ConstraintTrackingWorkerKt.setRetry(this.future);
                    }
                    else {
                        Intrinsics.checkNotNullExpressionValue(this.future, "future");
                        ConstraintTrackingWorkerKt.setFailed(this.future);
                    }
                }
            }
            return;
        }
        logger0.debug("WM-ConstraintTrkngWrkr", "Constraints not met for delegate " + s + ". Requesting retry.");
        Intrinsics.checkNotNullExpressionValue(this.future, "future");
        ConstraintTrackingWorkerKt.setRetry(this.future);
    }

    // 检测为 Lambda 实现
    private static final void setupAndRunConstraintTrackingWork$lambda$2(ConstraintTrackingWorker constraintTrackingWorker0, ListenableFuture listenableFuture0) [...]

    @Override  // androidx.work.ListenableWorker
    public ListenableFuture startWork() {
        this.getBackgroundExecutor().execute(() -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            this.setupAndRunConstraintTrackingWork();
        });
        Intrinsics.checkNotNullExpressionValue(this.future, "future");
        return this.future;
    }

    // 检测为 Lambda 实现
    private static final void startWork$lambda$0(ConstraintTrackingWorker constraintTrackingWorker0) [...]
}

