package com.onesignal.location.internal.common;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.LocationListener;
import com.huawei.hms.location.LocationCallback;
import com.onesignal.common.AndroidUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001A\u00020\u0004J\u0006\u0010\u0005\u001A\u00020\u0004J\u000E\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\b¨\u0006\t"}, d2 = {"Lcom/onesignal/location/internal/common/LocationUtils;", "", "()V", "hasGMSLocationLibrary", "", "hasHMSLocationLibrary", "hasLocationPermission", "context", "Landroid/content/Context;", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LocationUtils {
    public static final LocationUtils INSTANCE;

    static {
        LocationUtils.INSTANCE = new LocationUtils();
    }

    public final boolean hasGMSLocationLibrary() {
        try {
            return AndroidUtils.INSTANCE.opaqueHasClass(LocationListener.class);
        }
        catch(NoClassDefFoundError unused_ex) {
            return false;
        }
    }

    public final boolean hasHMSLocationLibrary() {
        try {
            return AndroidUtils.INSTANCE.opaqueHasClass(LocationCallback.class);
        }
        catch(NoClassDefFoundError unused_ex) {
            return false;
        }
    }

    public final boolean hasLocationPermission(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        return ContextCompat.checkSelfPermission(context0, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(context0, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }
}

