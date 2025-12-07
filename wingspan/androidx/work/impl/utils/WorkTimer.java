package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;
import java.util.Map;

public class WorkTimer {
    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(WorkGenerationalId arg1);
    }

    public static class WorkTimerRunnable implements Runnable {
        static final String TAG = "WrkTimerRunnable";
        private final WorkGenerationalId mWorkGenerationalId;
        private final WorkTimer mWorkTimer;

        WorkTimerRunnable(WorkTimer workTimer, WorkGenerationalId id) {
            this.mWorkTimer = workTimer;
            this.mWorkGenerationalId = id;
        }

        @Override
        public void run() {
            synchronized(this.mWorkTimer.mLock) {
                if(((WorkTimerRunnable)this.mWorkTimer.mTimerMap.remove(this.mWorkGenerationalId)) == null) {
                    Logger.get().debug("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.mWorkGenerationalId));
                }
                else {
                    TimeLimitExceededListener workTimer$TimeLimitExceededListener0 = (TimeLimitExceededListener)this.mWorkTimer.mListeners.remove(this.mWorkGenerationalId);
                    if(workTimer$TimeLimitExceededListener0 != null) {
                        workTimer$TimeLimitExceededListener0.onTimeLimitExceeded(this.mWorkGenerationalId);
                    }
                }
            }
        }
    }

    private static final String TAG;
    final Map mListeners;
    final Object mLock;
    final RunnableScheduler mRunnableScheduler;
    final Map mTimerMap;

    static {
        WorkTimer.TAG = "WM-WorkTimer";
    }

    public WorkTimer(RunnableScheduler scheduler) {
        this.mTimerMap = new HashMap();
        this.mListeners = new HashMap();
        this.mLock = new Object();
        this.mRunnableScheduler = scheduler;
    }

    public Map getListeners() {
        synchronized(this.mLock) {
        }
        return this.mListeners;
    }

    public Map getTimerMap() {
        synchronized(this.mLock) {
        }
        return this.mTimerMap;
    }

    public void startTimer(WorkGenerationalId id, long processingTimeMillis, TimeLimitExceededListener listener) {
        synchronized(this.mLock) {
            Logger.get().debug("WM-WorkTimer", "Starting timer for " + id);
            this.stopTimer(id);
            WorkTimerRunnable workTimer$WorkTimerRunnable0 = new WorkTimerRunnable(this, id);
            this.mTimerMap.put(id, workTimer$WorkTimerRunnable0);
            this.mListeners.put(id, listener);
            this.mRunnableScheduler.scheduleWithDelay(processingTimeMillis, workTimer$WorkTimerRunnable0);
        }
    }

    public void stopTimer(WorkGenerationalId id) {
        synchronized(this.mLock) {
            if(((WorkTimerRunnable)this.mTimerMap.remove(id)) != null) {
                Logger.get().debug("WM-WorkTimer", "Stopping timer for " + id);
                this.mListeners.remove(id);
            }
        }
    }
}

