package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;

public class SystemAlarmScheduler implements Scheduler {
    private static final String TAG;
    private final Context mContext;

    static {
        SystemAlarmScheduler.TAG = "WM-SystemAlarmScheduler";
    }

    public SystemAlarmScheduler(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override  // androidx.work.impl.Scheduler
    public void cancel(String workSpecId) {
        Intent intent0 = CommandHandler.createStopWorkIntent(this.mContext, workSpecId);
        this.mContext.startService(intent0);
    }

    @Override  // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override  // androidx.work.impl.Scheduler
    public void schedule(WorkSpec[] workSpecs) {
        for(int v = 0; v < workSpecs.length; ++v) {
            this.scheduleWorkSpec(workSpecs[v]);
        }
    }

    private void scheduleWorkSpec(WorkSpec workSpec) {
        Logger.get().debug("WM-SystemAlarmScheduler", "Scheduling work with workSpecId " + workSpec.id);
        WorkGenerationalId workGenerationalId0 = WorkSpecKt.generationalId(workSpec);
        Intent intent0 = CommandHandler.createScheduleWorkIntent(this.mContext, workGenerationalId0);
        this.mContext.startService(intent0);
    }
}

