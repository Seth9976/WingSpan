package androidx.work.impl.background.greedy;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

public class DelayedWorkTracker {
    static final String TAG;
    final GreedyScheduler mGreedyScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map mRunnables;

    static {
        DelayedWorkTracker.TAG = "WM-DelayedWorkTracker";
    }

    public DelayedWorkTracker(GreedyScheduler scheduler, RunnableScheduler runnableScheduler) {
        this.mGreedyScheduler = scheduler;
        this.mRunnableScheduler = runnableScheduler;
        this.mRunnables = new HashMap();
    }

    public void schedule(WorkSpec workSpec) {
        Runnable runnable0 = (Runnable)this.mRunnables.remove(workSpec.id);
        if(runnable0 != null) {
            this.mRunnableScheduler.cancel(runnable0);
        }
        androidx.work.impl.background.greedy.DelayedWorkTracker.1 delayedWorkTracker$10 = new Runnable() {
            @Override
            public void run() {
                Logger.get().debug("WM-DelayedWorkTracker", "Scheduling work " + workSpec.id);
                DelayedWorkTracker.this.mGreedyScheduler.schedule(new WorkSpec[]{workSpec});
            }
        };
        this.mRunnables.put(workSpec.id, delayedWorkTracker$10);
        long v = workSpec.calculateNextRunTime();
        this.mRunnableScheduler.scheduleWithDelay(v - System.currentTimeMillis(), delayedWorkTracker$10);
    }

    public void unschedule(String workSpecId) {
        Runnable runnable0 = (Runnable)this.mRunnables.remove(workSpecId);
        if(runnable0 != null) {
            this.mRunnableScheduler.cancel(runnable0);
        }
    }
}

