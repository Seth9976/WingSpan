package com.gameanalytics.sdk.logging;

import android.util.Log;

public class GALogger {
    private static final GALogger INSTANCE = null;
    private static final String TAG = "GameAnalytics";
    private boolean debugEnabled;
    private boolean infoLogAdvancedEnabled;
    private boolean infoLogEnabled;

    static {
        GALogger.INSTANCE = new GALogger();
    }

    public static void d(String format) {
        if(!GALogger.getInstance().debugEnabled) {
            return;
        }
        GALogger.getInstance().sendNotificationMessage("Debug/GameAnalytics: " + format, EGALoggerMessageType.Debug);
    }

    public static void e(String format) {
        GALogger.getInstance().sendNotificationMessage("Error/GameAnalytics: " + format, EGALoggerMessageType.Error);
    }

    public static boolean getAdvancedInfoLog() [...] // 潜在的解密器

    public static boolean getInfoLog() [...] // 潜在的解密器

    private static GALogger getInstance() {
        return GALogger.INSTANCE;
    }

    public static void i(String format) {
        if(!GALogger.getInstance().infoLogEnabled) {
            return;
        }
        GALogger.getInstance().sendNotificationMessage("Info/GameAnalytics: " + format, EGALoggerMessageType.Info);
    }

    public static void ii(String format) {
        if(!GALogger.getInstance().infoLogAdvancedEnabled) {
            return;
        }
        GALogger.getInstance().sendNotificationMessage("Verbose/GameAnalytics: " + format, EGALoggerMessageType.Info);
    }

    public void sendNotificationMessage(String message, EGALoggerMessageType type) {
        switch(type) {
            case 1: {
                Log.e("GameAnalytics", message);
                return;
            }
            case 2: {
                Log.w("GameAnalytics", message);
                return;
            }
            case 3: {
                Log.d("GameAnalytics", message);
                return;
            }
            case 4: {
                Log.i("GameAnalytics", message);
            }
        }
    }

    public static void setAdvancedInfoLog(boolean enabled) {
        GALogger.getInstance().infoLogAdvancedEnabled = enabled;
    }

    public static void setInfoLog(boolean enabled) {
        GALogger.getInstance().infoLogEnabled = enabled;
    }

    public static void w(String format) {
        GALogger.getInstance().sendNotificationMessage("Warning/GameAnalytics: " + format, EGALoggerMessageType.Warning);
    }
}

