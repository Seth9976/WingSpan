package com.android.billingclient.api;

public final class AcknowledgePurchaseParams {
    public static final class Builder {
        private String zza;

        private Builder() {
        }

        Builder(zza zza0) {
        }

        public AcknowledgePurchaseParams build() {
            String s = this.zza;
            if(s == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            AcknowledgePurchaseParams acknowledgePurchaseParams0 = new AcknowledgePurchaseParams(null);
            acknowledgePurchaseParams0.zza = s;
            return acknowledgePurchaseParams0;
        }

        public Builder setPurchaseToken(String s) {
            this.zza = s;
            return this;
        }
    }

    private String zza;

    private AcknowledgePurchaseParams() {
    }

    AcknowledgePurchaseParams(zzb zzb0) {
    }

    public String getPurchaseToken() {
        return this.zza;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }
}

