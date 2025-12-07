package com.android.billingclient.api;

public final class QueryPurchaseHistoryParams {
    public static class Builder {
        private String zza;

        private Builder() {
        }

        Builder(zzde zzde0) {
        }

        public QueryPurchaseHistoryParams build() {
            if(this.zza == null) {
                throw new IllegalArgumentException("Product type must be set");
            }
            return new QueryPurchaseHistoryParams(this, null);
        }

        public Builder setProductType(String s) {
            this.zza = s;
            return this;
        }
    }

    private final String zza;

    QueryPurchaseHistoryParams(Builder queryPurchaseHistoryParams$Builder0, zzdf zzdf0) {
        this.zza = queryPurchaseHistoryParams$Builder0.zza;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public final String zza() {
        return this.zza;
    }
}

