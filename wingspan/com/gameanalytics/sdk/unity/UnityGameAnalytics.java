package com.gameanalytics.sdk.unity;

import com.gameanalytics.sdk.GameAnalytics;
import com.gameanalytics.sdk.IRemoteConfigsListener;
import com.gameanalytics.sdk.logging.GALogger;
import com.unity3d.player.UnityPlayer;

public class UnityGameAnalytics {
    private static final String GameAnalyticsGameObjectName = "GameAnalytics";
    private static final String OnRemoteConfigsUpdatedMethodName = "OnRemoteConfigsUpdated";
    private static final IRemoteConfigsListener remoteConfigsListener;

    static {
        UnityGameAnalytics.remoteConfigsListener = new IRemoteConfigsListener() {
            @Override  // com.gameanalytics.sdk.IRemoteConfigsListener
            public void onRemoteConfigsUpdated() {
                GALogger.d("UnityGameAnalytics: onRemoteConfigsUpdated called");
                UnityPlayer.UnitySendMessage("GameAnalytics", "OnRemoteConfigsUpdated", "");
            }
        };
    }

    public static void initialize() {
        GALogger.d("UnityGameAnalytics: initialize called");
        GameAnalytics.addRemoteConfigsListener(UnityGameAnalytics.remoteConfigsListener);
    }
}

