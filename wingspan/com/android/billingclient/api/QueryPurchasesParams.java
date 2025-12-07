package com.android.billingclient.api;

public final class QueryPurchasesParams {
    public static class Builder {
        private String zza;

        private Builder() {
        }

        Builder(zzdg zzdg0) {
        }

        public QueryPurchasesParams build() {
            if(this.zza == null) {
                throw new IllegalArgumentException("Product type must be set");
            }
            return new QueryPurchasesParams(this, null);
        }

        public Builder setProductType(String s) {
            this.zza = s;
            return this;
        }
    }

    private final String zza;

    QueryPurchasesParams(Builder queryPurchasesParams$Builder0, zzdh zzdh0) {
        this.zza = queryPurchasesParams$Builder0.zza;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public final String zza() {
        return this.zza;
    }
}

