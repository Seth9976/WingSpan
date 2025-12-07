package com.google.android.gms.drive;

@Deprecated
public interface FileUploadPreferences {
    public static final int BATTERY_USAGE_CHARGING_ONLY = 0x101;
    public static final int BATTERY_USAGE_UNRESTRICTED = 0x100;
    public static final int NETWORK_TYPE_ANY = 1;
    public static final int NETWORK_TYPE_WIFI_ONLY = 2;
    public static final int PREFERENCE_VALUE_UNKNOWN;

    int getBatteryUsagePreference();

    int getNetworkTypePreference();

    boolean isRoamingAllowed();

    void setBatteryUsagePreference(int arg1);

    void setNetworkTypePreference(int arg1);

    void setRoamingAllowed(boolean arg1);
}

