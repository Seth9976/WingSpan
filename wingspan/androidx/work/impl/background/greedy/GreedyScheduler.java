package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo.State;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.ProcessUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GreedyScheduler implements ExecutionListener, Scheduler, WorkConstraintsCallback {
    private static final String TAG;
    private final Set mConstrainedWorkSpecs;
    private final Context mContext;
    private DelayedWorkTracker mDelayedWorkTracker;
    Boolean mInDefaultProcess;
    private final Object mLock;
    private boolean mRegisteredExecutionListener;
    private final StartStopTokens mStartStopTokens;
    private final WorkConstraintsTracker mWorkConstraintsTracker;
    private final WorkManagerImpl mWorkManagerImpl;

    static {
        GreedyScheduler.TAG = "WM-GreedyScheduler";
    }

    public GreedyScheduler(Context context, Configuration configuration, Trackers trackers, WorkManagerImpl workManagerImpl) {
        this.mConstrainedWorkSpecs = new HashSet();
        this.mStartStopTokens = new StartStopTokens();
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = new WorkConstraintsTrackerImpl(trackers, this);
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, configuration.getRunnableScheduler());
        this.mLock = new Object();
    }

    public GreedyScheduler(Context context, WorkManagerImpl workManagerImpl, WorkConstraintsTracker workConstraintsTracker) {
        this.mConstrainedWorkSpecs = new HashSet();
        this.mStartStopTokens = new StartStopTokens();
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = workConstraintsTracker;
        this.mLock = new Object();
    }

    @Override  // androidx.work.impl.Scheduler
    public void cancel(String workSpecId) {
        if(this.mInDefaultProcess == null) {
            this.checkDefaultProcess();
        }
        if(!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info("WM-GreedyScheduler", "Ignoring schedule request in non-main process");
            return;
        }
        this.registerExecutionListenerIfNeeded();
        Logger.get().debug("WM-GreedyScheduler", "Cancelling work ID " + workSpecId);
        DelayedWorkTracker delayedWorkTracker0 = this.mDelayedWorkTracker;
        if(delayedWorkTracker0 != null) {
            delayedWorkTracker0.unschedule(workSpecId);
        }
        for(Object object0: this.mStartStopTokens.remove(workSpecId)) {
            this.mWorkManagerImpl.stopWork(((StartStopToken)object0));
        }
    }

    private void checkDefaultProcess() {
        this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, this.mWorkManagerImpl.getConfiguration()));
    }

    @Override  // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    @Override  // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List workSpecs) {
        for(Object object0: workSpecs) {
            WorkGenerationalId workGenerationalId0 = WorkSpecKt.generationalId(((WorkSpec)object0));
            if(!this.mStartStopTokens.contains(workGenerationalId0)) {
                Logger.get().debug("WM-GreedyScheduler", "Constraints met: Scheduling work ID " + workGenerationalId0);
                StartStopToken startStopToken0 = this.mStartStopTokens.tokenFor(workGenerationalId0);
                this.mWorkManagerImpl.startWork(startStopToken0);
            }
        }
    }

    @Override  // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List workSpecs) {
        for(Object object0: workSpecs) {
            WorkGenerationalId workGenerationalId0 = WorkSpecKt.generationalId(((WorkSpec)object0));
            Logger.get().debug("WM-GreedyScheduler", "Constraints not met: Cancelling work ID " + workGenerationalId0);
            StartStopToken startStopToken0 = this.mStartStopTokens.remove(workGenerationalId0);
            if(startStopToken0 != null) {
                this.mWorkManagerImpl.stopWork(startStopToken0);
            }
        }
    }

    @Override  // androidx.work.impl.ExecutionListener
    public void onExecuted(WorkGenerationalId id, boolean needsReschedule) {
        this.mStartStopTokens.remove(id);
        this.removeConstraintTrackingFor(id);
    }

    private void registerExecutionListenerIfNeeded() {
        if(!this.mRegisteredExecutionListener) {
            this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
    }

    private void removeConstraintTrackingFor(WorkGenerationalId id) {
        synchronized(this.mLock) {
            for(Object object1: this.mConstrainedWorkSpecs) {
                WorkSpec workSpec0 = (WorkSpec)object1;
                if(WorkSpecKt.generationalId(workSpec0).equals(id)) {
                    Logger.get().debug("WM-GreedyScheduler", "Stopping tracking for " + id);
                    this.mConstrainedWorkSpecs.remove(workSpec0);
                    this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
    }

    @Override  // androidx.work.impl.Scheduler
    public void schedule(WorkSpec[] workSpecs) {
        if(this.mInDefaultProcess == null) {
            this.checkDefaultProcess();
        }
        if(!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info("WM-GreedyScheduler", "Ignoring schedule request in a secondary process");
            return;
        }
        this.registerExecutionListenerIfNeeded();
        HashSet hashSet0 = new HashSet();
        HashSet hashSet1 = new HashSet();
        for(int v = 0; v < workSpecs.length; ++v) {
            WorkSpec workSpec0 = workSpecs[v];
            WorkGenerationalId workGenerationalId0 = WorkSpecKt.generationalId(workSpec0);
            if(!this.mStartStopTokens.contains(workGenerationalId0)) {
                long v1 = workSpec0.calculateNextRunTime();
                long v2 = System.currentTimeMillis();
                if(workSpec0.state == State.ENQUEUED) {
                    if(v2 < v1) {
                        DelayedWorkTracker delayedWorkTracker0 = this.mDelayedWorkTracker;
                        if(delayedWorkTracker0 != null) {
                            delayedWorkTracker0.schedule(workSpec0);
                        }
                    }
                    else if(!workSpec0.hasConstraints()) {
                        WorkGenerationalId workGenerationalId1 = WorkSpecKt.generationalId(workSpec0);
                        if(!this.mStartStopTokens.contains(workGenerationalId1)) {
                            Logger.get().debug("WM-GreedyScheduler", "Starting work for " + workSpec0.id);
                            StartStopToken startStopToken0 = this.mStartStopTokens.tokenFor(workSpec0);
                            this.mWorkManagerImpl.startWork(startStopToken0);
                        }
                    }
                    else if(workSpec0.constraints.requiresDeviceIdle()) {
                        Logger.get().debug("WM-GreedyScheduler", "Ignoring " + workSpec0 + ". Requires device idle.");
                    }
                    else if(Build.VERSION.SDK_INT < 24 || !workSpec0.constraints.hasContentUriTriggers()) {
                        hashSet0.add(workSpec0);
                        hashSet1.add(workSpec0.id);
                    }
                    else {
                        Logger.get().debug("WM-GreedyScheduler", "Ignoring " + workSpec0 + ". Requires ContentUri triggers.");
                    }
                }
            }
        }
        synchronized(this.mLock) {
            if(!hashSet0.isEmpty()) {
                String s = TextUtils.join(",", hashSet1);
                Logger.get().debug("WM-GreedyScheduler", "Starting tracking for " + s);
                this.mConstrainedWorkSpecs.addAll(hashSet0);
                this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
            }
        }
    }

    public void setDelayedWorkTracker(DelayedWorkTracker delayedWorkTracker) {
        this.mDelayedWorkTracker = delayedWorkTracker;
    }
}

