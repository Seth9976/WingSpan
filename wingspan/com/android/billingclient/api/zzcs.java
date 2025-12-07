package com.android.billingclient.api;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzcs {
    private final String zza;
    private final String zzb;

    zzcs(JSONObject jSONObject0) throws JSONException {
        this.zza = jSONObject0.getString("rentalPeriod");
        String s = jSONObject0.optString("rentalExpirationPeriod");
        if(s.isEmpty()) {
            s = null;
        }
        this.zzb = s;
    }
}

