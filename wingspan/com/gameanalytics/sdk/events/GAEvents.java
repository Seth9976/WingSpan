package com.gameanalytics.sdk.events;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.util.Base64;
import com.gameanalytics.sdk.GAAdAction;
import com.gameanalytics.sdk.GAAdError;
import com.gameanalytics.sdk.GAAdType;
import com.gameanalytics.sdk.GAErrorSeverity;
import com.gameanalytics.sdk.GAPlatform;
import com.gameanalytics.sdk.GAProgressionStatus;
import com.gameanalytics.sdk.GAResourceFlowType;
import com.gameanalytics.sdk.device.GADevice.DeviceInfo;
import com.gameanalytics.sdk.device.GADevice;
import com.gameanalytics.sdk.http.EGAHTTPApiResponse;
import com.gameanalytics.sdk.http.GAHTTPApi.GAHTTPApiResponseJSONObjectPair;
import com.gameanalytics.sdk.http.GAHTTPApi;
import com.gameanalytics.sdk.logging.GALogger;
import com.gameanalytics.sdk.state.GAState;
import com.gameanalytics.sdk.store.GAStore;
import com.gameanalytics.sdk.threading.GAThreading;
import com.gameanalytics.sdk.threading.IBlock;
import com.gameanalytics.sdk.utilities.GAUtilities;
import com.gameanalytics.sdk.validators.GAValidator;
import com.gameanalytics.sdk.validators.ValidationResult;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GAEvents {
    private static final String CATEGORY_ADS = "ads";
    private static final String CATEGORY_BUSINESS = "business";
    private static final String CATEGORY_DESIGN = "design";
    private static final String CATEGORY_ERROR = "error";
    private static final String CATEGORY_HEALTH = "health";
    private static final String CATEGORY_IMPRESSION = "impression";
    private static final String CATEGORY_PROGRESSION = "progression";
    private static final String CATEGORY_RESOURCE = "resource";
    private static final String CATEGORY_SDK_INIT = "sdk_init";
    private static final String CATEGORY_SESSION_END = "session_end";
    private static final String CATEGORY_SESSION_START = "user";
    private static final GAEvents INSTANCE = null;
    private static final int MAX_EVENTS_SIZE = 500;
    private static int countEnd;
    private static int countMissingEnd;
    private static int countUser;
    private static HashSet fixedMissingSessionEnds;
    private boolean isRunning;
    public static boolean isSdkInitEventEnabled;
    private boolean keepRunning;
    private static final IBlock processEventQueueBlock;

    static {
        GAEvents.INSTANCE = new GAEvents();
        GAEvents.isSdkInitEventEnabled = false;
        GAEvents.countEnd = 0;
        GAEvents.countUser = 0;
        GAEvents.countMissingEnd = 0;
        GAEvents.fixedMissingSessionEnds = new HashSet();
        GAEvents.processEventQueueBlock = new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                GAEvents.processEventQueue();
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "processEventQueue";
            }
        };
    }

    public static void addAdEvent(GAAdAction adAction, GAAdType adType, String adSdkName, String adPlacement, GAAdError noAdReason, long duration, boolean sendDuration, Map fields, boolean mergeFields) {
        if(!GAState.isEventSubmissionEnabled()) {
            return;
        }
        String s2 = adAction.toString();
        String s3 = adType.toString();
        String s4 = noAdReason.toString();
        ValidationResult validationResult0 = GAValidator.validateAdEvent(adAction, adType, adSdkName, adPlacement);
        if(validationResult0 != null) {
            GAHTTPApi.getInstance().sendSdkErrorEvent(validationResult0.category, validationResult0.area, validationResult0.action, validationResult0.parameter, validationResult0.reason, GAState.getGameKey(), GAState.getSecretKey());
            return;
        }
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("category", "ads");
            jSONObject0.put("ad_sdk_name", adSdkName);
            jSONObject0.put("ad_placement", adPlacement);
            jSONObject0.put("ad_type", s3);
            jSONObject0.put("ad_action", s2);
            if(adAction == GAAdAction.FailedShow && s4.length() > 0) {
                jSONObject0.put("ad_fail_show_reason", s4);
            }
            if(sendDuration && (adType == GAAdType.RewardedVideo || adType == GAAdType.Video)) {
                jSONObject0.put("ad_duration", duration);
            }
            GAEvents.addDimensionsToEvent(jSONObject0);
            HashMap hashMap0 = new HashMap((fields == null || fields.isEmpty() ? GAState.getGlobalCustomEventFields() : fields));
            if(mergeFields && fields != null && !fields.isEmpty()) {
                for(Object object0: GAState.getGlobalCustomEventFields().entrySet()) {
                    Map.Entry map$Entry0 = (Map.Entry)object0;
                    if(!hashMap0.containsKey(map$Entry0.getKey())) {
                        hashMap0.put(((String)map$Entry0.getKey()), map$Entry0.getValue());
                    }
                }
            }
            String s5 = "";
            GAEvents.addCustomFieldsToEvent(jSONObject0, GAState.validateAndCleanCustomFields(hashMap0));
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append("Add AD event: {ad_sdk_name:");
            stringBuilder0.append(adSdkName);
            stringBuilder0.append(", ad_placement:");
            stringBuilder0.append(adPlacement);
            stringBuilder0.append(", ad_type:");
            stringBuilder0.append(s3);
            stringBuilder0.append(", ad_action:");
            stringBuilder0.append(s2);
            stringBuilder0.append((adAction != GAAdAction.FailedShow || s4.length() <= 0 ? "" : ", ad_fail_show_reason:" + s4));
            if(sendDuration && (adType == GAAdType.RewardedVideo || adType == GAAdType.Video)) {
                s5 = ", ad_duration:" + duration;
            }
            stringBuilder0.append(s5);
            stringBuilder0.append("}");
            GALogger.i(stringBuilder0.toString());
            GAEvents.addEventToStore(jSONObject0);
        }
        catch(JSONException jSONException0) {
            GALogger.e("addAdEvent: Error creating json");
            jSONException0.printStackTrace();
        }
    }

    public static void addBusinessEvent(String currency, int amount, String itemType, String itemId, String cartType, String receipt, String store, String signature, Map fields, boolean mergeFields) {
        if(!GAState.isEventSubmissionEnabled()) {
            return;
        }
        ValidationResult validationResult0 = GAValidator.validateBusinessEvent(currency, ((long)amount), cartType, itemType, itemId, receipt, store, signature);
        if(validationResult0 != null) {
            GAHTTPApi.getInstance().sendSdkErrorEvent(validationResult0.category, validationResult0.area, validationResult0.action, validationResult0.parameter, validationResult0.reason, GAState.getGameKey(), GAState.getSecretKey());
            return;
        }
        JSONObject jSONObject0 = new JSONObject();
        GAState.incrementTransactionNum();
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add("transaction_num");
        arrayList0.add(String.valueOf(GAState.getTransactionNum()));
        GAStore.executeQuerySync("INSERT OR REPLACE INTO ga_state (key, value) VALUES(?, ?);", arrayList0);
        try {
            JSONObject jSONObject1 = new JSONObject();
            if(receipt != null && receipt.length() != 0) {
                try {
                    jSONObject1.put("receipt", Base64.encodeToString(receipt.getBytes("UTF-8"), 0));
                }
                catch(UnsupportedEncodingException unsupportedEncodingException0) {
                    unsupportedEncodingException0.printStackTrace();
                }
                jSONObject1.put("store", store);
                if(signature != null && signature.length() != 0) {
                    jSONObject1.put("signature", signature);
                }
            }
            jSONObject0.put("event_id", itemType + ":" + itemId);
            jSONObject0.put("category", "business");
            jSONObject0.put("currency", currency);
            jSONObject0.put("amount", amount);
            jSONObject0.put("transaction_num", GAState.getTransactionNum());
            if(cartType != null && cartType.length() != 0) {
                jSONObject0.put("cart_type", cartType);
            }
            if(jSONObject1.length() != 0) {
                jSONObject0.put("receipt_info", jSONObject1);
            }
            GAEvents.addDimensionsToEvent(jSONObject0);
            HashMap hashMap0 = new HashMap((fields == null || fields.isEmpty() ? GAState.getGlobalCustomEventFields() : fields));
            if(mergeFields && fields != null && !fields.isEmpty()) {
                for(Object object0: GAState.getGlobalCustomEventFields().entrySet()) {
                    Map.Entry map$Entry0 = (Map.Entry)object0;
                    if(!hashMap0.containsKey(map$Entry0.getKey())) {
                        hashMap0.put(((String)map$Entry0.getKey()), map$Entry0.getValue());
                    }
                }
            }
            String s7 = "";
            GAEvents.addCustomFieldsToEvent(jSONObject0, GAState.validateAndCleanCustomFields(hashMap0));
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append("Add BUSINESS event: {currency:");
            stringBuilder0.append(currency);
            stringBuilder0.append(", amount:");
            stringBuilder0.append(amount);
            stringBuilder0.append(", itemType:");
            stringBuilder0.append(itemType);
            stringBuilder0.append(", itemId:");
            stringBuilder0.append(itemId);
            stringBuilder0.append(", cartType:");
            stringBuilder0.append(cartType);
            if(receipt != null && receipt.length() != 0) {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(", receipt_info: { store: ");
                stringBuilder1.append(store);
                stringBuilder1.append(", receipt: #RECEIPT#");
                if(signature != null && signature.length() != 0) {
                    s7 = ", signature: " + signature;
                }
                stringBuilder1.append(s7);
                stringBuilder1.append("}");
                s7 = stringBuilder1.toString();
            }
            stringBuilder0.append(s7);
            stringBuilder0.append("}");
            GALogger.i(stringBuilder0.toString());
            GAEvents.addEventToStore(jSONObject0);
        }
        catch(JSONException jSONException0) {
            GALogger.e("addBusinessEvent: Error creating json");
            jSONException0.printStackTrace();
            String s8 = GAState.getGameKey();
            String s9 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Json, EGASdkErrorArea.BusinessEvent, EGASdkErrorAction.JsonError, jSONException0.toString(), s8, s9);
        }
    }

    private static void addCustomFieldsToEvent(JSONObject eventData, JSONObject fields) {
        if(eventData == null) {
            return;
        }
        if(fields != null) {
            try {
                if(fields.length() > 0) {
                    eventData.put("custom_fields", fields);
                }
            }
            catch(JSONException jSONException0) {
                GALogger.e("addFieldsToEvent: Error creating json");
                jSONException0.printStackTrace();
                String s = GAState.getGameKey();
                String s1 = GAState.getSecretKey();
                GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Json, EGASdkErrorArea.AddFields, EGASdkErrorAction.JsonError, jSONException0.toString(), s, s1);
            }
        }
    }

    public static void addDesignEvent(String eventId, double value, boolean sendValue, Map fields, boolean mergeFields) {
        if(!GAState.isEventSubmissionEnabled()) {
            return;
        }
        ValidationResult validationResult0 = GAValidator.validateDesignEvent(eventId);
        if(validationResult0 != null) {
            GAHTTPApi.getInstance().sendSdkErrorEvent(validationResult0.category, validationResult0.area, validationResult0.action, validationResult0.parameter, validationResult0.reason, GAState.getGameKey(), GAState.getSecretKey());
            return;
        }
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("category", "design");
            jSONObject0.put("event_id", eventId);
            if(sendValue) {
                jSONObject0.put("value", value);
            }
            GAEvents.addDimensionsToEvent(jSONObject0);
            HashMap hashMap0 = new HashMap((fields == null || fields.isEmpty() ? GAState.getGlobalCustomEventFields() : fields));
            if(mergeFields && fields != null && !fields.isEmpty()) {
                for(Object object0: GAState.getGlobalCustomEventFields().entrySet()) {
                    Map.Entry map$Entry0 = (Map.Entry)object0;
                    if(!hashMap0.containsKey(map$Entry0.getKey())) {
                        hashMap0.put(((String)map$Entry0.getKey()), map$Entry0.getValue());
                    }
                }
            }
            GAEvents.addCustomFieldsToEvent(jSONObject0, GAState.validateAndCleanCustomFields(hashMap0));
            GALogger.i(("Add DESIGN event: {eventId:" + eventId + ", value:" + value + "}"));
            GAEvents.addEventToStore(jSONObject0);
        }
        catch(JSONException jSONException0) {
            GALogger.e("addDesignEvent: Error creating json");
            jSONException0.printStackTrace();
            String s1 = GAState.getGameKey();
            String s2 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Json, EGASdkErrorArea.DesignEvent, EGASdkErrorAction.JsonError, jSONException0.toString(), s1, s2);
        }
    }

    public static void addDimensionsToEvent(JSONObject eventData) {
        try {
            if(eventData == null) {
                return;
            }
            if(GAState.getDimension01().length() != 0) {
                eventData.put("custom_01", GAState.getDimension01());
            }
            if(GAState.getDimension02().length() != 0) {
                eventData.put("custom_02", GAState.getDimension02());
            }
            if(GAState.getDimension03().length() != 0) {
                eventData.put("custom_03", GAState.getDimension03());
            }
        }
        catch(JSONException jSONException0) {
            GALogger.e("addDimensionsToEvent: Error creating json");
            jSONException0.printStackTrace();
            String s = GAState.getGameKey();
            String s1 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Json, EGASdkErrorArea.AddDimensions, EGASdkErrorAction.JsonError, jSONException0.toString(), s, s1);
        }
    }

    public static void addErrorEvent(GAErrorSeverity severity, String message, Map fields, boolean mergeFields, String method, int line, String module) {
        GAEvents.addErrorEvent(severity, message, fields, mergeFields, false, method, line, module);
    }

    public static void addErrorEvent(GAErrorSeverity severity, String message, Map fields, boolean mergeFields, boolean skipAddingFields, String method, int line, String module) {
        if(!GAState.isEventSubmissionEnabled()) {
            return;
        }
        String s3 = severity.toString();
        ValidationResult validationResult0 = GAValidator.validateErrorEvent(severity, message);
        if(validationResult0 != null) {
            GAHTTPApi.getInstance().sendSdkErrorEvent(validationResult0.category, validationResult0.area, validationResult0.action, validationResult0.parameter, validationResult0.reason, GAState.getGameKey(), GAState.getSecretKey());
            return;
        }
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("category", "error");
            jSONObject0.put("severity", s3);
            jSONObject0.put("message", message);
            GAEvents.addDimensionsToEvent(jSONObject0);
            if(!skipAddingFields) {
                HashMap hashMap0 = new HashMap((fields == null || fields.isEmpty() ? GAState.getGlobalCustomEventFields() : fields));
                if(mergeFields && fields != null && !fields.isEmpty()) {
                    for(Object object0: GAState.getGlobalCustomEventFields().entrySet()) {
                        Map.Entry map$Entry0 = (Map.Entry)object0;
                        if(!hashMap0.containsKey(map$Entry0.getKey())) {
                            hashMap0.put(((String)map$Entry0.getKey()), map$Entry0.getValue());
                        }
                    }
                }
                GAEvents.addCustomFieldsToEvent(jSONObject0, GAState.validateAndCleanCustomFields(hashMap0));
            }
            if(method != null && !method.isEmpty()) {
                jSONObject0.put("function_name", method);
            }
            if(line >= 0) {
                jSONObject0.put("line_number", line);
            }
            GALogger.i(("Add ERROR event: {severity:" + s3 + ", message:" + message + "}"));
            GAEvents.addEventToStore(jSONObject0);
        }
        catch(JSONException jSONException0) {
            GALogger.e("addErrorEvent: Error creating json");
            jSONException0.printStackTrace();
            String s4 = GAState.getGameKey();
            String s5 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Json, EGASdkErrorArea.ErrorEvent, EGASdkErrorAction.JsonError, jSONException0.toString(), s4, s5);
        }
    }

    // 去混淆评级： 低(22)
    private static void addEventToStore(JSONObject eventData) {
        if(!GAState.isEventSubmissionEnabled()) {
            return;
        }
        GALogger.w("Could not add event: SDK datastore error");
    }

    private static void addHealthAnnotations(JSONObject eventDict, DeviceInfo deviceInfo) {
        if(eventDict != null && deviceInfo != null) {
            try {
                if(DeviceInfo.enableHardwareTracking) {
                    if(deviceInfo.cpuName != null && !deviceInfo.cpuName.isEmpty()) {
                        eventDict.put("cpu_model", deviceInfo.cpuName);
                    }
                    if(deviceInfo.hardware != null && !deviceInfo.hardware.isEmpty()) {
                        eventDict.put("hardware", deviceInfo.hardware);
                    }
                    if(deviceInfo.numCores > 0) {
                        eventDict.put("cpu_num_cores", deviceInfo.numCores);
                    }
                }
                if(DeviceInfo.enableMemoryTracking) {
                    if(deviceInfo.memTotal > 0.0) {
                        eventDict.put("memory_sys_total", deviceInfo.memTotal);
                        eventDict.put("memory_sys_used", deviceInfo.UsedSysMemory());
                    }
                    if(deviceInfo.appMemoryUsage > 0.0) {
                        eventDict.put("memory_app_used", deviceInfo.appMemoryUsage);
                    }
                }
                if(DeviceInfo.enableStorageTracking) {
                    if(deviceInfo.totalDeviceStorage > 0.0) {
                        eventDict.put("storage_device_total", deviceInfo.totalDeviceStorage);
                    }
                    if(deviceInfo.availableDeviceStorage > 0.0) {
                        eventDict.put("storage_device_free", deviceInfo.availableDeviceStorage);
                    }
                    if(DeviceInfo.enableExternalStorageTracking) {
                        if(deviceInfo.totalExternalStorage > 0.0) {
                            eventDict.put("storage_external_total", deviceInfo.totalExternalStorage);
                        }
                        if(deviceInfo.availableExternalStorage > 0.0) {
                            eventDict.put("storage_external_free", deviceInfo.availableExternalStorage);
                        }
                    }
                }
                if(deviceInfo.screenHeight > 0 && deviceInfo.screenWidth > 0) {
                    eventDict.put("resolution", deviceInfo.screenWidth + 'x' + deviceInfo.screenHeight);
                }
            }
            catch(JSONException jSONException0) {
                jSONException0.printStackTrace();
            }
            catch(Throwable throwable0) {
                throwable0.printStackTrace();
            }
        }
    }

    public static void addHealthEvent(long[] frameData, boolean errorFlag) {
        if(!GAState.isEventSubmissionEnabled()) {
            return;
        }
        if(!0) {
            return;
        }
        try {
            JSONObject jSONObject0 = new JSONObject();
            if(DeviceInfo.enableFPSTracking) {
                JSONArray jSONArray0 = new JSONArray();
                if(frameData != null && frameData.length == 0x79) {
                    for(int v2 = 0; v2 < frameData.length; ++v2) {
                        jSONArray0.put(frameData[v2]);
                    }
                }
                else {
                    GALogger.e("addHealthEvent: Invalid fps metrics");
                    for(int v1 = 0; v1 < 0x79; ++v1) {
                        jSONArray0.put(0L);
                    }
                    errorFlag = true;
                }
                if(errorFlag) {
                    String s = GAState.getGameKey();
                    String s1 = GAState.getSecretKey();
                    GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Json, EGASdkErrorArea.HealthEvent, EGASdkErrorAction.JsonError, "An error occured during calculating the fps metrics. Fps health event may not be accurate", s, s1);
                    GALogger.e("addHealthEvent: Inaccurate fps reading.");
                }
                jSONObject0.put("fps_data_table", jSONArray0);
            }
            DeviceInfo gADevice$DeviceInfo0 = GADevice.ReadDeviceInfo();
            jSONObject0.put("category", "health");
            GAEvents.addHealthAnnotations(jSONObject0, gADevice$DeviceInfo0);
            if(DeviceInfo.enableMemoryTracking && DeviceInfo.enableMemoryHistograms) {
                int[] arr_v1 = DeviceInfo.GetAppMemoryPercentage();
                int[] arr_v2 = DeviceInfo.GetSysMemoryPercentage();
                if(arr_v2 != null && arr_v2.length > 0) {
                    JSONArray jSONArray1 = new JSONArray();
                    for(int v3 = 0; v3 < arr_v2.length; ++v3) {
                        jSONArray1.put(arr_v2[v3]);
                    }
                    jSONObject0.put("memory_sys_data_table", jSONArray1);
                }
                if(arr_v1 != null && arr_v1.length > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    for(int v = 0; v < arr_v1.length; ++v) {
                        jSONArray2.put(arr_v1[v]);
                    }
                    jSONObject0.put("memory_app_data_table", jSONArray2);
                }
            }
            GAEvents.addDimensionsToEvent(jSONObject0);
            GAEvents.addCustomFieldsToEvent(jSONObject0, GAState.validateAndCleanCustomFields(GAState.getGlobalCustomEventFields()));
            GAEvents.addEventToStore(jSONObject0);
            GALogger.i("Add HEALTH event.");
        }
        catch(JSONException jSONException0) {
            GALogger.e("addHealthEvent: Error creating json");
            jSONException0.printStackTrace();
            String s2 = GAState.getGameKey();
            String s3 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Json, EGASdkErrorArea.HealthEvent, EGASdkErrorAction.JsonError, jSONException0.toString(), s2, s3);
        }
        catch(Throwable throwable0) {
            throwable0.printStackTrace();
        }
    }

    public static void addImpressionEvent(String adNetworkName, String adNetworkVersion, JSONObject impressionData, Map fields, boolean mergeFields) {
        if(!GAState.isEventSubmissionEnabled()) {
            return;
        }
        ValidationResult validationResult0 = GAValidator.validateImpressionEvent(adNetworkName, adNetworkVersion, impressionData);
        if(validationResult0 != null) {
            GAHTTPApi.getInstance().sendSdkErrorEvent(validationResult0.category, validationResult0.area, validationResult0.action, validationResult0.parameter, validationResult0.reason, GAState.getGameKey(), GAState.getSecretKey());
            return;
        }
        JSONObject jSONObject1 = new JSONObject();
        try {
            jSONObject1.put("category", "impression");
            jSONObject1.put("ad_network_name", adNetworkName);
            jSONObject1.put("ad_network_version", adNetworkVersion);
            if(impressionData != null && impressionData.length() > 0) {
                jSONObject1.put("impression_data", impressionData);
            }
            GAEvents.addDimensionsToEvent(jSONObject1);
            HashMap hashMap0 = new HashMap((fields == null || fields.isEmpty() ? GAState.getGlobalCustomEventFields() : fields));
            if(mergeFields && fields != null && !fields.isEmpty()) {
                for(Object object0: GAState.getGlobalCustomEventFields().entrySet()) {
                    Map.Entry map$Entry0 = (Map.Entry)object0;
                    if(!hashMap0.containsKey(map$Entry0.getKey())) {
                        hashMap0.put(((String)map$Entry0.getKey()), map$Entry0.getValue());
                    }
                }
            }
            GAEvents.addCustomFieldsToEvent(jSONObject1, GAState.validateAndCleanCustomFields(hashMap0));
            GALogger.i(("Add IMPRESSION event: {ad_network_name:" + adNetworkName + ", ad_network_version:" + adNetworkVersion + ", impression_data:#impressionData}"));
            GAEvents.addEventToStore(jSONObject1);
        }
        catch(JSONException jSONException0) {
            GALogger.e("addImpressionEvent: Error creating json");
            jSONException0.printStackTrace();
        }
    }

    public static void addProgressionEvent(GAProgressionStatus progressionStatus, String progression01, String progression02, String progression03, int score, boolean sendScore, Map fields, boolean mergeFields) {
        int v1;
        String s4;
        if(!GAState.isEventSubmissionEnabled()) {
            return;
        }
        String s3 = progressionStatus.toString();
        ValidationResult validationResult0 = GAValidator.validateProgressionEvent(progressionStatus, progression01, progression02, progression03);
        if(validationResult0 != null) {
            GAHTTPApi.getInstance().sendSdkErrorEvent(validationResult0.category, validationResult0.area, validationResult0.action, validationResult0.parameter, validationResult0.reason, GAState.getGameKey(), GAState.getSecretKey());
            return;
        }
        JSONObject jSONObject0 = new JSONObject();
        if(progression02 == null || progression02.length() == 0) {
            s4 = progression01;
        }
        else if(progression03 != null && progression03.length() != 0) {
            s4 = progression01 + ":" + progression02 + ":" + progression03;
        }
        else {
            s4 = progression01 + ":" + progression02;
        }
        try {
            jSONObject0.put("category", "progression");
            jSONObject0.put("event_id", s3 + ":" + s4);
            if(sendScore && progressionStatus != GAProgressionStatus.Start) {
                jSONObject0.put("score", score);
            }
            if(progressionStatus == GAProgressionStatus.Fail) {
                GAState.incrementProgressionTries(s4);
            }
            if(progressionStatus == GAProgressionStatus.Complete) {
                GAState.incrementProgressionTries(s4);
                v1 = GAState.getProgressionTries(s4);
                jSONObject0.put("attempt_num", v1);
                GAState.clearProgressionTries(s4);
            }
            else {
                v1 = 0;
            }
            GAEvents.addDimensionsToEvent(jSONObject0);
            HashMap hashMap0 = new HashMap((fields == null || fields.isEmpty() ? GAState.getGlobalCustomEventFields() : fields));
            if(mergeFields && fields != null && !fields.isEmpty()) {
                for(Object object0: GAState.getGlobalCustomEventFields().entrySet()) {
                    Map.Entry map$Entry0 = (Map.Entry)object0;
                    if(!hashMap0.containsKey(map$Entry0.getKey())) {
                        hashMap0.put(((String)map$Entry0.getKey()), map$Entry0.getValue());
                    }
                }
            }
            GAEvents.addCustomFieldsToEvent(jSONObject0, GAState.validateAndCleanCustomFields(hashMap0));
            GALogger.i(("Add PROGRESSION event: {status:" + s3 + ", progression01:" + progression01 + ", progression02:" + progression02 + ", progression03:" + progression03 + ", score:" + score + ", attempt:" + v1 + "}"));
            GAEvents.addEventToStore(jSONObject0);
        }
        catch(JSONException jSONException0) {
            GALogger.e("addProgressionEvent: Error creating json");
            jSONException0.printStackTrace();
            String s5 = GAState.getGameKey();
            String s6 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Json, EGASdkErrorArea.ProgressionEvent, EGASdkErrorAction.JsonError, jSONException0.toString(), s5, s6);
        }
    }

    public static void addResourceEvent(GAResourceFlowType flowType, String currency, double amount, String itemType, String itemId, Map fields, boolean mergeFields) {
        if(!GAState.isEventSubmissionEnabled()) {
            return;
        }
        ValidationResult validationResult0 = GAValidator.validateResourceEvent(flowType, currency, ((long)amount), itemType, itemId);
        if(validationResult0 != null) {
            GAHTTPApi.getInstance().sendSdkErrorEvent(validationResult0.category, validationResult0.area, validationResult0.action, validationResult0.parameter, validationResult0.reason, GAState.getGameKey(), GAState.getSecretKey());
            return;
        }
        if(flowType == GAResourceFlowType.Sink) {
            amount *= -1.0;
        }
        try {
            JSONObject jSONObject0 = new JSONObject();
            jSONObject0.put("event_id", flowType.toString() + ":" + currency + ":" + itemType + ":" + itemId);
            jSONObject0.put("category", "resource");
            jSONObject0.put("amount", amount);
            GAEvents.addDimensionsToEvent(jSONObject0);
            HashMap hashMap0 = new HashMap((fields == null || fields.isEmpty() ? GAState.getGlobalCustomEventFields() : fields));
            if(mergeFields && fields != null && !fields.isEmpty()) {
                for(Object object0: GAState.getGlobalCustomEventFields().entrySet()) {
                    Map.Entry map$Entry0 = (Map.Entry)object0;
                    if(!hashMap0.containsKey(map$Entry0.getKey())) {
                        hashMap0.put(((String)map$Entry0.getKey()), map$Entry0.getValue());
                    }
                }
            }
            GAEvents.addCustomFieldsToEvent(jSONObject0, GAState.validateAndCleanCustomFields(hashMap0));
            GALogger.i(("Add RESOURCE event: {currency:" + currency + ", amount:" + amount + ", itemType:" + itemType + ", itemId:" + itemId + "}"));
            GAEvents.addEventToStore(jSONObject0);
        }
        catch(JSONException jSONException0) {
            GALogger.e("addResourceEvent: Error creating json");
            jSONException0.printStackTrace();
            String s3 = GAState.getGameKey();
            String s4 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Json, EGASdkErrorArea.ResourceEvent, EGASdkErrorAction.JsonError, jSONException0.toString(), s3, s4);
        }
    }

    public static void addSdkInitEvent() {
        if(!GAEvents.isSdkInitEventEnabled) {
            return;
        }
        JSONObject jSONObject0 = new JSONObject();
        DeviceInfo gADevice$DeviceInfo0 = GADevice.ReadDeviceInfo();
        try {
            GAEvents.addHealthAnnotations(jSONObject0, gADevice$DeviceInfo0);
            jSONObject0.put("category", "sdk_init");
            jSONObject0.put("app_boot_time", DeviceInfo.GetAppUptime());
            jSONObject0.put("is_first_sdk_init", GAState.getSessionNum() == 1);
            GAEvents.addDimensionsToEvent(jSONObject0);
            GAEvents.addCustomFieldsToEvent(jSONObject0, GAState.validateAndCleanCustomFields(GAState.getGlobalCustomEventFields()));
            GAEvents.addEventToStore(jSONObject0);
            GALogger.i("Add SDK_INIT event.");
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        catch(Throwable throwable0) {
            throwable0.printStackTrace();
        }
    }

    public static void addSessionEndEvent() {
        if(!GAState.isEventSubmissionEnabled()) {
            return;
        }
        int v = GAEvents.countEnd + 1;
        GAEvents.countEnd = v;
        if(v > GAEvents.countUser) {
            GALogger.e(("Invalid pairs of user/end session events:" + GAEvents.countUser + "-" + GAEvents.countEnd));
        }
        long v1 = GAState.getSessionStart();
        long v2 = GAState.getClientTsAdjusted() - v1;
        if(v2 < 0L) {
            GALogger.w("Session length was calculated to be less then 0. Should not be possible. Resetting to 0.");
            v2 = 0L;
        }
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("category", "session_end");
            jSONObject0.put("length", v2);
        }
        catch(JSONException jSONException0) {
            GALogger.e("addSessionEndEvent: error creating json");
            jSONException0.printStackTrace();
            String s = GAState.getGameKey();
            String s1 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Json, EGASdkErrorArea.SessionEnd, EGASdkErrorAction.JsonError, jSONException0.toString(), s, s1);
        }
        GAEvents.addDimensionsToEvent(jSONObject0);
        GAEvents.addCustomFieldsToEvent(jSONObject0, GAState.validateAndCleanCustomFields(GAState.getGlobalCustomEventFields()));
        GAEvents.addEventToStore(jSONObject0);
        GALogger.i("Add SESSION END event.");
        GAEvents.processEvents("", false);
    }

    public static void addSessionStartEvent() {
        if(!GAState.isEventSubmissionEnabled()) {
            return;
        }
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("category", "user");
            if(GAState.isNewInstall()) {
                jSONObject0.put("install", true);
                GAState.setNewInstall(false);
            }
        }
        catch(JSONException jSONException0) {
            GALogger.e("addSessionStartEvent: error creating json");
            jSONException0.printStackTrace();
        }
        GAState.incrementSessionNum();
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add("session_num");
        arrayList0.add(String.valueOf(GAState.getSessionNum()));
        GAStore.executeQuerySync("INSERT OR REPLACE INTO ga_state (key, value) VALUES(?, ?);", arrayList0);
        SharedPreferences sharedPreferences0 = GAPlatform.getApplicationContext().getSharedPreferences("GameAnalytics", 0);
        if(sharedPreferences0 != null) {
            SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
            sharedPreferences$Editor0.putInt("ga_session_num", GAState.getSessionNum());
            sharedPreferences$Editor0.apply();
        }
        GAEvents.addDimensionsToEvent(jSONObject0);
        GAEvents.addCustomFieldsToEvent(jSONObject0, GAState.validateAndCleanCustomFields(GAState.getGlobalCustomEventFields()));
        int v = GAEvents.countUser + 1;
        GAEvents.countUser = v;
        if(GAEvents.countEnd > v) {
            GALogger.e(("Invalid pairs of user/end session events:" + GAEvents.countUser + "-" + GAEvents.countEnd));
            String s = GAState.getGameKey();
            String s1 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.EventValidation, EGASdkErrorArea.SessionEnd, EGASdkErrorAction.JsonError, "Duplicate session end events", s, s1);
        }
        GAEvents.addEventToStore(jSONObject0);
        GALogger.i("Add SESSION START event");
        GAEvents.processEvents("user", false);
    }

    public static void cleanupEvents() {
        GAStore.executeQuerySync("UPDATE ga_events SET status = \'new\';");
    }

    public static void ensureEventQueueIsRunning() {
        GAEvents.getInstance().keepRunning = true;
        if(!GAEvents.getInstance().isRunning) {
            GAEvents.getInstance().isRunning = true;
            GAThreading.scheduleTimer(8.0, GAEvents.processEventQueueBlock);
        }
    }

    public static void fixMissingSessionEndEvents() throws JSONException {
        if(!GAState.isEventSubmissionEnabled()) {
            return;
        }
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(GAState.getSessionId());
        JSONArray jSONArray0 = GAStore.executeQuerySync("SELECT timestamp, event FROM ga_session WHERE session_id != ?;", arrayList0);
        if(jSONArray0 != null && jSONArray0.length() != 0) {
            GALogger.i((jSONArray0.length() + " session(s) located with missing session_end event."));
            for(int v = 0; v < jSONArray0.length(); ++v) {
                JSONObject jSONObject0 = jSONArray0.getJSONObject(v);
                JSONObject jSONObject1 = GAUtilities.dictionary(jSONObject0.getString("event"));
                long v1 = jSONObject1.getLong("client_ts");
                long v2 = jSONObject0.optLong("timestamp", 0L);
                long v3 = Math.max(0L, v1 - v2);
                int v4 = jSONObject1.getInt("session_num");
                if(GAEvents.fixedMissingSessionEnds.contains(v4)) {
                    GALogger.e("fixMissingSessionEndEvents duplicate session_end!");
                }
                else {
                    GAEvents.fixedMissingSessionEnds.add(v4);
                    GALogger.d(("fixMissingSessionEndEvents length calculated: " + v3 + ", start_ts=" + v2 + ", event_ts=" + v1 + "-> for session " + v4));
                    jSONObject1.put("category", "session_end");
                    jSONObject1.put("length", v3);
                    GAEvents.addEventToStore(jSONObject1);
                }
            }
        }
    }

    private static GAEvents getInstance() {
        return GAEvents.INSTANCE;
    }

    private static void processEventQueue() {
        GAEvents.processEvents("", true);
        if(GAEvents.getInstance().keepRunning) {
            GAThreading.scheduleTimer(8.0, GAEvents.processEventQueueBlock);
            return;
        }
        GAEvents.getInstance().isRunning = false;
    }

    public static void processEvents(String category, boolean performCleanup) {
        if(!GAState.doSendEvents()) {
            return;
        }
        try {
            if(performCleanup) {
                GAEvents.cleanupEvents();
                GAEvents.fixMissingSessionEndEvents();
            }
            String s1 = category.length() == 0 ? "" : " AND category=\'" + category + "\' ";
            String s2 = "UPDATE ga_events SET status = \'92ef49d5-633a-40cd-a35a-d74b7ba68b53\' WHERE status = \'new\' " + s1 + ";";
            JSONArray jSONArray0 = GAStore.executeQuerySync(("SELECT event FROM ga_events WHERE status = \'new\' " + s1 + ";"));
            if(jSONArray0 == null || jSONArray0.length() == 0) {
                GALogger.i("Event queue: No events to send");
                GAEvents.updateSessionTime();
                return;
            }
            if(jSONArray0.length() > 500) {
                JSONArray jSONArray1 = GAStore.executeQuerySync(("SELECT client_ts FROM ga_events WHERE status = \'new\' " + s1 + " ORDER BY client_ts ASC LIMIT 0,500;"));
                if(jSONArray1 == null) {
                    return;
                }
                String s3 = ((JSONObject)jSONArray1.get(jSONArray1.length() - 1)).getString("client_ts");
                JSONArray jSONArray2 = GAStore.executeQuerySync(("SELECT event FROM ga_events WHERE status = \'new\' " + s1 + " AND client_ts<=\'" + s3 + "\';"));
                if(jSONArray2 == null) {
                    return;
                }
                s2 = "UPDATE ga_events SET status=\'92ef49d5-633a-40cd-a35a-d74b7ba68b53\' WHERE status=\'new\' " + s1 + " AND client_ts<=\'" + s3 + "\';";
                jSONArray0 = jSONArray2;
            }
            GALogger.i(("Event queue: Sending " + jSONArray0.length() + " events."));
            if(GAStore.executeQuerySync(s2) == null) {
                return;
            }
            ArrayList arrayList0 = new ArrayList();
            for(int v = 0; v < jSONArray0.length(); ++v) {
                JSONObject jSONObject0 = GAUtilities.dictionary(((JSONObject)jSONArray0.get(v)).getString("event"));
                if(jSONObject0.length() != 0) {
                    if(jSONObject0.has("client_ts") && !GAValidator.validateClientTs(jSONObject0.getLong("client_ts"))) {
                        jSONObject0.remove("client_ts");
                    }
                    arrayList0.add(jSONObject0);
                }
            }
            GAHTTPApiResponseJSONObjectPair gAHTTPApi$GAHTTPApiResponseJSONObjectPair0 = GAHTTPApi.getInstance().sendEventsInArray(arrayList0);
            EGAHTTPApiResponse eGAHTTPApiResponse0 = gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.response;
            JSONObject jSONObject1 = gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.json;
            if(eGAHTTPApiResponse0 == EGAHTTPApiResponse.Ok) {
                GAStore.executeQuerySync("DELETE FROM ga_events WHERE status = \'92ef49d5-633a-40cd-a35a-d74b7ba68b53\'");
                GALogger.i(("Event queue: " + jSONArray0.length() + " events sent."));
                return;
            }
            if(eGAHTTPApiResponse0 == EGAHTTPApiResponse.NoResponse) {
                GALogger.w("Event queue: Failed to send events to collector - Retrying next time");
                GAStore.executeQuerySync("UPDATE ga_events SET status = \'new\' WHERE status = \'92ef49d5-633a-40cd-a35a-d74b7ba68b53\';");
                return;
            }
            if(jSONObject1 == null) {
                GALogger.w("Event queue: Failed to send events.");
            }
            else {
                Object object0 = new JSONTokener(jSONObject1.toString()).nextValue();
                GALogger.d(jSONObject1.toString());
                if(eGAHTTPApiResponse0 != EGAHTTPApiResponse.BadRequest || !(object0 instanceof JSONArray)) {
                    GALogger.w("Event queue: Failed to send events.");
                }
                else {
                    GALogger.w(("Event queue: " + jSONArray0.length() + " events sent. " + jSONObject1.length() + " events failed GA server validation."));
                }
            }
            GAStore.executeQuerySync("DELETE FROM ga_events WHERE status = \'92ef49d5-633a-40cd-a35a-d74b7ba68b53\'");
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
            String s4 = GAState.getGameKey();
            String s5 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Json, EGASdkErrorArea.ProcessEvents, EGASdkErrorAction.JsonError, jSONException0.toString(), s4, s5);
        }
    }

    public static void stopEventQueue() {
        GAEvents.getInstance().keepRunning = false;
    }

    private static void updateSessionTime() throws JSONException {
        if(GAState.sessionIsStarted()) {
            JSONObject jSONObject0 = GAState.getEventAnnotations();
            GAEvents.addDimensionsToEvent(jSONObject0);
            GAEvents.addCustomFieldsToEvent(jSONObject0, GAState.validateAndCleanCustomFields(GAState.getGlobalCustomEventFields()));
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(jSONObject0.getString("session_id"));
            arrayList0.add(String.valueOf(GAState.getSessionStart()));
            arrayList0.add(jSONObject0.toString());
            GAStore.executeQuerySync("INSERT OR REPLACE INTO ga_session(session_id, timestamp, event) VALUES(?, ?, ?);", arrayList0);
        }
    }
}

