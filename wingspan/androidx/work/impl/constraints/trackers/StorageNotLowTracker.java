package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0016R\u0014\u0010\b\u001A\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0013"}, d2 = {"Landroidx/work/impl/constraints/trackers/StorageNotLowTracker;", "Landroidx/work/impl/constraints/trackers/BroadcastReceiverConstraintTracker;", "", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "initialState", "getInitialState", "()Ljava/lang/Boolean;", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "onBroadcastReceive", "", "intent", "Landroid/content/Intent;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class StorageNotLowTracker extends BroadcastReceiverConstraintTracker {
    public StorageNotLowTracker(Context context0, TaskExecutor taskExecutor0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(taskExecutor0, "taskExecutor");
        super(context0, taskExecutor0);
    }

    public Boolean getInitialState() {
        Intent intent0 = this.getAppContext().registerReceiver(null, this.getIntentFilter());
        boolean z = true;
        if(intent0 != null && intent0.getAction() != null) {
            String s = intent0.getAction();
            if(s == null || s.hashCode() != -730838620 || !s.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }

    @Override  // androidx.work.impl.constraints.trackers.ConstraintTracker
    public Object getInitialState() {
        return this.getInitialState();
    }

    @Override  // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter0.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter0;
    }

    @Override  // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void onBroadcastReceive(Intent intent0) {
        Intrinsics.checkNotNullParameter(intent0, "intent");
        if(intent0.getAction() == null) {
            return;
        }
        Logger.get().debug("WM-StorageNotLowTracker", "Received " + intent0.getAction());
        String s = intent0.getAction();
        if(s != null) {
            switch(s) {
                case "android.intent.action.DEVICE_STORAGE_LOW": {
                    this.setState(Boolean.FALSE);
                    break;
                }
                case "android.intent.action.DEVICE_STORAGE_OK": {
                    this.setState(Boolean.TRUE);
                }
            }
        }
    }
}

