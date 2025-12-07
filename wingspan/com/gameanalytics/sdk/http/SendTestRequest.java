package com.gameanalytics.sdk.http;

import com.gameanalytics.sdk.logging.GALogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public class SendTestRequest implements Callable {
    private String body;
    private String contentType;

    public SendTestRequest() {
        this.contentType = "application/json";
    }

    @Override
    public Object call() throws Exception {
        return this.call();
    }

    public String call() {
        try {
            HttpURLConnection httpURLConnection0 = (HttpURLConnection)new URL("https://ennu5mo7xan0n.x.pipedream.net").openConnection();
            httpURLConnection0.setDoOutput(true);
            httpURLConnection0.setDoInput(true);
            httpURLConnection0.setRequestMethod("POST");
            httpURLConnection0.setRequestProperty("Content-Type", this.contentType);
            byte[] arr_b = this.body.getBytes("UTF-8");
            httpURLConnection0.setRequestProperty("Content-Length", String.valueOf(arr_b.length));
            httpURLConnection0.getOutputStream().write(arr_b);
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(httpURLConnection0.getInputStream()));
            StringBuffer stringBuffer0 = new StringBuffer();
            String s;
            while((s = bufferedReader0.readLine()) != null) {
                stringBuffer0.append(s);
            }
            bufferedReader0.close();
        }
        catch(IOException unused_ex) {
        }
        GALogger.d("Request has been sent");
        return null;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}

