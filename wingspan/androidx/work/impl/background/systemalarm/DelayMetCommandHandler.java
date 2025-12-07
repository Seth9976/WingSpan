package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import androidx.work.Logger;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer.TimeLimitExceededListener;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public class DelayMetCommandHandler implements WorkConstraintsCallback, TimeLimitExceededListener {
    private static final int STATE_INITIAL = 0;
    private static final int STATE_START_REQUESTED = 1;
    private static final int STATE_STOP_REQUESTED = 2;
    private static final String TAG;
    private final Context mContext;
    private int mCurrentState;
    private final SystemAlarmDispatcher mDispatcher;
    private boolean mHasConstraints;
    private final Object mLock;
    private final Executor mMainThreadExecutor;
    private final Executor mSerialExecutor;
    private final int mStartId;
    private final StartStopToken mToken;
    private PowerManager.WakeLock mWakeLock;
    private final WorkConstraintsTrackerImpl mWorkConstraintsTracker;
    private final WorkGenerationalId mWorkGenerationalId;

    static {
        DelayMetCommandHandler.TAG = "WM-DelayMetCommandHandl";
    }

    DelayMetCommandHandler(Context context, int startId, SystemAlarmDispatcher dispatcher, StartStopToken startStopToken) {
        this.mContext = context;
        this.mStartId = startId;
        this.mDispatcher = dispatcher;
        this.mWorkGenerationalId = startStopToken.getId();
        this.mToken = startStopToken;
        Trackers trackers0 = dispatcher.getWorkManager().getTrackers();
        this.mSerialExecutor = dispatcher.getTaskExecutor().getSerialTaskExecutor();
        this.mMainThreadExecutor = dispatcher.getTaskExecutor().getMainThreadExecutor();
        this.mWorkConstraintsTracker = new WorkConstraintsTrackerImpl(trackers0, this);
        this.mHasConstraints = false;
        this.mCurrentState = 0;
        this.mLock = new Object();
    }

    private void cleanUp() {
        synchronized(this.mLock) {
            this.mWorkConstraintsTracker.reset();
            this.mDispatcher.getWorkTimer().stopTimer(this.mWorkGenerationalId);
            if(this.mWakeLock != null && this.mWakeLock.isHeld()) {
                Logger.get().debug("WM-DelayMetCommandHandl", "Releasing wakelock " + this.mWakeLock + "for WorkSpec " + this.mWorkGenerationalId);
                this.mWakeLock.release();
            }
        }
    }

    void handleProcessWork() {
        String s = this.mWorkGenerationalId.getWorkSpecId();
        this.mWakeLock = WakeLocks.newWakeLock(this.mContext, s + " (" + this.mStartId + ")");
        Logger.get().debug("WM-DelayMetCommandHandl", "Acquiring wakelock " + this.mWakeLock + "for WorkSpec " + s);
        this.mWakeLock.acquire();
        WorkSpec workSpec0 = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getWorkSpec(s);
        if(workSpec0 == null) {
            DelayMetCommandHandler..ExternalSyntheticLambda0 delayMetCommandHandler$$ExternalSyntheticLambda00 = () -> {
                String s = this.mWorkGenerationalId.getWorkSpecId();
                if(this.mCurrentState < 2) {
                    this.mCurrentState = 2;
                    Logger.get().debug("WM-DelayMetCommandHandl", "Stopping work for WorkSpec " + s);
                    Intent intent0 = CommandHandler.createStopWorkIntent(this.mContext, this.mWorkGenerationalId);
                    AddRunnable systemAlarmDispatcher$AddRunnable0 = new AddRunnable(this.mDispatcher, intent0, this.mStartId);
                    this.mMainThreadExecutor.execute(systemAlarmDispatcher$AddRunnable0);
                    if(this.mDispatcher.getProcessor().isEnqueued(this.mWorkGenerationalId.getWorkSpecId())) {
                        Logger.get().debug("WM-DelayMetCommandHandl", "WorkSpec " + s + " needs to be rescheduled");
                        Intent intent1 = CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkGenerationalId);
                        AddRunnable systemAlarmDispatcher$AddRunnable1 = new AddRunnable(this.mDispatcher, intent1, this.mStartId);
                        this.mMainThreadExecutor.execute(systemAlarmDispatcher$AddRunnable1);
                        return;
                    }
                    Logger.get().debug("WM-DelayMetCommandHandl", "Processor does not have WorkSpec " + s + ". No need to reschedule");
                    return;
                }
                Logger.get().debug("WM-DelayMetCommandHandl", "Already stopped work for " + s);
            };
            this.mSerialExecutor.execute(delayMetCommandHandler$$ExternalSyntheticLambda00);
            return;
        }
        boolean z = workSpec0.hasConstraints();
        this.mHasConstraints = z;
        if(!z) {
            Logger.get().debug("WM-DelayMetCommandHandl", "No constraints for " + s);
            this.onAllConstraintsMet(Collections.singletonList(workSpec0));
            return;
        }
        List list0 = Collections.singletonList(workSpec0);
        this.mWorkConstraintsTracker.replace(list0);
    }

    @Override  // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List workSpecs) {
        for(Object object0: workSpecs) {
            if(WorkSpecKt.generationalId(((WorkSpec)object0)).equals(this.mWorkGenerationalId)) {
                DelayMetCommandHandler..ExternalSyntheticLambda1 delayMetCommandHandler$$ExternalSyntheticLambda10 = () -> {
                    if(this.mCurrentState == 0) {
                        this.mCurrentState = 1;
                        Logger.get().debug("WM-DelayMetCommandHandl", "onAllConstraintsMet for " + this.mWorkGenerationalId);
                        if(this.mDispatcher.getProcessor().startWork(this.mToken)) {
                            this.mDispatcher.getWorkTimer().startTimer(this.mWorkGenerationalId, 600000L, this);
                            return;
                        }
                        this.cleanUp();
                        return;
                    }
                    Logger.get().debug("WM-DelayMetCommandHandl", "Already started work for " + this.mWorkGenerationalId);
                };
                this.mSerialExecutor.execute(delayMetCommandHandler$$ExternalSyntheticLambda10);
                return;
            }
            if(false) {
                break;
            }
        }
    }

    @Override  // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List workSpecs) {
        DelayMetCommandHandler..ExternalSyntheticLambda0 delayMetCommandHandler$$ExternalSyntheticLambda00 = () -> {
            String s = this.mWorkGenerationalId.getWorkSpecId();
            if(this.mCurrentState < 2) {
                this.mCurrentState = 2;
                Logger.get().debug("WM-DelayMetCommandHandl", "Stopping work for WorkSpec " + s);
                Intent intent0 = CommandHandler.createStopWorkIntent(this.mContext, this.mWorkGenerationalId);
                AddRunnable systemAlarmDispatcher$AddRunnable0 = new AddRunnable(this.mDispatcher, intent0, this.mStartId);
                this.mMainThreadExecutor.execute(systemAlarmDispatcher$AddRunnable0);
                if(this.mDispatcher.getProcessor().isEnqueued(this.mWorkGenerationalId.getWorkSpecId())) {
                    Logger.get().debug("WM-DelayMetCommandHandl", "WorkSpec " + s + " needs to be rescheduled");
                    Intent intent1 = CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkGenerationalId);
                    AddRunnable systemAlarmDispatcher$AddRunnable1 = new AddRunnable(this.mDispatcher, intent1, this.mStartId);
                    this.mMainThreadExecutor.execute(systemAlarmDispatcher$AddRunnable1);
                    return;
                }
                Logger.get().debug("WM-DelayMetCommandHandl", "Processor does not have WorkSpec " + s + ". No need to reschedule");
                return;
            }
            Logger.get().debug("WM-DelayMetCommandHandl", "Already stopped work for " + s);
        };
        this.mSerialExecutor.execute(delayMetCommandHandler$$ExternalSyntheticLambda00);
    }

    void onExecuted(boolean needsReschedule) {
        Logger.get().debug("WM-DelayMetCommandHandl", "onExecuted " + this.mWorkGenerationalId + ", " + needsReschedule);
        this.cleanUp();
        if(needsReschedule) {
            Intent intent0 = CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkGenerationalId);
            AddRunnable systemAlarmDispatcher$AddRunnable0 = new AddRunnable(this.mDispatcher, intent0, this.mStartId);
            this.mMainThreadExecutor.execute(systemAlarmDispatcher$AddRunnable0);
        }
        if(this.mHasConstraints) {
            Intent intent1 = CommandHandler.createConstraintsChangedIntent(this.mContext);
            AddRunnable systemAlarmDispatcher$AddRunnable1 = new AddRunnable(this.mDispatcher, intent1, this.mStartId);
            this.mMainThreadExecutor.execute(systemAlarmDispatcher$AddRunnable1);
        }
    }

    @Override  // androidx.work.impl.utils.WorkTimer$TimeLimitExceededListener
    public void onTimeLimitExceeded(WorkGenerationalId id) {
        Logger.get().debug("WM-DelayMetCommandHandl", "Exceeded time limits on execution for " + id);
        DelayMetCommandHandler..ExternalSyntheticLambda0 delayMetCommandHandler$$ExternalSyntheticLambda00 = () -> {
            String s = this.mWorkGenerationalId.getWorkSpecId();
            if(this.mCurrentState < 2) {
                this.mCurrentState = 2;
                Logger.get().debug("WM-DelayMetCommandHandl", "Stopping work for WorkSpec " + s);
                Intent intent0 = CommandHandler.createStopWorkIntent(this.mContext, this.mWorkGenerationalId);
                AddRunnable systemAlarmDispatcher$AddRunnable0 = new AddRunnable(this.mDispatcher, intent0, this.mStartId);
                this.mMainThreadExecutor.execute(systemAlarmDispatcher$AddRunnable0);
                if(this.mDispatcher.getProcessor().isEnqueued(this.mWorkGenerationalId.getWorkSpecId())) {
                    Logger.get().debug("WM-DelayMetCommandHandl", "WorkSpec " + s + " needs to be rescheduled");
                    Intent intent1 = CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkGenerationalId);
                    AddRunnable systemAlarmDispatcher$AddRunnable1 = new AddRunnable(this.mDispatcher, intent1, this.mStartId);
                    this.mMainThreadExecutor.execute(systemAlarmDispatcher$AddRunnable1);
                    return;
                }
                Logger.get().debug("WM-DelayMetCommandHandl", "Processor does not have WorkSpec " + s + ". No need to reschedule");
                return;
            }
            Logger.get().debug("WM-DelayMetCommandHandl", "Already stopped work for " + s);
        };
        this.mSerialExecutor.execute(delayMetCommandHandler$$ExternalSyntheticLambda00);
    }

    // 检测为 Lambda 实现
    private void startWork() [...]

    // 检测为 Lambda 实现
    private void stopWork() [...]
}

