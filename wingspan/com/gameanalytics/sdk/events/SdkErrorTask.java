package com.gameanalytics.sdk.events;

import android.text.TextUtils;
import com.gameanalytics.sdk.logging.GALogger;
import com.gameanalytics.sdk.state.GAState;
import com.gameanalytics.sdk.utilities.GAUtilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SdkErrorTask implements Callable {
    private static final int MAX_COUNT = 10;
    protected String body;
    private static HashMap countMap;
    protected String hashHmac;
    protected byte[] payloadData;
    private static HashMap timestampMap;
    protected String type;
    protected String url;

    static {
        SdkErrorTask.countMap = new HashMap();
        SdkErrorTask.timestampMap = new HashMap();
    }

    public SdkErrorTask(String url, String type, byte[] payloadData, String secretKey) {
        this.body = "";
        this.url = url;
        this.type = type;
        this.payloadData = payloadData;
        this.hashHmac = GAUtilities.hmac(secretKey, payloadData);
    }

    @Override
    public Object call() throws Exception {
        return this.call();
    }

    public HttpURLConnection call() {
        HttpURLConnection httpURLConnection1;
        HttpURLConnection httpURLConnection0 = null;
        if(!GAState.isEventSubmissionEnabled()) {
            return null;
        }
        Date date0 = new Date();
        if(!SdkErrorTask.timestampMap.containsKey(this.type)) {
            SdkErrorTask.timestampMap.put(this.type, date0);
        }
        if(!SdkErrorTask.countMap.containsKey(this.type)) {
            SdkErrorTask.countMap.put(this.type, 0);
        }
        long v = date0.getTime();
        long v1 = ((Date)SdkErrorTask.timestampMap.get(this.type)).getTime();
        if(TimeUnit.MILLISECONDS.toMinutes(v - v1) >= 60L) {
            SdkErrorTask.countMap.put(this.type, 0);
            SdkErrorTask.timestampMap.put(this.type, date0);
        }
        if(((int)(((Integer)SdkErrorTask.countMap.get(this.type)))) >= 10) {
            return null;
        }
        try {
            httpURLConnection1 = (HttpURLConnection)new URL(this.url).openConnection();
        }
        catch(IOException unused_ex) {
            goto label_35;
        }
        catch(Exception unused_ex) {
            goto label_45;
        }
        try {
            httpURLConnection1.setDoOutput(true);
            httpURLConnection1.setDoInput(true);
            httpURLConnection1.setRequestMethod("POST");
            httpURLConnection1.setRequestProperty("Content-Length", String.valueOf(this.payloadData.length));
            httpURLConnection1.setRequestProperty("Authorization", this.hashHmac);
            httpURLConnection1.setRequestProperty("Content-Type", "application/json");
            GALogger.d(("sdk error request url : " + this.url));
            GALogger.d(("sdk error request Authorization : " + this.hashHmac));
            httpURLConnection1.getOutputStream().write(this.payloadData);
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(httpURLConnection1.getInputStream()));
            StringBuffer stringBuffer0 = new StringBuffer();
            String s;
            while((s = bufferedReader0.readLine()) != null) {
                stringBuffer0.append(s);
            }
            bufferedReader0.close();
            this.body = stringBuffer0.toString();
            goto label_46;
        }
        catch(IOException unused_ex) {
        }
        catch(Exception unused_ex) {
            goto label_44;
        }
        httpURLConnection0 = httpURLConnection1;
        try {
        label_35:
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(httpURLConnection0.getErrorStream()));
            StringBuffer stringBuffer1 = new StringBuffer();
            String s1;
            while((s1 = bufferedReader1.readLine()) != null) {
                stringBuffer1.append(s1);
            }
            bufferedReader1.close();
            this.body = stringBuffer1.toString();
            goto label_45;
        label_44:
            httpURLConnection0 = httpURLConnection1;
        }
        catch(IOException | Exception unused_ex) {
        }
    label_45:
        httpURLConnection1 = httpURLConnection0;
    label_46:
        GALogger.d(("sdk error request content : " + this.body));
        return httpURLConnection1;
    }

    protected void onPostExecute(HttpURLConnection result) {
        String s;
        int v;
        if(result != null) {
            try {
                v = 0;
                v = result.getResponseCode();
                s = "";
                s = result.getResponseMessage();
            }
            catch(IOException unused_ex) {
            }
            if(TextUtils.isEmpty(this.body)) {
                GALogger.d(("sdk error failed. Might be no connection. Description: " + s + ", Status code: " + v));
                return;
            }
            if(v != 200) {
                GALogger.d(("sdk error failed. response code not 200. status code: " + v + ", description: " + s + ", body: " + this.body));
                return;
            }
            SdkErrorTask.countMap.put(this.type, ((int)(((int)(((Integer)SdkErrorTask.countMap.get(this.type)))) + 1)));
        }
    }
}

