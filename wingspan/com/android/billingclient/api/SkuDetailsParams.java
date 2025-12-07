package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class SkuDetailsParams {
    public static class Builder {
        private String zza;
        private List zzb;

        private Builder() {
        }

        Builder(zzdj zzdj0) {
        }

        public SkuDetailsParams build() {
            String s = this.zza;
            if(s == null) {
                throw new IllegalArgumentException("SKU type must be set");
            }
            if(this.zzb == null) {
                throw new IllegalArgumentException("SKU list must be set");
            }
            SkuDetailsParams skuDetailsParams0 = new SkuDetailsParams();
            skuDetailsParams0.zza = s;
            skuDetailsParams0.zzb = this.zzb;
            return skuDetailsParams0;
        }

        public Builder setSkusList(List list0) {
            this.zzb = new ArrayList(list0);
            return this;
        }

        public Builder setType(String s) {
            this.zza = s;
            return this;
        }
    }

    private String zza;
    private List zzb;

    public String getSkuType() {
        return this.zza;
    }

    public List getSkusList() {
        return this.zzb;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }
}

