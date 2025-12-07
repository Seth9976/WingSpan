package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u000E\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0011H\u0016R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0010\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000F¨\u0006\u0013"}, d2 = {"Landroidx/work/impl/constraints/trackers/NetworkStateTracker24;", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "Landroidx/work/impl/constraints/NetworkState;", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "initialState", "getInitialState", "()Landroidx/work/impl/constraints/NetworkState;", "networkCallback", "androidx/work/impl/constraints/trackers/NetworkStateTracker24$networkCallback$1", "Landroidx/work/impl/constraints/trackers/NetworkStateTracker24$networkCallback$1;", "startTracking", "", "stopTracking", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NetworkStateTracker24 extends ConstraintTracker {
    private final ConnectivityManager connectivityManager;
    private final androidx.work.impl.constraints.trackers.NetworkStateTracker24.networkCallback.1 networkCallback;

    public NetworkStateTracker24(Context context0, TaskExecutor taskExecutor0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(taskExecutor0, "taskExecutor");
        super(context0, taskExecutor0);
        Object object0 = this.getAppContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager)object0;
        this.networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override  // android.net.ConnectivityManager$NetworkCallback
            public void onCapabilitiesChanged(Network network0, NetworkCapabilities networkCapabilities0) {
                Intrinsics.checkNotNullParameter(network0, "network");
                Intrinsics.checkNotNullParameter(networkCapabilities0, "capabilities");
                Logger.get().debug("WM-NetworkStateTracker", "Network capabilities changed: " + networkCapabilities0);
                NetworkState networkState0 = NetworkStateTrackerKt.getActiveNetworkState(NetworkStateTracker24.this.connectivityManager);
                NetworkStateTracker24.this.setState(networkState0);
            }

            @Override  // android.net.ConnectivityManager$NetworkCallback
            public void onLost(Network network0) {
                Intrinsics.checkNotNullParameter(network0, "network");
                Logger.get().debug("WM-NetworkStateTracker", "Network connection lost");
                NetworkState networkState0 = NetworkStateTrackerKt.getActiveNetworkState(NetworkStateTracker24.this.connectivityManager);
                NetworkStateTracker24.this.setState(networkState0);
            }
        };
    }

    public NetworkState getInitialState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }

    @Override  // androidx.work.impl.constraints.trackers.ConstraintTracker
    public Object getInitialState() {
        return this.getInitialState();
    }

    @Override  // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void startTracking() {
        try {
            Logger.get().debug("WM-NetworkStateTracker", "Registering network callback");
            NetworkApi24.registerDefaultNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            Logger.get().error("WM-NetworkStateTracker", "Received exception while registering network callback", illegalArgumentException0);
        }
        catch(SecurityException securityException0) {
            Logger.get().error("WM-NetworkStateTracker", "Received exception while registering network callback", securityException0);
        }
    }

    @Override  // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void stopTracking() {
        try {
            Logger.get().debug("WM-NetworkStateTracker", "Unregistering network callback");
            NetworkApi21.unregisterNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            Logger.get().error("WM-NetworkStateTracker", "Received exception while unregistering network callback", illegalArgumentException0);
        }
        catch(SecurityException securityException0) {
            Logger.get().error("WM-NetworkStateTracker", "Received exception while unregistering network callback", securityException0);
        }
    }
}

