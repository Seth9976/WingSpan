package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public final class AlternativeChoiceDetails {
    public static class Product {
        private final String zza;
        private final String zzb;
        private final String zzc;

        Product(JSONObject jSONObject0, zzc zzc0) {
            this.zza = jSONObject0.optString("productId");
            this.zzb = jSONObject0.optString("productType");
            String s = jSONObject0.optString("offerToken");
            if(s.isEmpty()) {
                s = null;
            }
            this.zzc = s;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Product)) {
                return false;
            }
            String s = ((Product)object0).getId();
            if(this.zza.equals(s)) {
                String s1 = ((Product)object0).getType();
                if(this.zzb.equals(s1)) {
                    String s2 = ((Product)object0).getOfferToken();
                    return Objects.equals(this.zzc, s2);
                }
            }
            return false;
        }

        public String getId() {
            return this.zza;
        }

        public String getOfferToken() {
            return this.zzc;
        }

        public String getType() {
            return this.zzb;
        }

        @Override
        public int hashCode() {
            return Objects.hash(new Object[]{this.zza, this.zzb, this.zzc});
        }

        @Override
        public String toString() {
            return String.format("{id: %s, type: %s, offer token: %s}", this.zza, this.zzb, this.zzc);
        }
    }

    private final String zza;
    private final JSONObject zzb;
    private final List zzc;

    AlternativeChoiceDetails(String s) throws JSONException {
        this.zza = s;
        JSONObject jSONObject0 = new JSONObject(s);
        this.zzb = jSONObject0;
        JSONArray jSONArray0 = jSONObject0.optJSONArray("products");
        ArrayList arrayList0 = new ArrayList();
        if(jSONArray0 != null) {
            for(int v = 0; v < jSONArray0.length(); ++v) {
                JSONObject jSONObject1 = jSONArray0.optJSONObject(v);
                if(jSONObject1 != null) {
                    arrayList0.add(new Product(jSONObject1, null));
                }
            }
        }
        this.zzc = arrayList0;
    }

    public String getExternalTransactionToken() {
        return this.zzb.optString("externalTransactionToken");
    }

    public String getOriginalExternalTransactionId() {
        String s = this.zzb.optString("originalExternalTransactionId");
        return s.isEmpty() ? null : s;
    }

    public List getProducts() {
        return this.zzc;
    }
}

