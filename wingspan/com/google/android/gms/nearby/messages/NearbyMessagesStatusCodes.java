package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.api.CommonStatusCodes;

public class NearbyMessagesStatusCodes extends CommonStatusCodes {
    public static final int APP_NOT_OPTED_IN = 0xAF2;
    public static final int APP_QUOTA_LIMIT_REACHED = 0xAF4;
    public static final int BLE_ADVERTISING_UNSUPPORTED = 0xB05;
    public static final int BLE_SCANNING_UNSUPPORTED = 0xB06;
    public static final int BLUETOOTH_OFF = 0xB04;
    public static final int DISALLOWED_CALLING_CONTEXT = 0xAF3;
    public static final int FORBIDDEN = 0xAF6;
    public static final int MISSING_PERMISSIONS = 0xAF7;
    public static final int NOT_AUTHORIZED = 0xAF5;
    public static final int TOO_MANY_PENDING_INTENTS = 0xAF1;

    @Override  // com.google.android.gms.common.api.CommonStatusCodes
    public static String getStatusCodeString(int v) {
        switch(v) {
            case 0xAF1: {
                return "TOO_MANY_PENDING_INTENTS";
            }
            case 0xAF2: {
                return "APP_NOT_OPTED_IN";
            }
            case 0xAF3: {
                return "DISALLOWED_CALLING_CONTEXT";
            }
            case 0xAF5: {
                return "NOT_AUTHORIZED";
            }
            case 0xAF6: {
                return "FORBIDDEN";
            }
            case 0xB04: {
                return "BLUETOOTH_OFF";
            }
            case 0xB05: {
                return "BLE_ADVERTISING_UNSUPPORTED";
            }
            case 0xB06: {
                return "BLE_SCANNING_UNSUPPORTED";
            }
            default: {
                return CommonStatusCodes.getStatusCodeString(v);
            }
        }
    }
}

