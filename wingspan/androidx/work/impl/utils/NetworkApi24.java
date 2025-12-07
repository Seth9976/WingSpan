package androidx.work.impl.utils;

import android.net.ConnectivityManager.NetworkCallback;
import android.net.ConnectivityManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"registerDefaultNetworkCallbackCompat", "", "Landroid/net/ConnectivityManager;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class NetworkApi24 {
    public static final void registerDefaultNetworkCallbackCompat(ConnectivityManager connectivityManager0, ConnectivityManager.NetworkCallback connectivityManager$NetworkCallback0) {
        Intrinsics.checkNotNullParameter(connectivityManager0, "<this>");
        Intrinsics.checkNotNullParameter(connectivityManager$NetworkCallback0, "networkCallback");
        connectivityManager0.registerDefaultNetworkCallback(connectivityManager$NetworkCallback0);
    }
}

