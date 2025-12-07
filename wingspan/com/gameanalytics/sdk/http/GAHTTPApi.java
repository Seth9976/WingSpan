package com.gameanalytics.sdk.http;

import android.text.TextUtils;
import com.gameanalytics.sdk.events.EGASdkErrorAction;
import com.gameanalytics.sdk.events.EGASdkErrorArea;
import com.gameanalytics.sdk.events.EGASdkErrorCategory;
import com.gameanalytics.sdk.events.EGASdkErrorParameter;
import com.gameanalytics.sdk.events.SdkErrorTask;
import com.gameanalytics.sdk.logging.GALogger;
import com.gameanalytics.sdk.state.GAState;
import com.gameanalytics.sdk.utilities.GAUtilities;
import com.gameanalytics.sdk.utilities.TaskRunner;
import com.gameanalytics.sdk.validators.GAValidator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class GAHTTPApi {
    public class GAHTTPApiResponseJSONObjectPair {
        public JSONObject json;
        public EGAHTTPApiResponse response;

    }

    static class SdkErrorEventCounter {
        public int count;
        public long timestamp;

        SdkErrorEventCounter(long _timestamp) {
            this.timestamp = _timestamp;
            this.count = 0;
        }
    }

    private static final GAHTTPApi INSTANCE = null;
    private static final int MAX_ERROR_MESSAGE_LENGTH = 0x100;
    private static int MAX_SDK_ERROR_EVENTS;
    private static int SDK_ERROR_TIMEOUT;
    private String baseUrl;
    private String eventsUrlPath;
    private String hostName;
    private String initializeUrlPath;
    private String protocol;
    private String remoteConfigsBaseUrl;
    private String remoteConfigsVersion;
    private HashMap sdkErrorEventTimeout;
    private boolean useGzip;
    private String version;

    static {
        GAHTTPApi.INSTANCE = new GAHTTPApi();
        GAHTTPApi.SDK_ERROR_TIMEOUT = 3600000;
        GAHTTPApi.MAX_SDK_ERROR_EVENTS = 10;
    }

    private GAHTTPApi() {
        this.protocol = "https";
        this.hostName = "api.gameanalytics.com";
        this.version = "v2";
        this.remoteConfigsVersion = "v1";
        this.baseUrl = "https://api.gameanalytics.com/v2";
        this.remoteConfigsBaseUrl = "https://api.gameanalytics.com/remote_configs/v1";
        this.initializeUrlPath = "init";
        this.eventsUrlPath = "events";
        this.useGzip = true;
        this.sdkErrorEventTimeout = new HashMap();
    }

    public byte[] createPayloadData(String payload, boolean gzip) throws Exception {
        try {
            if(gzip) {
                byte[] arr_b = GAUtilities.gzipCompress(payload);
                GALogger.d(("Gzip stats. Size: " + payload.getBytes("UTF-8").length + ", Compressed: " + arr_b.length + ", Content: " + payload));
                return arr_b;
            }
            return payload.getBytes("UTF-8");
        }
        catch(Exception exception0) {
        }
        throw exception0;
    }

    private HttpURLConnection createRequest(String url, byte[] payloadData, boolean gzip) throws IOException {
        HttpURLConnection httpURLConnection0 = (HttpURLConnection)new URL(url).openConnection();
        httpURLConnection0.setDoOutput(true);
        httpURLConnection0.setDoInput(true);
        httpURLConnection0.setRequestMethod("POST");
        httpURLConnection0.setRequestProperty("Content-Length", String.valueOf(payloadData.length));
        if(gzip) {
            httpURLConnection0.setRequestProperty("Content-Encoding", "gzip");
        }
        httpURLConnection0.setRequestProperty("Authorization", GAUtilities.hmac(GAState.getSecretKey(), payloadData));
        httpURLConnection0.setRequestProperty("Content-Type", "application/json");
        return httpURLConnection0;
    }

    public static GAHTTPApi getInstance() {
        return GAHTTPApi.INSTANCE;
    }

    private EGAHTTPApiResponse processRequestResponse(HttpURLConnection connection, String body, String requestId) {
        String s2;
        int v;
        try {
            v = connection.getResponseCode();
        }
        catch(IOException | Exception unused_ex) {
            v = 0;
        }
        if(body.length() == 0) {
            try {
                s2 = connection.getResponseMessage();
            }
            catch(IOException | Exception unused_ex) {
                s2 = "";
            }
            GALogger.d((requestId + " request. failed. Might be no connection. Description: " + s2 + ", Status code: " + v));
            return EGAHTTPApiResponse.NoResponse;
        }
        switch(v) {
            case 200: {
                return EGAHTTPApiResponse.Ok;
            }
            case 201: {
                return EGAHTTPApiResponse.Created;
            }
            case 400: {
                GALogger.d((requestId + " request. 400 - Bad Request."));
                return EGAHTTPApiResponse.BadRequest;
            }
            case 0: 
            case 401: {
                GALogger.d((requestId + " request. 401 - Unauthorized."));
                return EGAHTTPApiResponse.Unauthorized;
            }
            case 500: {
                GALogger.d((requestId + " request. 500 - Internal Server Error."));
                return EGAHTTPApiResponse.InternalServerError;
            }
            default: {
                return EGAHTTPApiResponse.UnknownResponseCode;
            }
        }
    }

    public GAHTTPApiResponseJSONObjectPair requestInitReturningDict(String configsHash) {
        HttpURLConnection httpURLConnection0;
        byte[] arr_b;
        String s4;
        GAHTTPApiResponseJSONObjectPair gAHTTPApi$GAHTTPApiResponseJSONObjectPair0 = new GAHTTPApiResponseJSONObjectPair(this);
        String s1 = GAState.getGameKey();
        String s2 = this.remoteConfigsBaseUrl + "/" + this.initializeUrlPath + "?game_key=" + s1 + "&interval_seconds=0&configs_hash=" + configsHash;
        s2 = TextUtils.isEmpty(GAState.getABTestingId()) ? this.remoteConfigsBaseUrl + "/" + this.initializeUrlPath + "?game_key=" + s1 + "&interval_seconds=0&configs_hash=" + configsHash : s2 + "&ab_id=" + GAState.getABTestingId();
        if(!TextUtils.isEmpty(GAState.getABTestingVariantId())) {
            s2 = s2 + "&ab_variant_id=" + GAState.getABTestingVariantId();
        }
        GALogger.d(("Sending \'init\' URL: " + s2));
        String s3 = GAState.getInitAnnotations().toString();
        if(s3 != null && s3.length() != 0) {
            try {
                s4 = "";
                arr_b = this.createPayloadData(s3, this.useGzip);
                httpURLConnection0 = null;
                httpURLConnection0 = this.createRequest(s2, arr_b, this.useGzip);
                goto label_16;
            }
            catch(IOException unused_ex) {
                httpURLConnection0 = null;
                goto label_26;
                try {
                    try {
                    label_16:
                        httpURLConnection0.getOutputStream().write(arr_b);
                        BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(httpURLConnection0.getInputStream()));
                        StringBuffer stringBuffer0 = new StringBuffer();
                        String s5;
                        while((s5 = bufferedReader0.readLine()) != null) {
                            stringBuffer0.append(s5);
                        }
                        bufferedReader0.close();
                        s4 = stringBuffer0.toString();
                    }
                    catch(IOException unused_ex) {
                        try {
                        label_26:
                            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(httpURLConnection0.getErrorStream()));
                            StringBuffer stringBuffer1 = new StringBuffer();
                            String s6;
                            while((s6 = bufferedReader1.readLine()) != null) {
                                stringBuffer1.append(s6);
                            }
                            bufferedReader1.close();
                            s4 = stringBuffer1.toString();
                        }
                        catch(IOException unused_ex) {
                        }
                    }
                }
                catch(Exception unused_ex) {
                }
                goto label_34;
            }
            catch(Exception unused_ex) {
            label_34:
                GALogger.d(("init request content : " + s4 + ", JSONstring: " + s3));
                JSONObject jSONObject0 = GAUtilities.dictionary(s4);
                EGAHTTPApiResponse eGAHTTPApiResponse0 = this.processRequestResponse(httpURLConnection0, s4, "Init");
                if(eGAHTTPApiResponse0 != EGAHTTPApiResponse.Ok && eGAHTTPApiResponse0 != EGAHTTPApiResponse.Created && eGAHTTPApiResponse0 != EGAHTTPApiResponse.BadRequest) {
                    GALogger.d(("Failed Init Call. URL: " + s2 + ", Authorization: " + httpURLConnection0.getRequestProperty("Authorization") + ", JSONString: " + s3 + ", responseJSON: " + jSONObject0 + ", requestResponseEnum: " + eGAHTTPApiResponse0));
                    gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.response = eGAHTTPApiResponse0;
                    gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.json = null;
                    return gAHTTPApi$GAHTTPApiResponseJSONObjectPair0;
                }
                if(jSONObject0 == null) {
                    GALogger.d("Failed Init Call. Json decoding failed");
                    gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.response = EGAHTTPApiResponse.JsonDecodeFailed;
                    String s7 = GAState.getGameKey();
                    String s8 = GAState.getSecretKey();
                    GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Http, EGASdkErrorArea.InitHttp, EGASdkErrorAction.FailHttpJsonDecode, s4, s7, s8);
                    gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.json = null;
                    return gAHTTPApi$GAHTTPApiResponseJSONObjectPair0;
                }
                if(eGAHTTPApiResponse0 == EGAHTTPApiResponse.BadRequest) {
                    GALogger.d(("Failed Init Call. Bad request. Response: " + jSONObject0.toString()));
                    gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.response = eGAHTTPApiResponse0;
                    gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.json = null;
                    return gAHTTPApi$GAHTTPApiResponseJSONObjectPair0;
                }
                JSONObject jSONObject1 = this.validateAndCleanInitRequestResponse(jSONObject0, eGAHTTPApiResponse0 == EGAHTTPApiResponse.Created);
                if(jSONObject1 == null) {
                    gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.response = EGAHTTPApiResponse.BadResponse;
                    gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.json = null;
                    return gAHTTPApi$GAHTTPApiResponseJSONObjectPair0;
                }
                gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.response = eGAHTTPApiResponse0;
                gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.json = jSONObject1;
                return gAHTTPApi$GAHTTPApiResponseJSONObjectPair0;
            }
        }
        gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.response = EGAHTTPApiResponse.JsonEncodeFailed;
        gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.json = null;
        return gAHTTPApi$GAHTTPApiResponseJSONObjectPair0;
    }

    public GAHTTPApiResponseJSONObjectPair sendEventsInArray(ArrayList eventArray) {
        HttpURLConnection httpURLConnection0;
        byte[] arr_b;
        String s3;
        if(eventArray.isEmpty()) {
            GALogger.d("sendEventsInArray called with missing eventArray");
        }
        GAHTTPApiResponseJSONObjectPair gAHTTPApi$GAHTTPApiResponseJSONObjectPair0 = new GAHTTPApiResponseJSONObjectPair(this);
        String s = GAState.getGameKey();
        String s1 = this.baseUrl + "/" + s + "/" + this.eventsUrlPath;
        GALogger.d(("Sending \'events\' URL: " + s1));
        String s2 = GAUtilities.jsonString(eventArray);
        if(s2.length() == 0) {
            GALogger.d("sendEventsInArray JSON encoding failed of eventArray");
            gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.json = null;
            gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.response = EGAHTTPApiResponse.JsonEncodeFailed;
            return gAHTTPApi$GAHTTPApiResponseJSONObjectPair0;
        }
        try {
            s3 = "";
            arr_b = this.createPayloadData(s2, this.useGzip);
            httpURLConnection0 = null;
            httpURLConnection0 = this.createRequest(s1, arr_b, this.useGzip);
            goto label_19;
        }
        catch(IOException unused_ex) {
            httpURLConnection0 = null;
            goto label_29;
            try {
                try {
                label_19:
                    httpURLConnection0.getOutputStream().write(arr_b);
                    BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(httpURLConnection0.getInputStream()));
                    StringBuffer stringBuffer0 = new StringBuffer();
                    String s4;
                    while((s4 = bufferedReader0.readLine()) != null) {
                        stringBuffer0.append(s4);
                    }
                    bufferedReader0.close();
                    s3 = stringBuffer0.toString();
                }
                catch(IOException unused_ex) {
                    try {
                    label_29:
                        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(httpURLConnection0.getErrorStream()));
                        StringBuffer stringBuffer1 = new StringBuffer();
                        String s5;
                        while((s5 = bufferedReader1.readLine()) != null) {
                            stringBuffer1.append(s5);
                        }
                        bufferedReader1.close();
                        s3 = stringBuffer1.toString();
                    }
                    catch(IOException unused_ex) {
                    }
                }
            }
            catch(Exception unused_ex) {
            }
            goto label_37;
        }
        catch(Exception unused_ex) {
        label_37:
            GALogger.d(("events request content: " + s3));
            EGAHTTPApiResponse eGAHTTPApiResponse0 = this.processRequestResponse(httpURLConnection0, s3, "Events");
            if(eGAHTTPApiResponse0 != EGAHTTPApiResponse.Ok && eGAHTTPApiResponse0 != EGAHTTPApiResponse.BadRequest) {
                GALogger.d(("Failed events Call. URL: " + s1 + ", Authorization: " + httpURLConnection0.getRequestProperty("Authorization") + ", JSONString: " + s2));
                gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.json = null;
                gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.response = eGAHTTPApiResponse0;
                return gAHTTPApi$GAHTTPApiResponseJSONObjectPair0;
            }
            JSONObject jSONObject0 = GAUtilities.dictionary(s3);
            if(jSONObject0 == null && GAUtilities.array(s3) == null) {
                gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.json = null;
                gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.response = EGAHTTPApiResponse.JsonDecodeFailed;
                String s6 = GAState.getGameKey();
                String s7 = GAState.getSecretKey();
                GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Http, EGASdkErrorArea.EventsHttp, EGASdkErrorAction.FailHttpJsonDecode, s3, s6, s7);
                return gAHTTPApi$GAHTTPApiResponseJSONObjectPair0;
            }
            if(eGAHTTPApiResponse0 == EGAHTTPApiResponse.BadRequest) {
                GALogger.d(("Failed Events Call. Bad request. Response: " + s3));
            }
            gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.json = jSONObject0;
            gAHTTPApi$GAHTTPApiResponseJSONObjectPair0.response = eGAHTTPApiResponse0;
            return gAHTTPApi$GAHTTPApiResponseJSONObjectPair0;
        }
    }

    public void sendSdkErrorEvent(EGASdkErrorCategory category, EGASdkErrorArea area, EGASdkErrorAction action, EGASdkErrorParameter parameter, String reason, String gameKey, String secretKey) {
        this.sendSdkErrorEventInternal(category, area, action, parameter, reason, gameKey, secretKey);
    }

    public void sendSdkErrorEvent(EGASdkErrorCategory category, EGASdkErrorArea area, EGASdkErrorAction action, String reason, String gameKey, String secretKey) {
        this.sendSdkErrorEventInternal(category, area, action, EGASdkErrorParameter.Undefined, reason, gameKey, secretKey);
    }

    private void sendSdkErrorEventInternal(EGASdkErrorCategory category, EGASdkErrorArea area, EGASdkErrorAction action, EGASdkErrorParameter parameter, String reason, String gameKey, String secretKey) {
        String s7;
        String s3 = "";
        if(!GAState.doSendEvents()) {
            return;
        }
        String s4 = area.toString();
        long v = System.currentTimeMillis();
        if(this.sdkErrorEventTimeout.containsKey(s4)) {
            SdkErrorEventCounter gAHTTPApi$SdkErrorEventCounter1 = (SdkErrorEventCounter)this.sdkErrorEventTimeout.get(s4);
            if(gAHTTPApi$SdkErrorEventCounter1.count >= GAHTTPApi.MAX_SDK_ERROR_EVENTS) {
                if(v - gAHTTPApi$SdkErrorEventCounter1.timestamp > ((long)GAHTTPApi.SDK_ERROR_TIMEOUT)) {
                    gAHTTPApi$SdkErrorEventCounter1.timestamp = v;
                    gAHTTPApi$SdkErrorEventCounter1.count = 0;
                    goto label_18;
                }
                GALogger.e(("Too many errors have been registered while sending events, error code: \"" + s4 + "\". Please check if your event submission is correct. Maximum error events allowed is: " + GAHTTPApi.MAX_SDK_ERROR_EVENTS + " per hour!"));
                return;
            }
        label_18:
            ++gAHTTPApi$SdkErrorEventCounter1.count;
        }
        else {
            SdkErrorEventCounter gAHTTPApi$SdkErrorEventCounter0 = new SdkErrorEventCounter(v);
            ++gAHTTPApi$SdkErrorEventCounter0.count;
            this.sdkErrorEventTimeout.put(s4, gAHTTPApi$SdkErrorEventCounter0);
        }
        if(!GAValidator.validateSdkErrorEvent(gameKey, secretKey, category, area, action)) {
            return;
        }
        String s5 = this.baseUrl + "/" + gameKey + "/" + this.eventsUrlPath;
        GALogger.d(("Sending \'events\' URL: " + s5));
        try {
            JSONObject jSONObject0 = GAState.getSdkErrorEventAnnotations();
            String s6 = category.toString();
            jSONObject0.put("error_category", s6);
            s7 = "" + s6;
            String s8 = area.toString();
            jSONObject0.put("error_area", s8);
            s7 = s7 + ":" + s8;
            jSONObject0.put("error_action", action.toString());
            StackTraceElement[] arr_stackTraceElement = Thread.currentThread().getStackTrace();
            String s9 = arr_stackTraceElement[4].getMethodName();
            jSONObject0.put("function_name", s9);
            int v2 = arr_stackTraceElement[4].getLineNumber();
            jSONObject0.put("line_number", v2);
            StringBuilder stringBuilder0 = new StringBuilder();
            for(int v1 = 4; v1 < arr_stackTraceElement.length; ++v1) {
                stringBuilder0.append(arr_stackTraceElement[v1].toString() + "\n");
            }
            if(stringBuilder0.length() > 0x1000) {
                stringBuilder0.setLength(0x1000);
            }
            jSONObject0.put("stacktrace", stringBuilder0.toString());
            GALogger.e(("sendSdkErrorEvent: " + s9 + "at line: " + v2 + " with stacktrace:\n" + stringBuilder0));
            String s10 = parameter.toString();
            if(!TextUtils.isEmpty(s10)) {
                jSONObject0.put("error_parameter", s10);
            }
            if(!TextUtils.isEmpty(reason)) {
                jSONObject0.put("reason", (reason.length() <= 0x100 ? reason : reason.substring(0, 0x100)));
            }
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(jSONObject0);
            s3 = GAUtilities.jsonString(arrayList0);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        if(TextUtils.isEmpty(s3)) {
            GALogger.w("sendSdkErrorEvent: JSON encoding failed.");
            return;
        }
        try {
            GALogger.d(("sendSdkErrorEvent json: " + s3));
            TaskRunner.executeAsync(new SdkErrorTask(s5, s7, s3.getBytes("UTF-8"), secretKey), null);
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            GALogger.w("sendSdkErrorEvent: Payload data encoding failed.");
            unsupportedEncodingException0.printStackTrace();
        }
    }

    public void setBaseUrl(String url) {
        this.baseUrl = url;
        GALogger.d(("New base URL: " + this.baseUrl));
    }

    private JSONObject validateAndCleanInitRequestResponse(JSONObject initResponse, boolean configsCreated) {
        if(initResponse == null) {
            GALogger.w("validateInitRequestResponse failed - no response dictionary.");
            return null;
        }
        JSONObject jSONObject1 = new JSONObject();
        if(initResponse.has("server_ts")) {
            try {
                double f = initResponse.optDouble("server_ts", -1.0);
                if(f > 0.0) {
                    jSONObject1.put("server_ts", f);
                }
            }
            catch(JSONException unused_ex) {
                GALogger.w("validateInitRequestResponse failed - invalid type in \'server_ts\' field.");
                return null;
            }
        }
        if(configsCreated) {
            if(initResponse.has("configs")) {
                try {
                    jSONObject1.put("configs", initResponse.getJSONArray("configs"));
                }
                catch(JSONException unused_ex) {
                    GALogger.w("validateInitRequestResponse failed - invalid type in \'configs\' field.");
                    return null;
                }
            }
            if(initResponse.has("configs_hash")) {
                try {
                    jSONObject1.put("configs_hash", initResponse.getString("configs_hash"));
                }
                catch(JSONException unused_ex) {
                    GALogger.w("validateInitRequestResponse failed - invalid type in \'configs_hash\' field.");
                    return null;
                }
            }
            if(initResponse.has("ab_id")) {
                try {
                    jSONObject1.put("ab_id", initResponse.getString("ab_id"));
                }
                catch(JSONException unused_ex) {
                    GALogger.w("validateInitRequestResponse failed - invalid type in \'ab_id\' field.");
                    return null;
                }
            }
            if(initResponse.has("ab_variant_id")) {
                try {
                    jSONObject1.put("ab_variant_id", initResponse.getString("ab_variant_id"));
                    return jSONObject1;
                }
                catch(JSONException unused_ex) {
                    GALogger.w("validateInitRequestResponse failed - invalid type in \'ab_variant_id\' field.");
                    return null;
                }
            }
        }
        return jSONObject1;
    }
}

