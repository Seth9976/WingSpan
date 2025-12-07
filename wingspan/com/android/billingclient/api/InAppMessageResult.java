package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class InAppMessageResult {
    @Retention(RetentionPolicy.SOURCE)
    public @interface InAppMessageResponseCode {
        public static final int NO_ACTION_NEEDED = 0;
        public static final int SUBSCRIPTION_STATUS_UPDATED = 1;

    }

    private final int zza;
    private final String zzb;

    public InAppMessageResult(int v, String s) {
        this.zza = v;
        this.zzb = s;
    }

    public String getPurchaseToken() {
        return this.zzb;
    }

    public int getResponseCode() {
        return this.zza;
    }
}

