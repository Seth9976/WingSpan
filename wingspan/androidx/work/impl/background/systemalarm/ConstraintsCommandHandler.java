package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.ArrayList;
import java.util.List;

class ConstraintsCommandHandler {
    private static final String TAG;
    private final Context mContext;
    private final SystemAlarmDispatcher mDispatcher;
    private final int mStartId;
    private final WorkConstraintsTrackerImpl mWorkConstraintsTracker;

    static {
        ConstraintsCommandHandler.TAG = "WM-ConstraintsCmdHandle";
    }

    ConstraintsCommandHandler(Context context, int startId, SystemAlarmDispatcher dispatcher) {
        this.mContext = context;
        this.mStartId = startId;
        this.mDispatcher = dispatcher;
        this.mWorkConstraintsTracker = new WorkConstraintsTrackerImpl(dispatcher.getWorkManager().getTrackers(), null);
    }

    void handleConstraintsChanged() {
        List list0 = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getScheduledWork();
        ConstraintProxy.updateAll(this.mContext, list0);
        this.mWorkConstraintsTracker.replace(list0);
        ArrayList arrayList0 = new ArrayList(list0.size());
        long v = System.currentTimeMillis();
        for(Object object0: list0) {
            WorkSpec workSpec0 = (WorkSpec)object0;
            if(v >= workSpec0.calculateNextRunTime() && (!workSpec0.hasConstraints() || this.mWorkConstraintsTracker.areAllConstraintsMet(workSpec0.id))) {
                arrayList0.add(workSpec0);
            }
        }
        for(Object object1: arrayList0) {
            WorkGenerationalId workGenerationalId0 = WorkSpecKt.generationalId(((WorkSpec)object1));
            Intent intent0 = CommandHandler.createDelayMetIntent(this.mContext, workGenerationalId0);
            Logger.get().debug("WM-ConstraintsCmdHandle", "Creating a delay_met command for workSpec with id (" + ((WorkSpec)object1).id + ")");
            this.mDispatcher.getTaskExecutor().getMainThreadExecutor().execute(new AddRunnable(this.mDispatcher, intent0, this.mStartId));
        }
        this.mWorkConstraintsTracker.reset();
    }
}

