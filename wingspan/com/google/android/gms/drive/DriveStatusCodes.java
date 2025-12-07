package com.google.android.gms.drive;

import com.google.android.gms.common.api.CommonStatusCodes;

public final class DriveStatusCodes extends CommonStatusCodes {
    public static final int DRIVE_CONTENTS_TOO_LARGE = 1508;
    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int DRIVE_RATE_LIMIT_EXCEEDED = 1507;
    public static final int DRIVE_RESOURCE_NOT_AVAILABLE = 1502;

    @Override  // com.google.android.gms.common.api.CommonStatusCodes
    public static String getStatusCodeString(int v) {
        if(v != 3004) {
            switch(v) {
                case 1501: {
                    return "DRIVE_RESOURCE_ALREADY_EXISTS";
                }
                case 1502: {
                    return "DRIVE_RESOURCE_NOT_AVAILABLE";
                }
                case 0x5DF: {
                    return "DRIVE_RESOURCE_FORBIDDEN";
                }
                case 0x5E0: {
                    return "DRIVE_REALTIME_CONCURRENT_CREATION";
                }
                case 1505: {
                    return "DRIVE_REALTIME_INVALID_COMPOUND_OP";
                }
                case 1506: {
                    return "DRIVE_FULL_SYNC_REQUIRED";
                }
                case 1507: {
                    return "DRIVE_RATE_LIMIT_EXCEEDED";
                }
                case 1508: {
                    return "DRIVE_CONTENTS_TOO_LARGE";
                }
                case 1509: {
                    return "DRIVE_RESOURCE_PERMISSION_FORBIDDEN";
                }
                case 1510: {
                    return "DRIVE_INAPPLICABLE_OPERATION";
                }
                case 0x5E7: {
                    return "DRIVE_INSUFFICIENT_SCOPES";
                }
                default: {
                    return CommonStatusCodes.getStatusCodeString(v);
                }
            }
        }
        return "DRIVE_REALTIME_TOKEN_REFRESH_REQUIRED";
    }
}

