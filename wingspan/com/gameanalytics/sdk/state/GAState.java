package com.gameanalytics.sdk.state;

import android.animation.ValueAnimator;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.gameanalytics.sdk.GAErrorSeverity;
import com.gameanalytics.sdk.GAPlatform.FunctionInfo;
import com.gameanalytics.sdk.GAPlatform;
import com.gameanalytics.sdk.IRemoteConfigsListener;
import com.gameanalytics.sdk.device.GADevice.DeviceInfo;
import com.gameanalytics.sdk.device.GADevice;
import com.gameanalytics.sdk.events.EGASdkErrorAction;
import com.gameanalytics.sdk.events.EGASdkErrorArea;
import com.gameanalytics.sdk.events.EGASdkErrorCategory;
import com.gameanalytics.sdk.events.GAEvents;
import com.gameanalytics.sdk.http.EGAHTTPApiResponse;
import com.gameanalytics.sdk.http.GAHTTPApi.GAHTTPApiResponseJSONObjectPair;
import com.gameanalytics.sdk.http.GAHTTPApi;
import com.gameanalytics.sdk.logging.GALogger;
import com.gameanalytics.sdk.store.GAStore;
import com.gameanalytics.sdk.threading.GAThreading;
import com.gameanalytics.sdk.threading.IBlock;
import com.gameanalytics.sdk.utilities.GAUtilities;
import com.gameanalytics.sdk.validators.GAValidator;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GAState {
    private static final String CATEGORY_SDK_ERROR = "sdk_error";
    private static final GAState INSTANCE = null;
    private static final int MAX_CUSTOM_FIELDS_COUNT = 50;
    private static final int MAX_CUSTOM_FIELDS_KEY_LENGTH = 0x40;
    private static final int MAX_CUSTOM_FIELDS_VALUE_STRING_LENGTH = 0x100;
    private static final int MAX_ERROR_COUNT = 10;
    private String abId;
    private String abVariantId;
    private boolean autoDetectAppVersion;
    private String[] availableCustomDimensions01;
    private String[] availableCustomDimensions02;
    private String[] availableCustomDimensions03;
    private String[] availableResourceCurrencies;
    private String[] availableResourceItemTypes;
    private String build;
    private long clientServerTimeOffset;
    private String configsHash;
    private JSONObject configurations;
    static int countEndSession = 0;
    private static final HashMap countMap = null;
    private String currentCustomDimension01;
    private String currentCustomDimension02;
    private String currentCustomDimension03;
    private final Map currentGlobalCustomEventFields;
    private AtomicBoolean doSampleFps;
    private AtomicBoolean doSampleMemory;
    private boolean doSendEvents;
    private boolean enableErrorReporting;
    private boolean enableEventSubmision;
    private String externalUserId;
    private final long fpsSampleFrequency;
    private long[] fpsTable;
    public static final int fpsTableLength = 0x79;
    private String gameKey;
    private boolean healthEventErrorFlag;
    private boolean inForeground;
    private boolean initAuthorized;
    boolean isFirstTimeRunning;
    private boolean isInitialized;
    long lastFpsLogTimestamp;
    long lastMemSampleTimestamp;
    long lastTimestamp;
    public static final int maxFpsValue = 120;
    private final long memSampleFrequency;
    private boolean newInstall;
    private final HashMap progressionTries;
    private boolean remoteConfigsIsReady;
    private final ArrayList remoteConfigsListeners;
    private int samplesFpsLastFrame;
    private JSONObject sdkConfig;
    private JSONObject sdkConfigCached;
    private final JSONObject sdkConfigDefault;
    private String secretKey;
    private String sessionId;
    private int sessionNum;
    private long sessionStart;
    private int sumFpsLastFrame;
    private static final HashMap timestampMap;
    private int transactionNum;
    private static boolean useManualSessionHandling;
    private boolean useRandomId;
    private String userId;
    private ValueAnimator v_animator;
    private boolean wasFpsTrackingStarted;

    static {
        GAState.INSTANCE = new GAState();
        GAState.countMap = new HashMap();
        GAState.timestampMap = new HashMap();
        GAState.countEndSession = 0;
    }

    private GAState() {
        this.sdkConfig = null;
        this.sdkConfigCached = null;
        this.sdkConfigDefault = new JSONObject();
        this.configurations = new JSONObject();
        this.remoteConfigsListeners = new ArrayList();
        this.availableCustomDimensions01 = new String[0];
        this.availableCustomDimensions02 = new String[0];
        this.availableCustomDimensions03 = new String[0];
        this.currentCustomDimension01 = "";
        this.currentCustomDimension02 = "";
        this.currentCustomDimension03 = "";
        this.currentGlobalCustomEventFields = new HashMap();
        this.doSendEvents = true;
        this.availableResourceCurrencies = new String[0];
        this.availableResourceItemTypes = new String[0];
        this.build = "";
        this.sessionId = "";
        this.progressionTries = new HashMap();
        this.userId = "";
        this.externalUserId = "";
        this.enableErrorReporting = true;
        this.enableEventSubmision = true;
        this.configsHash = "";
        this.abId = "";
        this.abVariantId = "";
        this.autoDetectAppVersion = false;
        this.inForeground = true;
        this.healthEventErrorFlag = false;
        this.gameKey = "";
        this.secretKey = "";
        this.lastTimestamp = 0L;
        this.lastFpsLogTimestamp = 0L;
        this.lastMemSampleTimestamp = 0L;
        this.isFirstTimeRunning = true;
        this.sumFpsLastFrame = 0;
        this.samplesFpsLastFrame = 0;
        this.fpsSampleFrequency = 1000L;
        this.memSampleFrequency = 5000L;
        this.fpsTable = new long[0x79];
        this.wasFpsTrackingStarted = false;
        this.doSampleFps = new AtomicBoolean(false);
        this.doSampleMemory = new AtomicBoolean(false);
        this.logFPS();
    }

    private static void addErrorEvent(String baseMessage, GAErrorSeverity severity, String message) {
        if(!GAState.isEventSubmissionEnabled()) {
            return;
        }
        Date date0 = new Date();
        HashMap hashMap0 = GAState.timestampMap;
        if(!hashMap0.containsKey(baseMessage)) {
            hashMap0.put(baseMessage, date0);
        }
        HashMap hashMap1 = GAState.countMap;
        if(!hashMap1.containsKey(baseMessage)) {
            hashMap1.put(baseMessage, 0);
        }
        long v = date0.getTime();
        long v1 = ((Date)hashMap0.get(baseMessage)).getTime();
        if(TimeUnit.MILLISECONDS.toMinutes(v - v1) >= 60L) {
            hashMap1.put(baseMessage, 0);
            hashMap0.put(baseMessage, date0);
        }
        if(((int)(((Integer)hashMap1.get(baseMessage)))) >= 10) {
            return;
        }
        GAThreading.performTaskOnGAThread(new IBlock() {
            @Override  // com.gameanalytics.sdk.threading.IBlock
            public void execute() {
                GAEvents.addErrorEvent(severity, message, null, true, new FunctionInfo().method, new FunctionInfo().line, new FunctionInfo().module);
                HashMap hashMap0 = GAState.countMap;
                Integer integer0 = (int)(((int)(((Integer)GAState.countMap.get(baseMessage)))) + 1);
                hashMap0.put(baseMessage, integer0);
            }

            @Override  // com.gameanalytics.sdk.threading.IBlock
            public String getName() {
                return "addErrorEvent";
            }
        });
    }

    public static void addRemoteConfigsListener(IRemoteConfigsListener listener) {
        if(!GAState.getInstance().remoteConfigsListeners.contains(listener)) {
            GAState.getInstance().remoteConfigsListeners.add(listener);
        }
    }

    // 去混淆评级： 低(20)
    private static long calculateServerTimeOffset(long serverTs) {
        return serverTs - 0x692F37CFL;
    }

    public static void clearProgressionTries(String progression) {
        HashMap hashMap0 = GAState.getInstance().progressionTries;
        if(hashMap0.containsKey(progression)) {
            hashMap0.remove(progression);
        }
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(progression);
        GAStore.executeQuerySync("DELETE FROM ga_progression WHERE progression = ?;", arrayList0);
    }

    public static boolean doSendEvents() {
        return GAState.getInstance().doSendEvents;
    }

    public static void enableFpsSampling(boolean value) {
        DeviceInfo.enableFPSTracking = value;
        GAState.INSTANCE.doSampleFps.set(value);
    }

    public static void enableMemorySampling(boolean value) {
        DeviceInfo.enableMemoryHistograms = value;
        GAState.INSTANCE.doSampleMemory.set(value);
        if(value) {
            DeviceInfo.enableMemoryTracking = true;
        }
    }

    public static void endSessionAndStopQueue() {
        if(GAState.isInitialized()) {
            ++GAState.countEndSession;
            GALogger.i(("End session: " + GAState.countEndSession));
            if(GAState.isEnabled() && GAState.sessionIsStarted()) {
                GALogger.i("Ending session.");
                GAEvents.stopEventQueue();
                GAEvents.addHealthEvent(GAState.getInstance().fpsTable, GAState.getInstance().healthEventErrorFlag);
                GAEvents.addSessionEndEvent();
                GAState.getInstance().sessionStart = 0L;
                GAThreading.stop();
            }
        }
    }

    private static void ensurePersistedStates() throws JSONException {
        JSONObject jSONObject0 = new JSONObject();
        JSONArray jSONArray0 = GAStore.executeQuerySync("SELECT * FROM ga_state;");
        if(jSONArray0 != null && jSONArray0.length() != 0) {
            for(int v1 = 0; v1 < jSONArray0.length(); ++v1) {
                JSONObject jSONObject1 = jSONArray0.getJSONObject(v1);
                jSONObject0.put(jSONObject1.getString("key"), jSONObject1.get("value"));
            }
        }
        GAState gAState0 = GAState.getInstance();
        gAState0.sessionNum = jSONObject0.optInt("session_num", 0);
        SharedPreferences sharedPreferences0 = GAPlatform.getApplicationContext().getSharedPreferences("GameAnalytics", 0);
        if(sharedPreferences0 != null) {
            if(gAState0.sessionNum == 0) {
                gAState0.sessionNum = sharedPreferences0.getInt("ga_session_num", 0);
            }
            gAState0.abId = sharedPreferences0.getString("ga_ab_id", gAState0.abId);
            gAState0.abVariantId = sharedPreferences0.getString("ga_ab_variant_id", gAState0.abVariantId);
        }
        gAState0.transactionNum = jSONObject0.optInt("transaction_num", 0);
        if(jSONObject0.has("new_install")) {
            boolean z = jSONObject0.optBoolean("new_install", false);
            gAState0.newInstall = z;
            if(z) {
                GALogger.d(("new_install found in DB: " + gAState0.newInstall));
            }
        }
        else if(GAStore.setState("new_install", "false")) {
            gAState0.newInstall = true;
            GALogger.d("new_install not found in DB initializing value to \'true\'");
        }
        else {
            GALogger.d("Failed to set value for key=\'new_install\' in DB");
        }
        if(jSONObject0.has("use_random_id")) {
            gAState0.useRandomId = jSONObject0.optBoolean("use_random_id", false);
        }
        if(gAState0.newInstall) {
            if(GAStore.setState("use_random_id", "true")) {
                gAState0.useRandomId = true;
                GALogger.d("use_random_id not found in DB initializing value to \'true\'");
            }
            else {
                GALogger.d("Failed to set value for key=\'use_random_id\' in DB");
            }
        }
        if(gAState0.useRandomId) {
            GALogger.d("Using random generated id as user_id");
        }
        if(TextUtils.isEmpty(gAState0.currentCustomDimension01)) {
            String s = jSONObject0.optString("dimension01", "");
            gAState0.currentCustomDimension01 = s;
            if(s.length() != 0) {
                GALogger.d(("Dimension01 found in cache: " + gAState0.currentCustomDimension01));
            }
        }
        else {
            GAStore.setState("dimension01", gAState0.currentCustomDimension01);
        }
        if(TextUtils.isEmpty(gAState0.currentCustomDimension02)) {
            String s1 = jSONObject0.optString("dimension02", "");
            gAState0.currentCustomDimension02 = s1;
            if(s1.length() != 0) {
                GALogger.d(("Dimension02 found cache: " + gAState0.currentCustomDimension02));
            }
        }
        else {
            GAStore.setState("dimension02", gAState0.currentCustomDimension02);
        }
        if(TextUtils.isEmpty(gAState0.currentCustomDimension03)) {
            String s2 = jSONObject0.optString("dimension03", "");
            gAState0.currentCustomDimension03 = s2;
            if(s2.length() != 0) {
                GALogger.d(("Dimension03 found in cache: " + gAState0.currentCustomDimension03));
            }
        }
        else {
            GAStore.setState("dimension03", gAState0.currentCustomDimension03);
        }
        String s3 = jSONObject0.optString("sdk_config_cached", "");
        if(s3.length() != 0) {
            JSONObject jSONObject2 = GAUtilities.dictionary(s3);
            if(jSONObject2.length() != 0) {
                if(!GAState.getLastUsedIdentifier().equals(GAState.getIdentifier())) {
                    GALogger.w("New identifier spotted compared to last one used, clearing cached configs hash!!");
                    jSONObject2.remove("configs_hash");
                }
                gAState0.sdkConfigCached = jSONObject2;
            }
        }
        GAState.getInstance().configsHash = GAState.getSdkConfig().optString("configs_hash", "");
        GAState.getInstance().abId = GAState.getSdkConfig().optString("ab_id", gAState0.abId);
        GAState.getInstance().abVariantId = GAState.getSdkConfig().optString("ab_variant_id", gAState0.abVariantId);
        if(sharedPreferences0 != null) {
            SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
            if(!TextUtils.isEmpty(gAState0.abId)) {
                sharedPreferences$Editor0.putString("ga_ab_id", gAState0.abId);
            }
            if(!TextUtils.isEmpty(gAState0.abVariantId)) {
                sharedPreferences$Editor0.putString("ga_ab_variant_id", gAState0.abVariantId);
            }
            sharedPreferences$Editor0.apply();
        }
        JSONArray jSONArray1 = GAStore.executeQuerySync("SELECT * FROM ga_progression;");
        if(jSONArray1 != null && jSONArray1.length() != 0) {
            for(int v = 0; v < jSONArray1.length(); ++v) {
                JSONObject jSONObject3 = jSONArray1.getJSONObject(v);
                String s4 = jSONObject3.getString("progression");
                Integer integer0 = jSONObject3.getInt("tries");
                gAState0.progressionTries.put(s4, integer0);
            }
        }
    }

    public static String getABTestingId() {
        return GAState.getInstance().abId;
    }

    public static String getABTestingVariantId() {
        return GAState.getInstance().abVariantId;
    }

    private static String getBuild() {
        return GAState.getInstance().build;
    }

    // 去混淆评级： 低(20)
    public static long getClientTsAdjusted() {
        long v = GAState.getInstance().clientServerTimeOffset + 0x692F37CFL;
        return GAValidator.validateClientTs(v) ? v : 0x692F37CFL;
    }

    private static String getConfigsHash() {
        return GAState.getInstance().configsHash;
    }

    public static String getDimension01() {
        return GAState.getInstance().currentCustomDimension01;
    }

    public static String getDimension02() {
        return GAState.getInstance().currentCustomDimension02;
    }

    public static String getDimension03() {
        return GAState.getInstance().currentCustomDimension03;
    }

    public static JSONObject getEventAnnotations() throws JSONException {
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("v", 2);
        jSONObject0.put("user_id", GAState.getIdentifier());
        jSONObject0.put("event_uuid", "89dff681-4564-49c0-9f71-9dabf2c16a63");
        if(!TextUtils.isEmpty(GADevice.getOAID()) && !GAUtilities.isZeroId(GADevice.getOAID())) {
            jSONObject0.put("oaid", GADevice.getOAID());
        }
        if(!TextUtils.isEmpty(GADevice.getAppSetId())) {
            jSONObject0.put("android_app_set_id", GADevice.getAppSetId());
        }
        if(GAState.getInstance().configurations != null && GAState.getInstance().configurations.length() > 0) {
            jSONObject0.put("configurations", GAState.getInstance().configurations);
        }
        if(!TextUtils.isEmpty(GAState.getInstance().abId)) {
            jSONObject0.put("ab_id", GAState.getInstance().abId);
        }
        if(!TextUtils.isEmpty(GAState.getInstance().abVariantId)) {
            jSONObject0.put("ab_variant_id", GAState.getInstance().abVariantId);
        }
        jSONObject0.put("client_ts", GAState.getClientTsAdjusted());
        jSONObject0.put("sdk_version", "android 6.5.2");
        jSONObject0.put("os_version", "android " + GADevice.getOSVersion());
        jSONObject0.put("manufacturer", GADevice.getDeviceManufacturer());
        jSONObject0.put("device", GADevice.getDeviceModel());
        jSONObject0.put("platform", "android");
        jSONObject0.put("session_id", GAState.getInstance().sessionId);
        jSONObject0.put("session_num", GAState.getSessionNum());
        String s = GADevice.getConnectionType();
        if(GAValidator.validateConnectionType(s)) {
            jSONObject0.put("connection_type", s);
        }
        String s1 = GADevice.getBundleIdentifier();
        if(GAValidator.validateBundleID(s1)) {
            jSONObject0.put("android_bundle_id", s1);
        }
        String s2 = GADevice.getAppVersion();
        if(GAValidator.validateAppVersion(s2)) {
            jSONObject0.put("android_app_version", s2);
        }
        if(GAValidator.validateAppBuild(0)) {
            jSONObject0.put("android_app_build", "0");
        }
        String s3 = GADevice.getAppSignature();
        if(GAValidator.validateAppSignature(s3)) {
            jSONObject0.put("android_app_signature", s3);
        }
        String s4 = GADevice.getChannelId();
        if(GAValidator.validateChannelId(s4)) {
            jSONObject0.put("android_channel_id", s4);
        }
        if(!TextUtils.isEmpty(GAState.getExternalUserId())) {
            jSONObject0.put("user_id_ext", GAState.getExternalUserId());
        }
        if(GAState.getBuild().length() != 0) {
            jSONObject0.put("build", GAState.getBuild());
        }
        return jSONObject0;
    }

    public static String getExternalUserId() {
        return GAState.getInstance().externalUserId;
    }

    public static String getGameKey() {
        return GAState.getInstance().gameKey;
    }

    public static Map getGlobalCustomEventFields() {
        return GAState.getInstance().currentGlobalCustomEventFields;
    }

    public static String getIdentifier() {
        String s = GAState.getUserId();
        if(!TextUtils.isEmpty(s)) {
            GALogger.d("getIdentifier: Using custom user id");
            GAState.updateLastUsedIdentifier(s);
            return s;
        }
        if(GADevice.doTrackGAID) {
            String s1 = GADevice.getOAID();
            if(!GAState.getInstance().useRandomId && !TextUtils.isEmpty(s1) && !GAUtilities.isZeroId(s1)) {
                GALogger.d("getIdentifier: Using OAID");
                GAState.updateLastUsedIdentifier(s1);
                return s1;
            }
        }
        if(GAState.getInstance().useRandomId) {
            SharedPreferences sharedPreferences0 = GAPlatform.getApplicationContext().getSharedPreferences("GameAnalytics", 0);
            if(sharedPreferences0 != null) {
                GALogger.d("getIdentifier: Using random id");
                String s2 = sharedPreferences0.getString("ga_random_user_id", "");
                if(TextUtils.isEmpty(s2)) {
                    SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
                    s2 = "c4be4b69-ecf4-4347-bba0-b7d774fa3d55";
                    sharedPreferences$Editor0.putString("ga_random_user_id", "c4be4b69-ecf4-4347-bba0-b7d774fa3d55");
                    sharedPreferences$Editor0.apply();
                }
                GAState.updateLastUsedIdentifier(s2);
                return s2;
            }
        }
        SharedPreferences sharedPreferences1 = GAPlatform.getApplicationContext().getSharedPreferences("GameAnalytics", 0);
        if(sharedPreferences1 != null) {
            GALogger.d("getIdentifier: Using random id");
            String s3 = sharedPreferences1.getString("ga_random_user_id", "");
            if(TextUtils.isEmpty(s3)) {
                SharedPreferences.Editor sharedPreferences$Editor1 = sharedPreferences1.edit();
                s3 = "855e8dfa-6eb5-4fb0-b066-5f333228c914";
                sharedPreferences$Editor1.putString("ga_random_user_id", "855e8dfa-6eb5-4fb0-b066-5f333228c914");
                sharedPreferences$Editor1.apply();
            }
            GAState.updateLastUsedIdentifier(s3);
            return s3;
        }
        return "00000000-0000-0000-0000-000000000000";
    }

    public static JSONObject getInitAnnotations() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("user_id", (GAState.isEventSubmissionEnabled() ? GAState.getIdentifier() : ""));
            jSONObject0.put("sdk_version", "android 6.5.2");
            jSONObject0.put("os_version", "android " + GADevice.getOSVersion());
            jSONObject0.put("platform", "android");
            if(TextUtils.isEmpty(GAState.getBuild())) {
                jSONObject0.put("build", null);
            }
            else {
                jSONObject0.put("build", GAState.getBuild());
            }
            if(!TextUtils.isEmpty(GAState.getInstance().abId)) {
                jSONObject0.put("ab_id", GAState.getInstance().abId);
            }
            if(!TextUtils.isEmpty(GAState.getInstance().abVariantId)) {
                jSONObject0.put("ab_variant_id", GAState.getInstance().abVariantId);
            }
            jSONObject0.put("session_num", GAState.getSessionNum());
            jSONObject0.put("random_salt", GAState.getSessionNum());
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
            String s = GAState.getGameKey();
            String s1 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Json, EGASdkErrorArea.InitRequest, EGASdkErrorAction.FailHttpJsonDecode, jSONException0.toString(), s, s1);
        }
        return jSONObject0;
    }

    private static GAState getInstance() {
        return GAState.INSTANCE;
    }

    private static String getLastUsedIdentifier() {
        SharedPreferences sharedPreferences0 = GAPlatform.getApplicationContext().getSharedPreferences("GameAnalytics", 0);
        return sharedPreferences0 == null ? null : sharedPreferences0.getString("ga_last_used_identifier", "");
    }

    // 去混淆评级： 低(20)
    public static int getProgressionTries(String progression) {
        return GAState.getInstance().progressionTries.containsKey(progression) ? ((int)(((Integer)GAState.getInstance().progressionTries.get(progression)))) : 0;
    }

    public static JSONObject getRemoteConfigsContentAsJson() {
        try {
            return new JSONObject(GAState.getInstance().configurations.toString());
        }
        catch(JSONException unused_ex) {
            return null;
        }
    }

    public static String getRemoteConfigsContentAsString() {
        try {
            return GAState.getInstance().configurations.toString(4);
        }
        catch(JSONException unused_ex) {
            return GAState.getInstance().configurations.toString();
        }
    }

    public static String getRemoteConfigsStringValue(String key, String defaultValue) {
        return GAState.getInstance().configurations.optString(key, defaultValue);
    }

    private static JSONObject getSdkConfig() {
        if(GAState.getInstance().sdkConfig != null) {
            return GAState.getInstance().sdkConfig;
        }
        return GAState.getInstance().sdkConfigCached == null ? GAState.getInstance().sdkConfigDefault : GAState.getInstance().sdkConfigCached;
    }

    public static JSONObject getSdkErrorEventAnnotations() throws JSONException {
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("v", 2);
        jSONObject0.put("event_uuid", "a9094af0-aea2-486e-8d6b-fb63824a630b");
        jSONObject0.put("category", "sdk_error");
        jSONObject0.put("sdk_version", "android 6.5.2");
        jSONObject0.put("os_version", "android " + GADevice.getOSVersion());
        jSONObject0.put("manufacturer", GADevice.getDeviceManufacturer());
        jSONObject0.put("device", GADevice.getDeviceModel());
        jSONObject0.put("platform", "android");
        return jSONObject0;
    }

    public static String getSecretKey() {
        return GAState.getInstance().secretKey;
    }

    public static String getSessionId() {
        return GAState.getInstance().sessionId;
    }

    public static int getSessionNum() {
        return GAState.getInstance().sessionNum;
    }

    public static long getSessionStart() {
        return GAState.getInstance().sessionStart;
    }

    public static int getTransactionNum() {
        return GAState.getInstance().transactionNum;
    }

    public static String getUserId() {
        return GAState.getInstance().userId;
    }

    public static boolean hasAvailableCustomDimensions01(String dimension1) {
        return GAUtilities.stringArrayContainsString(GAState.getInstance().availableCustomDimensions01, dimension1);
    }

    public static boolean hasAvailableCustomDimensions02(String dimension2) {
        return GAUtilities.stringArrayContainsString(GAState.getInstance().availableCustomDimensions02, dimension2);
    }

    public static boolean hasAvailableCustomDimensions03(String dimension3) {
        return GAUtilities.stringArrayContainsString(GAState.getInstance().availableCustomDimensions03, dimension3);
    }

    public static boolean hasAvailableResourceCurrency(String currency) {
        return GAUtilities.stringArrayContainsString(GAState.getInstance().availableResourceCurrencies, currency);
    }

    public static boolean hasAvailableResourceItemType(String itemType) {
        return GAUtilities.stringArrayContainsString(GAState.getInstance().availableResourceItemTypes, itemType);
    }

    public static void incrementProgressionTries(String progression) {
        int v = GAState.getProgressionTries(progression);
        GAState.getInstance().progressionTries.put(progression, ((int)(v + 1)));
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(progression);
        arrayList0.add(v + 1 + "");
        GAStore.executeQuerySync("INSERT OR REPLACE INTO ga_progression (progression, tries) VALUES(?, ?);", arrayList0);
    }

    public static void incrementSessionNum() {
        GAState.getInstance().sessionNum = GAState.getSessionNum() + 1;
    }

    public static void incrementTransactionNum() {
        GAState.getInstance().transactionNum = GAState.getTransactionNum() + 1;
    }

    // 去混淆评级： 低(40)
    public static void internalInitialize() {
    }

    public static boolean isAutoDetectAppVersionEnabled() {
        return GAState.getInstance().autoDetectAppVersion;
    }

    public static boolean isEnabled() {
        return GAState.getInstance().initAuthorized;
    }

    public static boolean isEventSubmissionEnabled() {
        return GAState.getInstance().enableEventSubmision;
    }

    public static boolean isInForeground() {
        return GAState.getInstance().inForeground;
    }

    public static boolean isInitialized() {
        return GAState.getInstance().isInitialized;
    }

    public static boolean isNewInstall() {
        return GAState.getInstance().newInstall;
    }

    public static boolean isRemoteConfigsReady() {
        return GAState.getInstance().remoteConfigsIsReady;
    }

    // 检测为 Lambda 实现
    void lambda$logFPS$0$com-gameanalytics-sdk-state-GAState(ValueAnimator valueAnimator0) [...]

    private void logFPS() {
        try {
            this.lastTimestamp = System.currentTimeMillis();
            ValueAnimator valueAnimator0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.v_animator = valueAnimator0;
            valueAnimator0.setRepeatCount(-1);
            this.v_animator.addUpdateListener((ValueAnimator valueAnimator0) -> try {
                long v = System.currentTimeMillis();
                if(this.isFirstTimeRunning) {
                    for(int v1 = 0; v1 < 0x79; ++v1) {
                        this.fpsTable[v1] = 0L;
                    }
                    this.lastTimestamp = v;
                    this.isFirstTimeRunning = false;
                    return;
                }
                long v2 = Math.max(v - this.lastTimestamp, 1L);
                if(this.inForeground) {
                    int v3 = (int)Math.max(Math.min(Math.round(1000.0 / ((double)v2)), 120L), 0L);
                    if(Long.compare(v - this.lastFpsLogTimestamp, 1000L) >= 0) {
                        this.lastFpsLogTimestamp = v;
                        int v4 = Math.max(this.sumFpsLastFrame, 1);
                        int v5 = Math.max(this.samplesFpsLastFrame, 1);
                        this.samplesFpsLastFrame = 0;
                        this.sumFpsLastFrame = 0;
                        ++this.fpsTable[v4 / v5];
                    }
                    this.sumFpsLastFrame += v3;
                    ++this.samplesFpsLastFrame;
                    if(this.doSampleMemory.get() && v - this.lastMemSampleTimestamp >= 5000L) {
                        this.lastMemSampleTimestamp = v;
                        DeviceInfo.SampleMemoryUsage();
                    }
                }
                this.lastTimestamp = v;
            }
            catch(Exception exception0) {
                GALogger.e(("Failed to sample health metrics: " + exception0.getMessage()));
            }
            catch(Throwable throwable0) {
                GALogger.e(("Failed to sample health metrics: " + throwable0.getMessage()));
            });
            this.v_animator.start();
            this.wasFpsTrackingStarted = true;
        }
        catch(RuntimeException runtimeException0) {
            this.healthEventErrorFlag = true;
            GALogger.e(("Failed to log FPS (please ensure you are running on the main thread):" + runtimeException0.getMessage()));
        }
        catch(Throwable throwable0) {
            this.healthEventErrorFlag = true;
            GALogger.e(("Failed to log FPS with reason:" + throwable0.getMessage()));
        }
    }

    private static void populateConfigurations(JSONObject sdkConfig) {
        synchronized(GAState.getInstance().configurations) {
            JSONArray jSONArray0 = sdkConfig.optJSONArray("configs");
            if(jSONArray0 != null) {
                GAState.getInstance().configurations = new JSONObject();
                for(int v1 = 0; v1 < jSONArray0.length(); ++v1) {
                    JSONObject jSONObject2 = jSONArray0.optJSONObject(v1);
                    if(jSONObject2 != null) {
                        String s = jSONObject2.optString("key");
                        Object object0 = jSONObject2.opt("value");
                        long v2 = jSONObject2.optLong("start_ts", 0xFFFFFFFF80000000L);
                        long v3 = jSONObject2.optLong("end_ts", 0x7FFFFFFFL);
                        long v4 = GAState.getClientTsAdjusted();
                        if(s != null && object0 != null && v4 > v2 && v4 < v3) {
                            try {
                                GAState.getInstance().configurations.put(s, object0);
                                GALogger.d(("configuration added: " + jSONObject2.toString()));
                            }
                            catch(JSONException unused_ex) {
                                GALogger.w(("populateConfigurations failed - unable to add configuration \'" + s + "\'."));
                            }
                        }
                    }
                }
            }
            GAState.getInstance().remoteConfigsIsReady = true;
            for(Object object1: GAState.getInstance().remoteConfigsListeners) {
                ((IRemoteConfigsListener)object1).onRemoteConfigsUpdated();
            }
        }
    }

    public static void removeRemoteConfigsListener(IRemoteConfigsListener listener) {
        if(GAState.getInstance().remoteConfigsListeners.contains(listener)) {
            GAState.getInstance().remoteConfigsListeners.remove(listener);
        }
    }

    public static void resumeSessionAndStartQueue() {
        if(!GAState.isInitialized()) {
            return;
        }
        if(!GAState.sessionIsStarted()) {
            GALogger.i("Resuming session.");
            GAThreading.start();
            GAState.startNewSession();
        }
    }

    public static boolean sessionIsStarted() {
        return ((double)GAState.getInstance().sessionStart) != 0.0;
    }

    public static void setAutoDetectAppVersion(boolean flag) {
        GAState.getInstance().autoDetectAppVersion = flag;
        if(flag) {
            GALogger.i("Enabled auto detect app version for build field");
            return;
        }
        GALogger.i("Disabled auto detect app version for build field");
    }

    public static void setAvailableCustomDimensions01(String[] availableCustomDimensions) {
        if(!GAValidator.validateCustomDimensions(availableCustomDimensions)) {
            return;
        }
        GAState.getInstance().availableCustomDimensions01 = availableCustomDimensions;
        GAState.validateAndFixCurrentDimensions();
        GALogger.i(("Set available custom01 dimension values: (" + GAUtilities.joinStringArray(availableCustomDimensions, ", ") + ")"));
    }

    public static void setAvailableCustomDimensions02(String[] availableCustomDimensions) {
        if(!GAValidator.validateCustomDimensions(availableCustomDimensions)) {
            return;
        }
        GAState.getInstance().availableCustomDimensions02 = availableCustomDimensions;
        GAState.validateAndFixCurrentDimensions();
        GALogger.i(("Set available custom02 dimension values: (" + GAUtilities.joinStringArray(availableCustomDimensions, ", ") + ")"));
    }

    public static void setAvailableCustomDimensions03(String[] availableCustomDimensions) {
        if(!GAValidator.validateCustomDimensions(availableCustomDimensions)) {
            return;
        }
        GAState.getInstance().availableCustomDimensions03 = availableCustomDimensions;
        GAState.validateAndFixCurrentDimensions();
        GALogger.i(("Set available custom03 dimension values: (" + GAUtilities.joinStringArray(availableCustomDimensions, ", ") + ")"));
    }

    public static void setAvailableResourceCurrencies(String[] availableResourceCurrencies) {
        if(!GAValidator.validateResourceCurrencies(availableResourceCurrencies)) {
            return;
        }
        GAState.getInstance().availableResourceCurrencies = availableResourceCurrencies;
        GALogger.i(("Set available resource currencies: (" + GAUtilities.joinStringArray(availableResourceCurrencies, ", ") + ")"));
    }

    public static void setAvailableResourceItemTypes(String[] availableResourceItemTypes) {
        if(!GAValidator.validateResourceItemTypes(availableResourceItemTypes)) {
            return;
        }
        GAState.getInstance().availableResourceItemTypes = availableResourceItemTypes;
        GALogger.i(("Set available resource item types: (" + GAUtilities.joinStringArray(availableResourceItemTypes, ", ") + ")"));
    }

    public static void setBuild(String build) {
        GAState.getInstance().build = build;
        GALogger.i(("Set build version: " + build));
    }

    public static void setCustomDimension01(String dimension) {
        GAState.getInstance().currentCustomDimension01 = dimension;
        GALogger.i(("Set custom01 dimension value: " + dimension));
    }

    public static void setCustomDimension02(String dimension) {
        GAState.getInstance().currentCustomDimension02 = dimension;
        GALogger.i(("Set custom02 dimension value: " + dimension));
    }

    public static void setCustomDimension03(String dimension) {
        GAState.getInstance().currentCustomDimension03 = dimension;
        GALogger.i(("Set custom03 dimension value: " + dimension));
    }

    public static void setEnableErrorReporting(boolean flag) {
        GALogger.d(("setEnableErrorReporting: " + flag));
        GAState.getInstance().enableErrorReporting = flag;
    }

    public static void setEnableEventSubmission(boolean flag, boolean doCacheEventsLocally) {
        GAState.getInstance().doSendEvents = flag;
        if(flag) {
            GAState.getInstance().enableEventSubmision = true;
            return;
        }
        GAState.getInstance().enableEventSubmision = doCacheEventsLocally;
    }

    public static void setExternalUserId(String userId) {
        GAState.getInstance().externalUserId = userId;
    }

    public static void setGlobalCustomEventFields(Map customFields) {
        if(customFields != null && !customFields.isEmpty()) {
            GAState.getInstance().currentGlobalCustomEventFields.clear();
            GAState.getInstance().currentGlobalCustomEventFields.putAll(customFields);
            GALogger.i(("Set global custom event fields: " + new JSONObject(customFields)));
            return;
        }
        GAState.getInstance().currentGlobalCustomEventFields.clear();
    }

    public static void setInForeground(boolean value) {
        GAState.getInstance().inForeground = value;
    }

    public static void setInitialized(boolean isInitialized) {
        GAState.getInstance().isInitialized = isInitialized;
    }

    public static void setKeys(String gameKey, String gameSecret) {
        GAState.getInstance().gameKey = gameKey;
        GAState.getInstance().secretKey = gameSecret;
    }

    public static void setManualSessionHandling(boolean flag) {
        GAState.useManualSessionHandling = flag;
        GALogger.i(("Use manual session handling: " + flag));
    }

    public static void setNewInstall(boolean newInstall) {
        GAState.getInstance().newInstall = newInstall;
    }

    public static void setUserId(String uId) {
        GAState gAState0 = GAState.getInstance();
        if(uId == null) {
            uId = "";
        }
        gAState0.userId = uId;
        GALogger.i(("Set user id: " + GAState.getInstance().userId));
    }

    public static void startAnimator() {
        ValueAnimator valueAnimator0 = GAState.INSTANCE.v_animator;
        if(valueAnimator0 != null) {
            try {
                valueAnimator0.start();
            }
            catch(Throwable throwable0) {
                throwable0.printStackTrace();
            }
        }
    }

    private static void startNewSession() {
        if(GAState.isEventSubmissionEnabled()) {
            GALogger.i("Starting a new session.");
        }
        GAState.validateAndFixCurrentDimensions();
        if(GAState.isAutoDetectAppVersionEnabled()) {
            String s = GADevice.getAppVersion();
            if(GAValidator.validateAppVersion(s)) {
                GAState.setBuild(s);
                GALogger.i(("Auto detecting app version and setting build field to: " + s));
            }
        }
        GADevice.reloadAdId();
        GAHTTPApiResponseJSONObjectPair gAHTTPApi$GAHTTPApiResponseJSONObjectPair0 = GAHTTPApi.getInstance().requestInitReturningDict(GAState.getInstance().configsHash);
        EGAHTTPApiResponse eGAHTTPApiResponse0 = gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.response;
        JSONObject jSONObject0 = gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.json;
        if((eGAHTTPApiResponse0 == EGAHTTPApiResponse.Ok || eGAHTTPApiResponse0 == EGAHTTPApiResponse.Created) && jSONObject0 != null) {
            long v1 = ((double)jSONObject0.optLong("server_ts", -1L)) > 0.0 ? GAState.calculateServerTimeOffset(jSONObject0.optLong("server_ts", -1L)) : 0L;
            try {
                jSONObject0.put("time_offset", v1);
            }
            catch(JSONException jSONException0) {
                GALogger.e("startNewSession: error creating json");
                jSONException0.printStackTrace();
            }
            if(eGAHTTPApiResponse0 != EGAHTTPApiResponse.Created) {
                try {
                    if(GAState.getSdkConfig().has("configs")) {
                        jSONObject0.put("configs", GAState.getSdkConfig().optJSONArray("configs"));
                    }
                    if(GAState.getSdkConfig().has("configs_hash")) {
                        jSONObject0.put("configs_hash", GAState.getSdkConfig().optString("configs_hash", ""));
                    }
                    if(GAState.getSdkConfig().has("ab_id")) {
                        jSONObject0.put("ab_id", GAState.getSdkConfig().optString("ab_id", ""));
                    }
                    if(GAState.getSdkConfig().has("ab_variant_id")) {
                        jSONObject0.put("ab_variant_id", GAState.getSdkConfig().optString("ab_variant_id", ""));
                    }
                }
                catch(JSONException jSONException1) {
                    GALogger.e("startNewSession: error creating json");
                    jSONException1.printStackTrace();
                }
            }
            GAState.getInstance().configsHash = jSONObject0.optString("configs_hash", "");
            GAState.getInstance().abId = jSONObject0.optString("ab_id", "");
            GAState.getInstance().abVariantId = jSONObject0.optString("ab_variant_id", "");
            GAStore.setState("sdk_config_cached", jSONObject0.toString());
            GAState.getInstance().sdkConfigCached = jSONObject0;
            GAState.getInstance().sdkConfig = jSONObject0;
            GAState.getInstance().initAuthorized = true;
        }
        else if(eGAHTTPApiResponse0 == EGAHTTPApiResponse.Unauthorized) {
            GALogger.w("Initialize SDK failed - Unauthorized");
            GAState.getInstance().initAuthorized = false;
        }
        else {
            if(eGAHTTPApiResponse0 == EGAHTTPApiResponse.NoResponse || eGAHTTPApiResponse0 == EGAHTTPApiResponse.RequestTimeout) {
                GALogger.i("Init call (session start) failed - no response. Could be offline or timeout.");
            }
            else if(eGAHTTPApiResponse0 == EGAHTTPApiResponse.BadResponse || eGAHTTPApiResponse0 == EGAHTTPApiResponse.JsonEncodeFailed || eGAHTTPApiResponse0 == EGAHTTPApiResponse.JsonDecodeFailed) {
                GALogger.i("Init call (session start) failed - bad response. Could be bad response from proxy or GA servers.");
            }
            else if(eGAHTTPApiResponse0 == EGAHTTPApiResponse.BadRequest || eGAHTTPApiResponse0 == EGAHTTPApiResponse.UnknownResponseCode) {
                GALogger.i("Init call (session start) failed - bad request or unknown response.");
            }
            if(GAState.getInstance().sdkConfig != null) {
                GALogger.i("Init call (session start) failed - using cached init values.");
            }
            else if(GAState.getInstance().sdkConfigCached != null) {
                GALogger.i("Init call (session start) failed - using cached init values.");
                GAState.getInstance().sdkConfig = GAState.getInstance().sdkConfigCached;
            }
            else {
                GALogger.i("Init call (session start) failed - using default init values.");
                GAState.getInstance().sdkConfig = GAState.getInstance().sdkConfigDefault;
            }
            GAState.getInstance().initAuthorized = true;
        }
        GAState.getInstance().clientServerTimeOffset = GAState.getSdkConfig().optLong("time_offset", 0L);
        GAState.populateConfigurations(GAState.getSdkConfig());
        if(!GAState.isEnabled()) {
            GALogger.w("Could not start session: SDK is disabled.");
            GAEvents.stopEventQueue();
            return;
        }
        GAEvents.ensureEventQueueIsRunning();
        GAState.getInstance().sessionId = "466a02df-bf6b-449c-95e3-526de96e4795";
        GAState.getInstance().sessionStart = GAState.getClientTsAdjusted();
        for(int v = 0; v < 120; ++v) {
            GAState.getInstance().fpsTable[v] = 0L;
        }
        GAEvents.addSessionStartEvent();
    }

    public static void stopAnimator() {
        ValueAnimator valueAnimator0 = GAState.INSTANCE.v_animator;
        if(valueAnimator0 != null) {
            try {
                valueAnimator0.end();
            }
            catch(Throwable throwable0) {
                throwable0.printStackTrace();
            }
        }
    }

    private static void updateLastUsedIdentifier(String currentId) {
        SharedPreferences sharedPreferences0 = GAPlatform.getApplicationContext().getSharedPreferences("GameAnalytics", 0);
        if(sharedPreferences0 != null && !TextUtils.isEmpty(currentId) && !currentId.equals(GAState.getLastUsedIdentifier())) {
            GALogger.d(("updateLastUsedIdentifier: newId=" + currentId));
            SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
            sharedPreferences$Editor0.putString("ga_last_used_identifier", currentId);
            sharedPreferences$Editor0.apply();
        }
    }

    public static boolean useErrorReporting() {
        return GAState.getInstance().enableErrorReporting;
    }

    public static boolean useManualSessionHandling() [...] // 潜在的解密器

    public static JSONObject validateAndCleanCustomFields(Map fields) {
        JSONObject jSONObject0 = new JSONObject();
        if(fields != null) {
            int v = 0;
            for(Object object0: fields.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                if(map$Entry0.getKey() == null || map$Entry0.getValue() == null) {
                    String s10 = String.format("validateAndCleanCustomFields: entry with key=%s, value=%s has been omitted because its key or value is null", map$Entry0.getKey(), map$Entry0.getValue());
                    GALogger.w(s10);
                    GAState.addErrorEvent("validateAndCleanCustomFields: entry with key=%s, value=%s has been omitted because its key or value is null", GAErrorSeverity.Warning, s10);
                }
                else if(v >= 50) {
                    String s9 = String.format("validateAndCleanCustomFields: entry with key=%s, value=%s has been omitted because it exceeds the max number of custom fields (50)", map$Entry0.getKey(), map$Entry0.getValue().toString());
                    GALogger.w(s9);
                    GAState.addErrorEvent("validateAndCleanCustomFields: entry with key=%s, value=%s has been omitted because it exceeds the max number of custom fields (50)", GAErrorSeverity.Warning, s9);
                }
                else if(!GAUtilities.stringMatch(((String)map$Entry0.getKey()), "^[a-zA-Z0-9_]{1,64}$")) {
                    String s8 = String.format("validateAndCleanCustomFields: entry with key=%s, value=%s has been omitted because its key contains illegal character, is empty or exceeds the max number of characters (64)", map$Entry0.getKey(), map$Entry0.getValue().toString());
                    GALogger.w(s8);
                    GAState.addErrorEvent("validateAndCleanCustomFields: entry with key=%s, value=%s has been omitted because its key contains illegal character, is empty or exceeds the max number of characters (64)", GAErrorSeverity.Warning, s8);
                }
                else if(map$Entry0.getValue() instanceof Character) {
                    String s = map$Entry0.getValue().toString();
                    if(s.length() > 0x100 || s.length() <= 0) {
                        String s2 = String.format("validateAndCleanCustomFields: entry with key=%s, value=%s has been omitted because its value is an empty string or exceeds the max number of characters (256)", map$Entry0.getKey(), map$Entry0.getValue().toString());
                        GALogger.w(s2);
                        GAState.addErrorEvent("validateAndCleanCustomFields: entry with key=%s, value=%s has been omitted because its value is an empty string or exceeds the max number of characters (256)", GAErrorSeverity.Warning, s2);
                    }
                    else {
                        try {
                            jSONObject0.put(((String)map$Entry0.getKey()), s);
                            ++v;
                        }
                        catch(JSONException unused_ex) {
                            String s1 = String.format("validateAndCleanCustomFields: entry with key=%s, value=%s could not be added as JSON", map$Entry0.getKey(), map$Entry0.getValue().toString());
                            GALogger.w(s1);
                            GAState.addErrorEvent("validateAndCleanCustomFields: entry with key=%s, value=%s could not be added as JSON", GAErrorSeverity.Warning, s1);
                        }
                    }
                }
                else if(map$Entry0.getValue() instanceof String) {
                    String s3 = (String)map$Entry0.getValue();
                    if(s3.length() > 0x100 || s3.length() <= 0) {
                        String s5 = String.format("validateAndCleanCustomFields: entry with key=%s, value=%s has been omitted because its value is an empty string or exceeds the max number of characters (256)", map$Entry0.getKey(), map$Entry0.getValue().toString());
                        GALogger.w(s5);
                        GAState.addErrorEvent("validateAndCleanCustomFields: entry with key=%s, value=%s has been omitted because its value is an empty string or exceeds the max number of characters (256)", GAErrorSeverity.Warning, s5);
                    }
                    else {
                        try {
                            jSONObject0.put(((String)map$Entry0.getKey()), s3);
                            ++v;
                        }
                        catch(JSONException unused_ex) {
                            String s4 = String.format("validateAndCleanCustomFields: entry with key=%s, value=%s could not be added as JSON", map$Entry0.getKey(), map$Entry0.getValue().toString());
                            GALogger.w(s4);
                            GAState.addErrorEvent("validateAndCleanCustomFields: entry with key=%s, value=%s could not be added as JSON", GAErrorSeverity.Warning, s4);
                        }
                    }
                }
                else if(map$Entry0.getValue() instanceof Number) {
                    Number number0 = (Number)map$Entry0.getValue();
                    try {
                        jSONObject0.put(((String)map$Entry0.getKey()), number0);
                    }
                    catch(JSONException unused_ex) {
                        String s6 = String.format("validateAndCleanCustomFields: entry with key=%s, value=%s could not be added as JSON", map$Entry0.getKey(), map$Entry0.getValue().toString());
                        GALogger.w(s6);
                        GAState.addErrorEvent("validateAndCleanCustomFields: entry with key=%s, value=%s could not be added as JSON", GAErrorSeverity.Warning, s6);
                        continue;
                    }
                    ++v;
                }
                else {
                    String s7 = String.format("validateAndCleanCustomFields: entry with key=%s, value=%s has been omitted because its value is not a string or number", map$Entry0.getKey(), map$Entry0.getValue().toString());
                    GALogger.w(s7);
                    GAState.addErrorEvent("validateAndCleanCustomFields: entry with key=%s, value=%s has been omitted because its value is not a string or number", GAErrorSeverity.Warning, s7);
                }
            }
        }
        return jSONObject0;
    }

    private static void validateAndFixCurrentDimensions() {
        if(!GAValidator.validateDimension01(GAState.getInstance().currentCustomDimension01)) {
            GALogger.d(("Invalid dimension01 found in variable. Setting to nil. Invalid dimension: " + GAState.getInstance().currentCustomDimension01));
            GAState.setCustomDimension01("");
        }
        if(!GAValidator.validateDimension02(GAState.getInstance().currentCustomDimension02)) {
            GALogger.d(("Invalid dimension02 found in variable. Setting to nil. Invalid dimension: " + GAState.getInstance().currentCustomDimension02));
            GAState.setCustomDimension02("");
        }
        if(!GAValidator.validateDimension03(GAState.getInstance().currentCustomDimension03)) {
            GALogger.d(("Invalid dimension03 found in variable. Setting to nil. Invalid dimension: " + GAState.getInstance().currentCustomDimension03));
            GAState.setCustomDimension03("");
        }
    }
}

