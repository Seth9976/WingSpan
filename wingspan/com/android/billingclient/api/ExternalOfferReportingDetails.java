package com.android.billingclient.api;

import org.json.JSONException;
import org.json.JSONObject;

public final class ExternalOfferReportingDetails {
    private final String externalTransactionToken;

    ExternalOfferReportingDetails(String s) throws JSONException {
        this.externalTransactionToken = new JSONObject(s).optString("externalTransactionToken");
    }

    public String getExternalTransactionToken() {
        return this.externalTransactionToken;
    }
}

