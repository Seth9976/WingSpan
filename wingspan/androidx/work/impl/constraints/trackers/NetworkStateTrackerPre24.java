package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\r\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Landroidx/work/impl/constraints/trackers/NetworkStateTrackerPre24;", "Landroidx/work/impl/constraints/trackers/BroadcastReceiverConstraintTracker;", "Landroidx/work/impl/constraints/NetworkState;", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "initialState", "getInitialState", "()Landroidx/work/impl/constraints/NetworkState;", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter$annotations", "()V", "getIntentFilter", "()Landroid/content/IntentFilter;", "onBroadcastReceive", "", "intent", "Landroid/content/Intent;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NetworkStateTrackerPre24 extends BroadcastReceiverConstraintTracker {
    private final ConnectivityManager connectivityManager;

    public NetworkStateTrackerPre24(Context context0, TaskExecutor taskExecutor0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(taskExecutor0, "taskExecutor");
        super(context0, taskExecutor0);
        Object object0 = this.getAppContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager)object0;
    }

    public NetworkState getInitialState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }

    @Override  // androidx.work.impl.constraints.trackers.ConstraintTracker
    public Object getInitialState() {
        return this.getInitialState();
    }

    @Override  // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter getIntentFilter() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    public static void getIntentFilter$annotations() {
    }

    @Override  // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void onBroadcastReceive(Intent intent0) {
        Intrinsics.checkNotNullParameter(intent0, "intent");
        if(Intrinsics.areEqual(intent0.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
            Logger.get().debug("WM-NetworkStateTracker", "Network broadcast received");
            this.setState(NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager));
        }
    }
}

