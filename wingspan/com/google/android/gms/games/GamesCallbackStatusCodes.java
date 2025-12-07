package com.google.android.gms.games;

public final class GamesCallbackStatusCodes {
    @Deprecated
    public static final int CLIENT_RECONNECT_REQUIRED = 2;
    public static final int INTERNAL_ERROR = 1;
    public static final int OK;

    public static String getStatusCodeString(int v) {
        switch(v) {
            case 0: {
                return "OK";
            }
            case 1: {
                return "INTERNAL_ERROR";
            }
            case 2: {
                return "CLIENT_RECONNECT_REQUIRED";
            }
            case 6003: {
                return "MULTIPLAYER_DISABLED";
            }
            case 7000: {
                return "REAL_TIME_CONNECTION_FAILED";
            }
            case 7001: {
                return "REAL_TIME_MESSAGE_SEND_FAILED";
            }
            case 7004: {
                return "REAL_TIME_ROOM_NOT_JOINED";
            }
            default: {
                return "unknown games callback status code: " + v;
            }
        }
    }
}

