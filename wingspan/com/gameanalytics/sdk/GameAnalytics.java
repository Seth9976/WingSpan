package com.gameanalytics.sdk;

import android.app.Activity;
import com.gameanalytics.sdk.device.GADevice.DeviceInfo;
import com.gameanalytics.sdk.device.GADevice;
import com.gameanalytics.sdk.events.EGASdkErrorAction;
import com.gameanalytics.sdk.events.EGASdkErrorArea;
import com.gameanalytics.sdk.events.EGASdkErrorCategory;
import com.gameanalytics.sdk.events.GAEvents;
import com.gameanalytics.sdk.http.GAHTTPApi;
import com.gameanalytics.sdk.logging.GALogger;
import com.gameanalytics.sdk.state.GAState;
import com.gameanalytics.sdk.store.GAStore;
import com.gameanalytics.sdk.threading.GAThreading;
import com.gameanalytics.sdk.threading.IBlock;
import com.gameanalytics.sdk.utilities.Stopwatch;
import com.gameanalytics.sdk.validators.GAValidator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class GameAnalytics {
    public static final String BANNER = "BANNER";
    public static final String INTERSTITIAL = "INTERSTITIAL";
    private static final int MAX_RETRIES = 500;
    public static final String NATIVE = "NATIVE";
    public static final String REWARDED_INTERSTITIAL = "REWARDED_INTERSTITIAL";
    public static final String REWARDED_VIDEO = "REWARDED_VIDEO";
    private static int currentRetries;

    static {
    }

    static int access$300() [...] // 潜在的解密器

    static int access$304() {
        int v = GameAnalytics.currentRetries + 1;
        GameAnalytics.currentRetries = v;
        return v;
    }

    public static void addAdEvent(int adAction, int adType, String adSdkName, String adPlacement) {
        GameAnalytics.addAdEvent(GAAdAction.valueOf(adAction), GAAdType.valueOf(adType), adSdkName, adPlacement, null);
    }

    public static void addAdEvent(int adAction, int adType, String adSdkName, String adPlacement, int noAdReason) {
        GameAnalytics.addAdEvent(GAAdAction.valueOf(adAction), GAAdType.valueOf(adType), adSdkName, adPlacement, GAAdError.valueOf(noAdReason), null);
    }

    public static void addAdEvent(int adAction, int adType, String adSdkName, String adPlacement, int noAdReason, String customFields) {
        GameAnalytics.addAdEvent(GAAdAction.valueOf(adAction), GAAdType.valueOf(adType), adSdkName, adPlacement, GAAdError.valueOf(noAdReason), GameAnalytics.jsonStringToMap(customFields), false);
    }

    public static void addAdEvent(int adAction, int adType, String adSdkName, String adPlacement, int noAdReason, String customFields, boolean mergeFields) {
        GameAnalytics.addAdEvent(GAAdAction.valueOf(adAction), GAAdType.valueOf(adType), adSdkName, adPlacement, GAAdError.valueOf(noAdReason), GameAnalytics.jsonStringToMap(customFields), mergeFields);
    }

    public static void addAdEvent(int adAction, int adType, String adSdkName, String adPlacement, long duration) {
        GameAnalytics.addAdEvent(GAAdAction.valueOf(adAction), GAAdType.valueOf(adType), adSdkName, adPlacement, duration, null);
    }

    public static void addAdEvent(int adAction, int adType, String adSdkName, String adPlacement, long duration, String customFields) {
        GameAnalytics.addAdEvent(GAAdAction.valueOf(adAction), GAAdType.valueOf(adType), adSdkName, adPlacement, duration, GameAnalytics.jsonStringToMap(customFields), false);
    }

    public static void addAdEvent(int adAction, int adType, String adSdkName, String adPlacement, long duration, String customFields, boolean mergeFields) {
        GameAnalytics.addAdEvent(GAAdAction.valueOf(adAction), GAAdType.valueOf(adType), adSdkName, adPlacement, duration, GameAnalytics.jsonStringToMap(customFields), mergeFields);
    }

    public static void addAdEvent(int adAction, int adType, String adSdkName, String adPlacement, String customFields) {
        GameAnalytics.addAdEvent(GAAdAction.valueOf(adAction), GAAdType.valueOf(adType), adSdkName, adPlacement, GameAnalytics.jsonStringToMap(customFields), false);
    }

    public static void addAdEvent(int adAction, int adType, String adSdkName, String adPlacement, String customFields, boolean mergeFields) {
        GameAnalytics.addAdEvent(GAAdAction.valueOf(adAction), GAAdType.valueOf(adType), adSdkName, adPlacement, GameAnalytics.jsonStringToMap(customFields), mergeFields);
    }

    public static void addAdEvent(GAAdAction adAction, GAAdType adType, String adSdkName, String adPlacement) {
        GameAnalytics.addAdEvent(adAction, adType, adSdkName, adPlacement, null);
    }

    public static void addAdEvent(GAAdAction adAction, GAAdType adType, String adSdkName, String adPlacement, long duration) {
        GameAnalytics.addAdEvent(adAction, adType, adSdkName, adPlacement, duration, null);
    }

    public static void addAdEvent(GAAdAction adAction, GAAdType adType, String adSdkName, String adPlacement, long duration, Map customFields) {
        GameAnalytics.addAdEvent(adAction, adType, adSdkName, adPlacement, duration, customFields, false);
    }

    public static void addAdEvent(GAAdAction adAction, GAAdType adType, String adSdkName, String adPlacement, long duration, Map customFields, boolean mergeFields) {
        if(GAState.isInitialized()) {
            GAThreading.performTaskOnGAThread(new IBlock() {
                @Override  // com.gameanalytics.sdk.threading.IBlock
                public void execute() {
                    if(!GameAnalytics.isSdkReady(true, true, "Could not add ad event")) {
                        return;
                    }
                    GAEvents.addAdEvent(adAction, adType, adSdkName, adPlacement, GAAdError.Undefined, duration, true, customFields, mergeFields);
                }

                @Override  // com.gameanalytics.sdk.threading.IBlock
                public String getName() {
                    return "addAdEvent";
                }
            });
            return;
        }
        GAThreading.performTaskDelayed(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(true, false, "Could not ad error event")) {
                    if(!GAState.isInitialized()) {
                        GameAnalytics.addAdEvent(adAction, adType, adSdkName, adPlacement, duration, customFields, mergeFields);
                        GameAnalytics.access$304();
                    }
                    return;
                }
                GAEvents.addAdEvent(adAction, adType, adSdkName, adPlacement, GAAdError.Undefined, duration, true, customFields, mergeFields);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "addAdEvent";
            }
        }, 1L);
    }

    public static void addAdEvent(GAAdAction adAction, GAAdType adType, String adSdkName, String adPlacement, GAAdError noAdReason) {
        GameAnalytics.addAdEvent(adAction, adType, adSdkName, adPlacement, noAdReason, null);
    }

    public static void addAdEvent(GAAdAction adAction, GAAdType adType, String adSdkName, String adPlacement, GAAdError noAdReason, Map customFields) {
        GameAnalytics.addAdEvent(adAction, adType, adSdkName, adPlacement, noAdReason, customFields, false);
    }

    public static void addAdEvent(GAAdAction adAction, GAAdType adType, String adSdkName, String adPlacement, GAAdError noAdReason, Map customFields, boolean mergeFields) {
        if(GAState.isInitialized()) {
            GAThreading.performTaskOnGAThread(new IBlock() {
                @Override  // com.gameanalytics.sdk.threading.IBlock
                public void execute() {
                    if(!GameAnalytics.isSdkReady(true, true, "Could not add ad event")) {
                        return;
                    }
                    GAEvents.addAdEvent(adAction, adType, adSdkName, adPlacement, noAdReason, 0L, false, customFields, mergeFields);
                }

                @Override  // com.gameanalytics.sdk.threading.IBlock
                public String getName() {
                    return "addAdEvent";
                }
            });
            return;
        }
        GAThreading.performTaskDelayed(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(true, false, "Could not ad error event")) {
                    if(!GAState.isInitialized()) {
                        GameAnalytics.addAdEvent(adAction, adType, adSdkName, adPlacement, noAdReason, customFields, mergeFields);
                        GameAnalytics.access$304();
                    }
                    return;
                }
                GAEvents.addAdEvent(adAction, adType, adSdkName, adPlacement, noAdReason, 0L, false, customFields, mergeFields);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "addAdEvent";
            }
        }, 1L);
    }

    public static void addAdEvent(GAAdAction adAction, GAAdType adType, String adSdkName, String adPlacement, Map customFields) {
        GameAnalytics.addAdEvent(adAction, adType, adSdkName, adPlacement, customFields, false);
    }

    public static void addAdEvent(GAAdAction adAction, GAAdType adType, String adSdkName, String adPlacement, Map customFields, boolean mergeFields) {
        if(GAState.isInitialized()) {
            GAThreading.performTaskOnGAThread(new IBlock() {
                @Override  // com.gameanalytics.sdk.threading.IBlock
                public void execute() {
                    if(!GameAnalytics.isSdkReady(true, true, "Could not add ad event")) {
                        return;
                    }
                    GAEvents.addAdEvent(adAction, adType, adSdkName, adPlacement, GAAdError.Undefined, 0L, false, customFields, mergeFields);
                }

                @Override  // com.gameanalytics.sdk.threading.IBlock
                public String getName() {
                    return "addAdEvent";
                }
            });
            return;
        }
        GAThreading.performTaskDelayed(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(true, false, "Could not ad event")) {
                    if(!GAState.isInitialized()) {
                        GameAnalytics.addAdEvent(adAction, adType, adSdkName, adPlacement, customFields, mergeFields);
                        GameAnalytics.access$304();
                    }
                    return;
                }
                GAEvents.addAdEvent(adAction, adType, adSdkName, adPlacement, GAAdError.Undefined, 0L, false, customFields, mergeFields);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "addAdEvent";
            }
        }, 1L);
    }

    public static void addBusinessEvent(String currency, int amount, String itemType, String itemId, String cartType) {
        GameAnalytics.addBusinessEvent(currency, amount, itemType, itemId, cartType, "", "", "");
    }

    public static void addBusinessEvent(String currency, int amount, String itemType, String itemId, String cartType, String customFields) {
        GameAnalytics.addBusinessEvent(currency, amount, itemType, itemId, cartType, "", "", "", GameAnalytics.jsonStringToMap(customFields), false);
    }

    public static void addBusinessEvent(String currency, int amount, String itemType, String itemId, String cartType, String receipt, String store, String signature) {
        GameAnalytics.addBusinessEvent(currency, amount, itemType, itemId, cartType, receipt, store, signature, null);
    }

    public static void addBusinessEvent(String currency, int amount, String itemType, String itemId, String cartType, String receipt, String store, String signature, String customFields) {
        GameAnalytics.addBusinessEvent(currency, amount, itemType, itemId, cartType, receipt, store, signature, GameAnalytics.jsonStringToMap(customFields), false);
    }

    public static void addBusinessEvent(String currency, int amount, String itemType, String itemId, String cartType, String receipt, String store, String signature, String customFields, boolean mergeFields) {
        GameAnalytics.addBusinessEvent(currency, amount, itemType, itemId, cartType, receipt, store, signature, GameAnalytics.jsonStringToMap(customFields), mergeFields);
    }

    public static void addBusinessEvent(String currency, int amount, String itemType, String itemId, String cartType, String receipt, String store, String signature, Map customFields) {
        GameAnalytics.addBusinessEvent(currency, amount, itemType, itemId, cartType, receipt, store, signature, customFields, false);
    }

    public static void addBusinessEvent(String currency, int amount, String itemType, String itemId, String cartType, String receipt, String store, String signature, Map customFields, boolean mergeFields) {
        if(GAState.isInitialized()) {
            GAThreading.performTaskOnGAThread(new IBlock() {
                @Override  // com.gameanalytics.sdk.threading.IBlock
                public void execute() {
                    if(!GameAnalytics.isSdkReady(true, true, "Could not add business event")) {
                        return;
                    }
                    GAEvents.addBusinessEvent(currency, amount, itemType, itemId, cartType, receipt, store, signature, customFields, mergeFields);
                }

                @Override  // com.gameanalytics.sdk.threading.IBlock
                public String getName() {
                    return "addBusinessEvent";
                }
            });
            return;
        }
        GAThreading.performTaskDelayed(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(true, false, "Could not add business event")) {
                    if(!GAState.isInitialized()) {
                        GameAnalytics.addBusinessEvent(currency, amount, itemType, itemId, cartType, receipt, store, signature, customFields, mergeFields);
                        GameAnalytics.access$304();
                    }
                    return;
                }
                GAEvents.addBusinessEvent(currency, amount, itemType, itemId, cartType, receipt, store, signature, customFields, mergeFields);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "addBusinessEvent";
            }
        }, 1L);
    }

    public static void addBusinessEvent(String currency, int amount, String itemType, String itemId, String cartType, String customFields, boolean mergeFields) {
        GameAnalytics.addBusinessEvent(currency, amount, itemType, itemId, cartType, "", "", "", GameAnalytics.jsonStringToMap(customFields), mergeFields);
    }

    public static void addBusinessEvent(String currency, int amount, String itemType, String itemId, String cartType, Map customFields) {
        GameAnalytics.addBusinessEvent(currency, amount, itemType, itemId, cartType, "", "", "", customFields, false);
    }

    public static void addBusinessEvent(String currency, int amount, String itemType, String itemId, String cartType, Map customFields, boolean mergeFields) {
        GameAnalytics.addBusinessEvent(currency, amount, itemType, itemId, cartType, "", "", "", customFields, mergeFields);
    }

    public static void addDesignEvent(String eventId) {
        GameAnalytics.addDesignEvent(eventId, null);
    }

    public static void addDesignEvent(String eventId, double value) {
        GameAnalytics.addDesignEvent(eventId, value, null);
    }

    public static void addDesignEvent(String eventId, double value, String customFields) {
        GameAnalytics.addDesignEvent(eventId, value, GameAnalytics.jsonStringToMap(customFields), false);
    }

    public static void addDesignEvent(String eventId, double value, String customFields, boolean mergeFields) {
        GameAnalytics.addDesignEvent(eventId, value, GameAnalytics.jsonStringToMap(customFields), mergeFields);
    }

    public static void addDesignEvent(String eventId, double value, Map customFields) {
        GameAnalytics.addDesignEvent(eventId, value, customFields, false);
    }

    public static void addDesignEvent(String eventId, double value, Map customFields, boolean mergeFields) {
        if(GAState.isInitialized()) {
            GAThreading.performTaskOnGAThread(new IBlock() {
                @Override  // com.gameanalytics.sdk.threading.IBlock
                public void execute() {
                    if(!GameAnalytics.isSdkReady(true, true, "Could not add design event")) {
                        return;
                    }
                    GAEvents.addDesignEvent(eventId, value, true, customFields, mergeFields);
                }

                @Override  // com.gameanalytics.sdk.threading.IBlock
                public String getName() {
                    return "addDesignEvent";
                }
            });
            return;
        }
        GAThreading.performTaskDelayed(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(true, false, "Could not add design event")) {
                    if(!GAState.isInitialized()) {
                        GameAnalytics.addDesignEvent(eventId, value, customFields, mergeFields);
                        GameAnalytics.access$304();
                    }
                    return;
                }
                GAEvents.addDesignEvent(eventId, value, true, customFields, mergeFields);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "addDesignEvent";
            }
        }, 1L);
    }

    public static void addDesignEvent(String eventId, String customFields) {
        GameAnalytics.addDesignEvent(eventId, GameAnalytics.jsonStringToMap(customFields), false);
    }

    public static void addDesignEvent(String eventId, String customFields, boolean mergeFields) {
        GameAnalytics.addDesignEvent(eventId, GameAnalytics.jsonStringToMap(customFields), mergeFields);
    }

    public static void addDesignEvent(String eventId, Map customFields) {
        GameAnalytics.addDesignEvent(eventId, customFields, false);
    }

    public static void addDesignEvent(String eventId, Map customFields, boolean mergeFields) {
        if(GAState.isInitialized()) {
            GAThreading.performTaskOnGAThread(new IBlock() {
                @Override  // com.gameanalytics.sdk.threading.IBlock
                public void execute() {
                    if(!GameAnalytics.isSdkReady(true, true, "Could not add design event")) {
                        return;
                    }
                    GAEvents.addDesignEvent(eventId, 0.0, false, customFields, mergeFields);
                }

                @Override  // com.gameanalytics.sdk.threading.IBlock
                public String getName() {
                    return "addDesignEvent";
                }
            });
            return;
        }
        GAThreading.performTaskDelayed(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(true, false, "Could not add design event")) {
                    if(!GAState.isInitialized()) {
                        GameAnalytics.addDesignEvent(eventId, customFields, mergeFields);
                        GameAnalytics.access$304();
                    }
                    return;
                }
                GAEvents.addDesignEvent(eventId, 0.0, false, customFields, mergeFields);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "addDesignEvent";
            }
        }, 1L);
    }

    public static void addErrorEvent(int severity, String message) {
        GameAnalytics.addErrorEvent(GAErrorSeverity.valueOf(severity), message);
    }

    public static void addErrorEvent(int severity, String message, String customFields) {
        GameAnalytics.addErrorEvent(GAErrorSeverity.valueOf(severity), message, GameAnalytics.jsonStringToMap(customFields), false);
    }

    public static void addErrorEvent(int severity, String message, String customFields, boolean mergeFields) {
        GameAnalytics.addErrorEvent(GAErrorSeverity.valueOf(severity), message, GameAnalytics.jsonStringToMap(customFields), mergeFields);
    }

    public static void addErrorEvent(GAErrorSeverity severity, String message) {
        GameAnalytics.addErrorEvent(severity, message, null);
    }

    public static void addErrorEvent(GAErrorSeverity severity, String message, Map customFields) {
        GameAnalytics.addErrorEvent(severity, message, customFields, false);
    }

    public static void addErrorEvent(GAErrorSeverity severity, String message, Map customFields, boolean mergeFields) {
        FunctionInfo gAPlatform$FunctionInfo0 = new FunctionInfo();
        if(GAState.isInitialized()) {
            GAThreading.performTaskOnGAThread(new IBlock() {
                @Override  // com.gameanalytics.sdk.threading.IBlock
                public void execute() {
                    if(!GameAnalytics.isSdkReady(true, true, "Could not add error event")) {
                        return;
                    }
                    GAEvents.addErrorEvent(severity, message, customFields, mergeFields, gAPlatform$FunctionInfo0.method, gAPlatform$FunctionInfo0.line, gAPlatform$FunctionInfo0.module);
                }

                @Override  // com.gameanalytics.sdk.threading.IBlock
                public String getName() {
                    return "addErrorEvent";
                }
            });
            return;
        }
        GAThreading.performTaskDelayed(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(true, false, "Could not add error event")) {
                    if(!GAState.isInitialized()) {
                        GameAnalytics.addErrorEvent(severity, message, customFields, mergeFields);
                        GameAnalytics.access$304();
                    }
                    return;
                }
                GAEvents.addErrorEvent(severity, message, customFields, mergeFields, gAPlatform$FunctionInfo0.method, gAPlatform$FunctionInfo0.line, gAPlatform$FunctionInfo0.module);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "addErrorEvent";
            }
        }, 1L);
    }

    public static void addImpressionAdMobEvent(String adNetworkVersion, String impressionData) {
        try {
            GameAnalytics.addImpressionAdMobEvent(adNetworkVersion, new JSONObject(impressionData));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionAdMobEvent(String adNetworkVersion, String impressionData, String customFields) {
        try {
            GameAnalytics.addImpressionAdMobEvent(adNetworkVersion, new JSONObject(impressionData), GameAnalytics.jsonStringToMap(customFields));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionAdMobEvent(String adNetworkVersion, JSONObject impressionData) {
        GameAnalytics.addImpressionEvent("admob", adNetworkVersion, impressionData);
    }

    public static void addImpressionAdMobEvent(String adNetworkVersion, JSONObject impressionData, Map customFields) {
        GameAnalytics.addImpressionEvent("admob", adNetworkVersion, impressionData, customFields);
    }

    public static void addImpressionAequusEvent(String adNetworkVersion, String impressionData) {
        try {
            GameAnalytics.addImpressionAequusEvent(adNetworkVersion, new JSONObject(impressionData));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionAequusEvent(String adNetworkVersion, String impressionData, String customFields) {
        try {
            GameAnalytics.addImpressionAequusEvent(adNetworkVersion, new JSONObject(impressionData), GameAnalytics.jsonStringToMap(customFields));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionAequusEvent(String adNetworkVersion, JSONObject impressionData) {
        GameAnalytics.addImpressionEvent("aequus", adNetworkVersion, impressionData);
    }

    public static void addImpressionAequusEvent(String adNetworkVersion, JSONObject impressionData, Map customFields) {
        GameAnalytics.addImpressionEvent("aequus", adNetworkVersion, impressionData, customFields);
    }

    public static void addImpressionEvent(String adNetworkName, String adNetworkVersion, String impressionData, String customFields) {
        try {
            GameAnalytics.addImpressionEvent(adNetworkName, adNetworkVersion, new JSONObject(impressionData), GameAnalytics.jsonStringToMap(customFields));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionEvent(String adNetworkName, String adNetworkVersion, String impressionData, String customFields, boolean mergeFields) {
        try {
            GameAnalytics.addImpressionEvent(adNetworkName, adNetworkVersion, new JSONObject(impressionData), GameAnalytics.jsonStringToMap(customFields), mergeFields);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionEvent(String adNetworkName, String adNetworkVersion, JSONObject impressionData) {
        GameAnalytics.addImpressionEvent(adNetworkName, adNetworkVersion, impressionData, null);
    }

    public static void addImpressionEvent(String adNetworkName, String adNetworkVersion, JSONObject impressionData, Map customFields) {
        GameAnalytics.addImpressionEvent(adNetworkName, adNetworkVersion, impressionData, customFields, false);
    }

    public static void addImpressionEvent(String adNetworkName, String adNetworkVersion, JSONObject impressionData, Map customFields, boolean mergeFields) {
        if(GAState.isInitialized()) {
            GAThreading.performTaskOnGAThread(new IBlock() {
                @Override  // com.gameanalytics.sdk.threading.IBlock
                public void execute() {
                    if(!GameAnalytics.isSdkReady(true, true, "Could not add impression event")) {
                        return;
                    }
                    GAEvents.addImpressionEvent(adNetworkName, adNetworkVersion, impressionData, customFields, mergeFields);
                }

                @Override  // com.gameanalytics.sdk.threading.IBlock
                public String getName() {
                    return "addImpressionEvent";
                }
            });
            return;
        }
        GAThreading.performTaskDelayed(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(true, false, "Could not add impression event")) {
                    if(!GAState.isInitialized()) {
                        GameAnalytics.addImpressionEvent(adNetworkName, adNetworkVersion, impressionData, customFields, mergeFields);
                        GameAnalytics.access$304();
                    }
                    return;
                }
                GAEvents.addImpressionEvent(adNetworkName, adNetworkVersion, impressionData, customFields, mergeFields);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "addImpressionEvent";
            }
        }, 1L);
    }

    public static void addImpressionFyberEvent(String adNetworkVersion, String impressionData) {
        try {
            GameAnalytics.addImpressionFyberEvent(adNetworkVersion, new JSONObject(impressionData));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionFyberEvent(String adNetworkVersion, String impressionData, String customFields) {
        try {
            GameAnalytics.addImpressionFyberEvent(adNetworkVersion, new JSONObject(impressionData), GameAnalytics.jsonStringToMap(customFields));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionFyberEvent(String adNetworkVersion, JSONObject impressionData) {
        GameAnalytics.addImpressionEvent("fyber", adNetworkVersion, impressionData);
    }

    public static void addImpressionFyberEvent(String adNetworkVersion, JSONObject impressionData, Map customFields) {
        GameAnalytics.addImpressionEvent("fyber", adNetworkVersion, impressionData, customFields);
    }

    public static void addImpressionHyperBidEvent(String adNetworkVersion, String impressionData) {
        try {
            GameAnalytics.addImpressionHyperBidEvent(adNetworkVersion, new JSONObject(impressionData));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionHyperBidEvent(String adNetworkVersion, String impressionData, String customFields) {
        try {
            GameAnalytics.addImpressionHyperBidEvent(adNetworkVersion, new JSONObject(impressionData), GameAnalytics.jsonStringToMap(customFields));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionHyperBidEvent(String adNetworkVersion, JSONObject impressionData) {
        GameAnalytics.addImpressionEvent("hyperbid", adNetworkVersion, impressionData);
    }

    public static void addImpressionHyperBidEvent(String adNetworkVersion, JSONObject impressionData, Map customFields) {
        GameAnalytics.addImpressionEvent("hyperbid", adNetworkVersion, impressionData, customFields);
    }

    public static void addImpressionIronSourceEvent(String adNetworkVersion, String impressionData) {
        try {
            GameAnalytics.addImpressionIronSourceEvent(adNetworkVersion, new JSONObject(impressionData));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionIronSourceEvent(String adNetworkVersion, String impressionData, String customFields) {
        try {
            GameAnalytics.addImpressionIronSourceEvent(adNetworkVersion, new JSONObject(impressionData), GameAnalytics.jsonStringToMap(customFields));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionIronSourceEvent(String adNetworkVersion, JSONObject impressionData) {
        GameAnalytics.addImpressionEvent("ironsource", adNetworkVersion, impressionData);
    }

    public static void addImpressionIronSourceEvent(String adNetworkVersion, JSONObject impressionData, Map customFields) {
        GameAnalytics.addImpressionEvent("ironsource", adNetworkVersion, impressionData, customFields);
    }

    public static void addImpressionMaxEvent(String adNetworkVersion, String impressionData) {
        try {
            GameAnalytics.addImpressionMaxEvent(adNetworkVersion, new JSONObject(impressionData));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionMaxEvent(String adNetworkVersion, String impressionData, String customFields) {
        try {
            GameAnalytics.addImpressionMaxEvent(adNetworkVersion, new JSONObject(impressionData), GameAnalytics.jsonStringToMap(customFields));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionMaxEvent(String adNetworkVersion, JSONObject impressionData) {
        GameAnalytics.addImpressionEvent("max", adNetworkVersion, impressionData);
    }

    public static void addImpressionMaxEvent(String adNetworkVersion, JSONObject impressionData, Map customFields) {
        GameAnalytics.addImpressionEvent("max", adNetworkVersion, impressionData, customFields);
    }

    public static void addImpressionMoPubEvent(String adNetworkVersion, String impressionData) {
        try {
            GameAnalytics.addImpressionMoPubEvent(adNetworkVersion, new JSONObject(impressionData));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionMoPubEvent(String adNetworkVersion, String impressionData, String customFields) {
        try {
            GameAnalytics.addImpressionMoPubEvent(adNetworkVersion, new JSONObject(impressionData), GameAnalytics.jsonStringToMap(customFields));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionMoPubEvent(String adNetworkVersion, JSONObject impressionData) {
        GameAnalytics.addImpressionEvent("mopub", adNetworkVersion, impressionData);
    }

    public static void addImpressionMoPubEvent(String adNetworkVersion, JSONObject impressionData, Map customFields) {
        GameAnalytics.addImpressionEvent("mopub", adNetworkVersion, impressionData, customFields);
    }

    public static void addImpressionTopOnEvent(String adNetworkVersion, String impressionData) {
        try {
            GameAnalytics.addImpressionTopOnEvent(adNetworkVersion, new JSONObject(impressionData));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionTopOnEvent(String adNetworkVersion, String impressionData, String customFields) {
        try {
            GameAnalytics.addImpressionTopOnEvent(adNetworkVersion, new JSONObject(impressionData), GameAnalytics.jsonStringToMap(customFields));
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public static void addImpressionTopOnEvent(String adNetworkVersion, JSONObject impressionData) {
        GameAnalytics.addImpressionEvent("topon", adNetworkVersion, impressionData);
    }

    public static void addImpressionTopOnEvent(String adNetworkVersion, JSONObject impressionData, Map customFields) {
        GameAnalytics.addImpressionEvent("topon", adNetworkVersion, impressionData, customFields);
    }

    public static void addProgressionEvent(int progressionStatus, String progression01, String progression02, String progression03) {
        GameAnalytics.addProgressionEvent(GAProgressionStatus.valueOf(progressionStatus), progression01, progression02, progression03);
    }

    public static void addProgressionEvent(int progressionStatus, String progression01, String progression02, String progression03, double score) {
        GameAnalytics.addProgressionEvent(GAProgressionStatus.valueOf(progressionStatus), progression01, progression02, progression03, score);
    }

    public static void addProgressionEvent(int progressionStatus, String progression01, String progression02, String progression03, double score, String customFields) {
        GameAnalytics.addProgressionEvent(GAProgressionStatus.valueOf(progressionStatus), progression01, progression02, progression03, score, GameAnalytics.jsonStringToMap(customFields), false);
    }

    public static void addProgressionEvent(int progressionStatus, String progression01, String progression02, String progression03, double score, String customFields, boolean mergeFields) {
        GameAnalytics.addProgressionEvent(GAProgressionStatus.valueOf(progressionStatus), progression01, progression02, progression03, score, GameAnalytics.jsonStringToMap(customFields), mergeFields);
    }

    public static void addProgressionEvent(int progressionStatus, String progression01, String progression02, String progression03, String customFields) {
        GameAnalytics.addProgressionEvent(GAProgressionStatus.valueOf(progressionStatus), progression01, progression02, progression03, GameAnalytics.jsonStringToMap(customFields), false);
    }

    public static void addProgressionEvent(int progressionStatus, String progression01, String progression02, String progression03, String customFields, boolean mergeFields) {
        GameAnalytics.addProgressionEvent(GAProgressionStatus.valueOf(progressionStatus), progression01, progression02, progression03, GameAnalytics.jsonStringToMap(customFields), mergeFields);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, "", "");
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, double score) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, "", "", score);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, double score, Map customFields) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, "", "", score, customFields, false);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, double score, Map customFields, boolean mergeFields) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, "", "", score, customFields, mergeFields);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, progression02, "");
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02, double score) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, progression02, "", score);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02, double score, Map customFields) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, progression02, "", score, customFields, false);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02, double score, Map customFields, boolean mergeFields) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, progression02, "", score, customFields, mergeFields);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02, String progression03) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, progression02, progression03, null);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02, String progression03, double score) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, progression02, progression03, score, null);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02, String progression03, double score, Map customFields) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, progression02, progression03, score, customFields, false);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02, String progression03, double score, Map customFields, boolean mergeFields) {
        if(GAState.isInitialized()) {
            GAThreading.performTaskOnGAThread(new IBlock() {
                @Override  // com.gameanalytics.sdk.threading.IBlock
                public void execute() {
                    if(!GameAnalytics.isSdkReady(true, true, "Could not add progression event")) {
                        return;
                    }
                    GAEvents.addProgressionEvent(progressionStatus, progression01, progression02, progression03, ((int)score), true, customFields, mergeFields);
                }

                @Override  // com.gameanalytics.sdk.threading.IBlock
                public String getName() {
                    return "addProgressionEvent";
                }
            });
            return;
        }
        GAThreading.performTaskDelayed(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(true, false, "Could not add progression event")) {
                    if(!GAState.isInitialized()) {
                        GameAnalytics.addProgressionEvent(progressionStatus, progression01, progression02, progression03, score, customFields, mergeFields);
                        GameAnalytics.access$304();
                    }
                    return;
                }
                GAEvents.addProgressionEvent(progressionStatus, progression01, progression02, progression03, ((int)score), true, customFields, mergeFields);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "addProgressionEvent";
            }
        }, 1L);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02, String progression03, Map customFields) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, progression02, progression03, customFields, false);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02, String progression03, Map customFields, boolean mergeFields) {
        if(GAState.isInitialized()) {
            GAThreading.performTaskOnGAThread(new IBlock() {
                @Override  // com.gameanalytics.sdk.threading.IBlock
                public void execute() {
                    if(!GameAnalytics.isSdkReady(true, true, "Could not add progression event")) {
                        return;
                    }
                    GAEvents.addProgressionEvent(progressionStatus, progression01, progression02, progression03, 0, false, customFields, mergeFields);
                }

                @Override  // com.gameanalytics.sdk.threading.IBlock
                public String getName() {
                    return "addProgressionEvent";
                }
            });
            return;
        }
        GAThreading.performTaskDelayed(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(true, false, "Could not add progression event")) {
                    if(!GAState.isInitialized()) {
                        GameAnalytics.addProgressionEvent(progressionStatus, progression01, progression02, progression03, customFields, mergeFields);
                        GameAnalytics.access$304();
                    }
                    return;
                }
                GAEvents.addProgressionEvent(progressionStatus, progression01, progression02, progression03, 0, false, customFields, mergeFields);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "addProgressionEvent";
            }
        }, 1L);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02, Map customFields) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, progression02, "", customFields, false);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02, Map customFields, boolean mergeFields) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, progression02, "", customFields, mergeFields);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, Map customFields) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, "", "", customFields, false);
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, Map customFields, boolean mergeFields) {
        GameAnalytics.addProgressionEvent(progressionStatus, progression01, "", "", customFields, mergeFields);
    }

    public static void addRemoteConfigsListener(IRemoteConfigsListener listener) {
        GAState.addRemoteConfigsListener(listener);
    }

    public static void addResourceEvent(int flowType, String currency, float amount, String itemType, String itemId) {
        GameAnalytics.addResourceEvent(GAResourceFlowType.valueOf(flowType), currency, amount, itemType, itemId);
    }

    public static void addResourceEvent(int flowType, String currency, float amount, String itemType, String itemId, String customFields) {
        GameAnalytics.addResourceEvent(GAResourceFlowType.valueOf(flowType), currency, amount, itemType, itemId, GameAnalytics.jsonStringToMap(customFields), false);
    }

    public static void addResourceEvent(int flowType, String currency, float amount, String itemType, String itemId, String customFields, boolean mergeFields) {
        GameAnalytics.addResourceEvent(GAResourceFlowType.valueOf(flowType), currency, amount, itemType, itemId, GameAnalytics.jsonStringToMap(customFields), mergeFields);
    }

    public static void addResourceEvent(GAResourceFlowType flowType, String currency, float amount, String itemType, String itemId) {
        GameAnalytics.addResourceEvent(flowType, currency, amount, itemType, itemId, null);
    }

    public static void addResourceEvent(GAResourceFlowType flowType, String currency, float amount, String itemType, String itemId, Map customFields) {
        GameAnalytics.addResourceEvent(flowType, currency, amount, itemType, itemId, customFields, false);
    }

    public static void addResourceEvent(GAResourceFlowType flowType, String currency, float amount, String itemType, String itemId, Map customFields, boolean mergeFields) {
        if(GAState.isInitialized()) {
            GAThreading.performTaskOnGAThread(new IBlock() {
                @Override  // com.gameanalytics.sdk.threading.IBlock
                public void execute() {
                    if(!GameAnalytics.isSdkReady(true, true, "Could not add resource event")) {
                        return;
                    }
                    GAEvents.addResourceEvent(flowType, currency, ((double)amount), itemType, itemId, customFields, mergeFields);
                }

                @Override  // com.gameanalytics.sdk.threading.IBlock
                public String getName() {
                    return "addResourceEvent";
                }
            });
            return;
        }
        GAThreading.performTaskDelayed(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(true, false, "Could not add resource event")) {
                    if(!GAState.isInitialized()) {
                        GameAnalytics.addResourceEvent(flowType, currency, amount, itemType, itemId, customFields, mergeFields);
                        GameAnalytics.access$304();
                    }
                    return;
                }
                GAEvents.addResourceEvent(flowType, currency, ((double)amount), itemType, itemId, customFields, mergeFields);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "addResourceEvent";
            }
        }, 1L);
    }

    public static void configureAutoDetectAppVersion(boolean flag) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(GameAnalytics.isSdkReady(true, false)) {
                    return;
                }
                GAState.setAutoDetectAppVersion(flag);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureAutoDetectAppVersion";
            }
        });
    }

    public static void configureAvailableCustomDimensions01(String[] customDimensions) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(GameAnalytics.isSdkReady(true, false)) {
                    GALogger.w("Available custom dimensions must be set before SDK is initialized");
                    return;
                }
                GAState.setAvailableCustomDimensions01(customDimensions);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureAvailableCustomDimensions01";
            }
        });
    }

    public static void configureAvailableCustomDimensions02(String[] customDimensions) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(GameAnalytics.isSdkReady(true, false)) {
                    GALogger.w("Available custom dimensions must be set before SDK is initialized");
                    return;
                }
                GAState.setAvailableCustomDimensions02(customDimensions);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureAvailableCustomDimensions02";
            }
        });
    }

    public static void configureAvailableCustomDimensions03(String[] customDimensions) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(GameAnalytics.isSdkReady(true, false)) {
                    GALogger.w("Available custom dimensions must be set before SDK is initialized");
                    return;
                }
                GAState.setAvailableCustomDimensions03(customDimensions);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureAvailableCustomDimensions03";
            }
        });
    }

    public static void configureAvailableResourceCurrencies(String[] resourceCurrencies) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(GameAnalytics.isSdkReady(true, false)) {
                    GALogger.w("Available resource currencies must be set before SDK is initialized");
                    return;
                }
                GAState.setAvailableResourceCurrencies(resourceCurrencies);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureAvailableResourceCurrencies";
            }
        });
    }

    public static void configureAvailableResourceItemTypes(String[] resourceItemTypes) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(GameAnalytics.isSdkReady(true, false)) {
                    GALogger.w("Available resource item types must be set before SDK is initialized");
                    return;
                }
                GAState.setAvailableResourceItemTypes(resourceItemTypes);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureAvailableResourceItemTypes";
            }
        });
    }

    public static void configureBuild(String build) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(GameAnalytics.isSdkReady(true, false)) {
                    GALogger.w("Build version must be set before SDK is initialized.");
                    return;
                }
                if(!GAValidator.validateBuild(build)) {
                    GALogger.i(("Validation fail - configure build: Cannot be null, empty or above 32 length. String: " + build));
                    return;
                }
                GAState.setBuild(build);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureBuild";
            }
        });
    }

    public static void configureExternalUserId(String uId) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                GAState.setExternalUserId(uId);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureExternalUserId";
            }
        });
    }

    public static void configureGameEngineVersion(String gameEngineVersion) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(GameAnalytics.isSdkReady(true, false)) {
                    return;
                }
                if(!GAValidator.validateEngineVersion(gameEngineVersion)) {
                    GALogger.i(("Validation fail - configure sdk version: Sdk version not supported. String: " + gameEngineVersion));
                    return;
                }
                GADevice.setGameEngineVersion(gameEngineVersion);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureGameEngineVersion";
            }
        });
    }

    static void configureIsHacked(boolean isHacked) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(false)) {
                    return;
                }
                GADevice.setIsHacked(isHacked);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureIsHacked";
            }
        });
    }

    static void configureIsLimitedAdTracking(boolean isLimitedAdTracking) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(false)) {
                    return;
                }
                GADevice.setIsLimitedAdTracking(isLimitedAdTracking);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureIsLimitedAdTracking";
            }
        });
    }

    public static void configureSdkGameEngineVersion(String sdkGameEngineVersion) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(GameAnalytics.isSdkReady(true, false)) {
                    return;
                }
                if(!GAValidator.validateSdkWrapperVersion(sdkGameEngineVersion)) {
                    GALogger.i(("Validation fail - configure sdk version: Sdk version not supported. String: " + sdkGameEngineVersion));
                    return;
                }
                GADevice.setSdkGameEngineVersion(sdkGameEngineVersion);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureSdkGameEngineVersion";
            }
        });
    }

    public static void configureUserId(String uId) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(GameAnalytics.isSdkReady(true, false)) {
                    GALogger.w("A custom user id must be set before SDK is initialized.");
                    return;
                }
                if(!GAValidator.validateUserId(uId)) {
                    GALogger.i(("Validation fail - configure user_id: Cannot be null, empty or above 64 length. Will use default user_id method. Used string: " + uId));
                    return;
                }
                GAState.setUserId(uId);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureUserId";
            }
        });
    }

    static void configureWritableFilePath(String path) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                GADevice.setWritableFilePath(path);
                if(!GAStore.ensureDatabase(false)) {
                    GALogger.w(("Could not ensure/validate local event database: " + path));
                }
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "configureWritableFilePath";
            }
        });
    }

    public static void enableFpsHistogram(boolean value) {
        GAState.enableFpsSampling(value);
    }

    public static void enableHealthHardwareInfo(boolean value) {
        DeviceInfo.enableHardwareTracking = value;
        DeviceInfo.enableMemoryTracking = value;
    }

    public static void enableMemoryHistogram(boolean value) {
        GAState.enableMemorySampling(value);
    }

    public static void enableSDKInitEvent(boolean value) {
        GAEvents.isSdkInitEventEnabled = value;
    }

    // 去混淆评级： 低(30)
    public static void endSession() {
    }

    public static String getABTestingId() {
        return GAState.getABTestingId();
    }

    public static String getABTestingVariantId() {
        return GAState.getABTestingVariantId();
    }

    public static String getExternalUserId() {
        return GAState.getExternalUserId();
    }

    public static String getRemoteConfigsContentAsString() {
        return GAState.getRemoteConfigsContentAsString();
    }

    public static String getRemoteConfigsValueAsString(String key) {
        return GameAnalytics.getRemoteConfigsValueAsString(key, null);
    }

    public static String getRemoteConfigsValueAsString(String key, String defaultValue) {
        return GAState.getRemoteConfigsStringValue(key, defaultValue);
    }

    public static String getUserId() {
        return GAState.getUserId();
    }

    public static void initialize(Activity activity, String gameKey, String secretKey) {
        DeviceInfo.GetAppUptime();
        GAPlatform.initialize(activity);
        GameAnalytics.initialize(gameKey, secretKey);
    }

    public static void initialize(String gameKey, String gameSecret) {
        GALogger.w("Initialize error: You must call GAPlatform.initialize before GameAnalytics.initialize. Or add the activity to GameAnalytics.initialize.");

        class com.gameanalytics.sdk.GameAnalytics.15 implements IBlock {
            com.gameanalytics.sdk.GameAnalytics.15(String val$gameKey, String val$gameSecret) {
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(GameAnalytics.isSdkReady(true, false)) {
                    GALogger.w("SDK already initialized. Can only be called once.");
                    return;
                }
                if(!GAValidator.validateKeys(this.val$gameKey, this.val$gameSecret)) {
                    GALogger.w(("SDK failed initialize. Game key or secret key is invalid. Can only contain characters A-z 0-9, gameKey is 32 length, gameSecret is 40 length. Failed keys - gameKey: " + this.val$gameKey + ", secretKey: " + this.val$gameSecret));
                    return;
                }
                GAState.setKeys(this.val$gameKey, this.val$gameSecret);
                GAState.internalInitialize();
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "initialize";
            }
        }

    }

    public static boolean isRemoteConfigsReady() {
        return GAState.isRemoteConfigsReady();
    }

    private static boolean isSdkReady(boolean needsInitialized) {
        return GameAnalytics.isSdkReady(needsInitialized, true);
    }

    private static boolean isSdkReady(boolean needsInitialized, boolean warn) {
        return GameAnalytics.isSdkReady(needsInitialized, warn, "");
    }

    // 去混淆评级： 低(26)
    private static boolean isSdkReady(boolean needsInitialized, boolean warn, String message) {
        if(message.length() != 0) {
            message = message + ": ";
        }
        if(warn) {
            GALogger.w((message + "Datastore not initialized"));
        }
        return false;
    }

    private static Map jsonStringToMap(String s) {
        Map map0 = new HashMap();
        try {
            JSONObject jSONObject0 = new JSONObject(s);
            Iterator iterator0 = jSONObject0.keys();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                map0.put(((String)object0), jSONObject0.get(((String)object0)));
            }
        }
        catch(JSONException jSONException0) {
            GALogger.d(("jsonStringToMap: failed to decode jsonString=" + s));
            String s1 = GAState.getGameKey();
            String s2 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Json, EGASdkErrorArea.JsonStringToMap, EGASdkErrorAction.JsonError, jSONException0.toString(), s1, s2);
        }
        return map0;
    }

    static void onResume() {
        GAThreading.start();
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                GAState.resumeSessionAndStartQueue();
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "onResume";
            }
        });
    }

    static void onStop() {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                GAState.endSessionAndStopQueue();
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "onStop";
            }
        });
    }

    public static void pauseTimer(String key) {
        Stopwatch.pauseTimer(key);
    }

    public static void removeRemoteConfigsListener(IRemoteConfigsListener listener) {
        GAState.removeRemoteConfigsListener(listener);
    }

    public static void resumeTimer(String key) {
        Stopwatch.resumeTimer(key);
    }

    static void setAppBuild(int appBuild) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                GADevice.setAppBuild(appBuild);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "setAppBuild";
            }
        });
    }

    static void setAppVersion(String appVersion) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                GADevice.setAppVersion(appVersion);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "setAppVersion";
            }
        });
    }

    public static void setBaseUrl(String url) {
        GAHTTPApi.getInstance().setBaseUrl(url);
    }

    static void setBundleIdentifier(String bundleIdentifier) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                GADevice.setBundleId(bundleIdentifier);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "setBundleIdentifier";
            }
        });
    }

    static void setConnectionType(String networkConnectionType) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GameAnalytics.isSdkReady(false)) {
                    return;
                }
                GADevice.setConnectionType(networkConnectionType);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "setConnectionType";
            }
        });
    }

    public static void setCustomDimension01(String dimension) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GAValidator.validateDimension01(dimension)) {
                    GALogger.w(("Could not set custom01 dimension value to \'" + dimension + "\'. Value not found in available custom01 dimension values"));
                    return;
                }
                GAState.setCustomDimension01(dimension);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "setCustomDimension01";
            }
        });
    }

    public static void setCustomDimension02(String dimension) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GAValidator.validateDimension02(dimension)) {
                    GALogger.w(("Could not set custom02 dimension value to \'" + dimension + "\'. Value not found in available custom02 dimension values"));
                    return;
                }
                GAState.setCustomDimension02(dimension);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "setCustomDimension02";
            }
        });
    }

    public static void setCustomDimension03(String dimension) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(!GAValidator.validateDimension03(dimension)) {
                    GALogger.w(("Could not set custom03 dimension value to \'" + dimension + "\'. Value not found in available custom03 dimension values"));
                    return;
                }
                GAState.setCustomDimension03(dimension);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "setCustomDimension03";
            }
        });
    }

    public static void setEnabledErrorReporting(boolean flag) {
        GAState.setEnableErrorReporting(flag);
    }

    public static void setEnabledEventSubmission(boolean flag) {
        GameAnalytics.setEnabledEventSubmission(flag, false);
    }

    public static void setEnabledEventSubmission(boolean flag, boolean doSubmitEventsLocally) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(flag) {
                    GAState.setEnableEventSubmission(true, doSubmitEventsLocally);
                    GALogger.i("Event submission enabled");
                    return;
                }
                GALogger.i("Event submission disabled");
                GAState.setEnableEventSubmission(flag, doSubmitEventsLocally);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "setEnabledEventSubmission";
            }
        });
    }

    public static void setEnabledInfoLog(boolean flag) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(flag) {
                    GALogger.setInfoLog(true);
                    GALogger.i("Info logging enabled");
                    return;
                }
                GALogger.i("Info logging disabled");
                GALogger.setInfoLog(flag);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "setEnabledInfoLog";
            }
        });
    }

    public static void setEnabledManualSessionHandling(boolean flag) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                GAState.setManualSessionHandling(flag);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "setEnabledManualSessionHandling";
            }
        });
    }

    public static void setEnabledVerboseLog(boolean flag) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                if(flag) {
                    GALogger.setAdvancedInfoLog(true);
                    GALogger.i("Verbose logging enabled");
                    return;
                }
                GALogger.i("Verbose logging disabled");
                GALogger.setAdvancedInfoLog(flag);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "setEnabledVerboseLog";
            }
        });
    }

    public static void setGAIDTracking(boolean flag) {
        GADevice.doTrackGAID = flag;
    }

    public static void setGlobalCustomEventFields(String customFields) {
        GameAnalytics.setGlobalCustomEventFields(GameAnalytics.jsonStringToMap(customFields));
    }

    public static void setGlobalCustomEventFields(Map customFields) {
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                GAState.setGlobalCustomEventFields(customFields);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "setGlobalCustomEventFields";
            }
        });
    }

    public static void startSession() {
        GAThreading.performTaskOnGAThread(new IBlock() {
            // 去混淆评级： 中等(60)
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "startSession";
            }
        });
    }

    public static void startTimer(String key) {
        Stopwatch.startTimer(key);
    }

    public static long stopTimer(String key) {
        return Stopwatch.stopTimer(key);
    }
}

