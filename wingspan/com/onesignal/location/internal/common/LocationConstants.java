package com.onesignal.location.internal.common;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/onesignal/location/internal/common/LocationConstants;", "", "()V", "ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING", "", "ANDROID_COARSE_LOCATION_PERMISSION_STRING", "ANDROID_FINE_LOCATION_PERMISSION_STRING", "BACKGROUND_UPDATE_TIME_MS", "", "FOREGROUND_UPDATE_TIME_MS", "TIME_BACKGROUND_SEC", "TIME_FOREGROUND_SEC", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LocationConstants {
    public static final String ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING = "android.permission.ACCESS_BACKGROUND_LOCATION";
    public static final String ANDROID_COARSE_LOCATION_PERMISSION_STRING = "android.permission.ACCESS_COARSE_LOCATION";
    public static final String ANDROID_FINE_LOCATION_PERMISSION_STRING = "android.permission.ACCESS_FINE_LOCATION";
    public static final long BACKGROUND_UPDATE_TIME_MS = 570000L;
    public static final long FOREGROUND_UPDATE_TIME_MS = 270000L;
    public static final LocationConstants INSTANCE = null;
    public static final long TIME_BACKGROUND_SEC = 600L;
    public static final long TIME_FOREGROUND_SEC = 300L;

    static {
        LocationConstants.INSTANCE = new LocationConstants();
    }
}

