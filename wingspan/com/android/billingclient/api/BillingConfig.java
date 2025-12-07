package com.android.billingclient.api;

import org.json.JSONException;
import org.json.JSONObject;

public final class BillingConfig {
    private final String countryCode;
    private final String jsonString;
    private final JSONObject parsedJson;

    BillingConfig(String s) throws JSONException {
        this.jsonString = s;
        JSONObject jSONObject0 = new JSONObject(s);
        this.parsedJson = jSONObject0;
        this.countryCode = jSONObject0.optString("countryCode");
    }

    public String getCountryCode() {
        return this.countryCode;
    }
}

