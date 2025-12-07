package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class UserChoiceDetails {
    public static class Product {
        private final String id;
        private final String offerToken;
        private final String type;

        Product(String s, String s1, String s2) {
            this.id = s;
            this.type = s1;
            this.offerToken = s2;
        }

        private Product(JSONObject jSONObject0) {
            this.id = jSONObject0.optString("productId");
            this.type = jSONObject0.optString("productType");
            String s = jSONObject0.optString("offerToken");
            if(s.isEmpty()) {
                s = null;
            }
            this.offerToken = s;
        }

        Product(JSONObject jSONObject0, zzdk zzdk0) {
            this(jSONObject0);
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
            if(this.id.equals(s)) {
                String s1 = ((Product)object0).getType();
                if(this.type.equals(s1)) {
                    String s2 = ((Product)object0).getOfferToken();
                    return Objects.equals(this.offerToken, s2);
                }
            }
            return false;
        }

        public String getId() {
            return this.id;
        }

        public String getOfferToken() {
            return this.offerToken;
        }

        public String getType() {
            return this.type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(new Object[]{this.id, this.type, this.offerToken});
        }

        @Override
        public String toString() {
            return String.format("{id: %s, type: %s, offer token: %s}", this.id, this.type, this.offerToken);
        }
    }

    private final String mOriginalJson;
    private final JSONObject mParsedJson;
    private final List mProducts;

    UserChoiceDetails(String s) throws JSONException {
        this.mOriginalJson = s;
        JSONObject jSONObject0 = new JSONObject(s);
        this.mParsedJson = jSONObject0;
        this.mProducts = UserChoiceDetails.toProductList(jSONObject0.optJSONArray("products"));
    }

    public String getExternalTransactionToken() {
        return this.mParsedJson.optString("externalTransactionToken");
    }

    public String getOriginalExternalTransactionId() {
        String s = this.mParsedJson.optString("originalExternalTransactionId");
        return s.isEmpty() ? null : s;
    }

    public List getProducts() {
        return this.mProducts;
    }

    private static List toProductList(JSONArray jSONArray0) {
        List list0 = new ArrayList();
        if(jSONArray0 != null) {
            for(int v = 0; v < jSONArray0.length(); ++v) {
                JSONObject jSONObject0 = jSONArray0.optJSONObject(v);
                if(jSONObject0 != null) {
                    list0.add(new Product(jSONObject0, null));
                }
            }
        }
        return list0;
    }
}

