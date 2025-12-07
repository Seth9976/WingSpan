package com.google.android.gms.drive;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface TransferPreferences {
    @Retention(RetentionPolicy.SOURCE)
    public @interface BatteryUsage {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NetworkType {
    }

    public static final int BATTERY_USAGE_CHARGING_ONLY = 0x101;
    public static final int BATTERY_USAGE_UNKNOWN = 0;
    public static final int BATTERY_USAGE_UNRESTRICTED = 0x100;
    public static final int NETWORK_TYPE_ANY = 1;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI_ONLY = 2;

    int getBatteryUsagePreference();

    int getNetworkPreference();

    boolean isRoamingAllowed();
}

