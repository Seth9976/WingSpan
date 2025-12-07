package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000F\u001A\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u0011H\u0002J\u0010\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0010\u001A\u00020\u0011H\u0016R\u0014\u0010\b\u001A\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0014"}, d2 = {"Landroidx/work/impl/constraints/trackers/BatteryChargingTracker;", "Landroidx/work/impl/constraints/trackers/BroadcastReceiverConstraintTracker;", "", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "initialState", "getInitialState", "()Ljava/lang/Boolean;", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "isBatteryChangedIntentCharging", "intent", "Landroid/content/Intent;", "onBroadcastReceive", "", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class BatteryChargingTracker extends BroadcastReceiverConstraintTracker {
    public BatteryChargingTracker(Context context0, TaskExecutor taskExecutor0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(taskExecutor0, "taskExecutor");
        super(context0, taskExecutor0);
    }

    public Boolean getInitialState() {
        IntentFilter intentFilter0 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent intent0 = this.getAppContext().registerReceiver(null, intentFilter0);
        if(intent0 == null) {
            Logger.get().error("WM-BatteryChrgTracker", "getInitialState - null intent received");
            return false;
        }
        return Boolean.valueOf(this.isBatteryChangedIntentCharging(intent0));
    }

    @Override  // androidx.work.impl.constraints.trackers.ConstraintTracker
    public Object getInitialState() {
        return this.getInitialState();
    }

    @Override  // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("android.os.action.CHARGING");
        intentFilter0.addAction("android.os.action.DISCHARGING");
        return intentFilter0;
    }

    private final boolean isBatteryChangedIntentCharging(Intent intent0) {
        switch(intent0.getIntExtra("status", -1)) {
            case 2: 
            case 5: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    @Override  // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void onBroadcastReceive(Intent intent0) {
        Intrinsics.checkNotNullParameter(intent0, "intent");
        String s = intent0.getAction();
        if(s == null) {
            return;
        }
        Logger.get().debug("WM-BatteryChrgTracker", "Received " + s);
        switch(s) {
            case "android.intent.action.ACTION_POWER_CONNECTED": {
                this.setState(Boolean.TRUE);
                return;
            }
            case "android.intent.action.ACTION_POWER_DISCONNECTED": {
                this.setState(Boolean.FALSE);
                return;
            }
            case "android.os.action.CHARGING": {
                this.setState(Boolean.TRUE);
                return;
            }
            case "android.os.action.DISCHARGING": {
                this.setState(Boolean.FALSE);
            }
        }
    }
}

