package androidx.core.app;

import android.app.ActivityManager;

public final class ActivityManagerCompat {
    public static boolean isLowRamDevice(ActivityManager activityManager0) {
        return activityManager0.isLowRamDevice();
    }
}

