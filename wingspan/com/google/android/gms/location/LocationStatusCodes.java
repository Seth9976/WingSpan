package com.google.android.gms.location;

import com.google.android.gms.common.api.Status;

@Deprecated
public final class LocationStatusCodes {
    public static final int ERROR = 1;
    public static final int GEOFENCE_NOT_AVAILABLE = 1000;
    public static final int GEOFENCE_TOO_MANY_GEOFENCES = 1001;
    public static final int GEOFENCE_TOO_MANY_PENDING_INTENTS = 1002;
    public static final int SUCCESS;

    // 去混淆评级： 低(20)
    public static int zza(int v) {
        return (v < 0 || v > 1) && (v < 1000 || v >= 1006) ? 1 : v;
    }

    public static Status zzb(int v) {
        if(v == 1) {
            v = 13;
        }
        return new Status(v);
    }
}

