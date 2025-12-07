package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;

public final class BillingResult {
    public static class Builder {
        private int zza;
        private String zzb;

        private Builder() {
            this.zzb = "";
        }

        Builder(zzbz zzbz0) {
            this.zzb = "";
        }

        public BillingResult build() {
            BillingResult billingResult0 = new BillingResult();
            billingResult0.zza = this.zza;
            billingResult0.zzb = this.zzb;
            return billingResult0;
        }

        public Builder setDebugMessage(String s) {
            this.zzb = s;
            return this;
        }

        public Builder setResponseCode(int v) {
            this.zza = v;
            return this;
        }
    }

    private int zza;
    private String zzb;

    public String getDebugMessage() {
        return this.zzb;
    }

    public int getResponseCode() {
        return this.zza;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    @Override
    public String toString() {
        return "Response Code: " + zzb.zzh(this.zza) + ", Debug Message: " + this.zzb;
    }
}

