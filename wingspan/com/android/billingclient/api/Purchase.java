package com.android.billingclient.api;

import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Purchase {
    @Retention(RetentionPolicy.SOURCE)
    public @interface PurchaseState {
        public static final int PENDING = 2;
        public static final int PURCHASED = 1;
        public static final int UNSPECIFIED_STATE;

    }

    private final String zza;
    private final String zzb;
    private final JSONObject zzc;

    public Purchase(String s, String s1) throws JSONException {
        this.zza = s;
        this.zzb = s1;
        this.zzc = new JSONObject(s);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Purchase)) {
            return false;
        }
        String s = ((Purchase)object0).getOriginalJson();
        if(TextUtils.equals(this.zza, s)) {
            String s1 = ((Purchase)object0).getSignature();
            return TextUtils.equals(this.zzb, s1);
        }
        return false;
    }

    public AccountIdentifiers getAccountIdentifiers() {
        String s = this.zzc.optString("obfuscatedAccountId");
        String s1 = this.zzc.optString("obfuscatedProfileId");
        return s != null || s1 != null ? new AccountIdentifiers(s, s1) : null;
    }

    public String getDeveloperPayload() {
        return this.zzc.optString("developerPayload");
    }

    public String getOrderId() {
        String s = this.zzc.optString("orderId");
        return TextUtils.isEmpty(s) ? null : s;
    }

    public String getOriginalJson() {
        return this.zza;
    }

    public String getPackageName() {
        return this.zzc.optString("packageName");
    }

    public List getProducts() {
        return this.zza();
    }

    public int getPurchaseState() {
        return this.zzc.optInt("purchaseState", 1) == 4 ? 2 : 1;
    }

    public long getPurchaseTime() {
        return this.zzc.optLong("purchaseTime");
    }

    public String getPurchaseToken() {
        String s = this.zzc.optString("purchaseToken");
        return this.zzc.optString("token", s);
    }

    public int getQuantity() {
        return this.zzc.optInt("quantity", 1);
    }

    public String getSignature() {
        return this.zzb;
    }

    @Deprecated
    public ArrayList getSkus() {
        return this.zza();
    }

    @Override
    public int hashCode() {
        return this.zza.hashCode();
    }

    public boolean isAcknowledged() {
        return this.zzc.optBoolean("acknowledged", true);
    }

    public boolean isAutoRenewing() {
        return this.zzc.optBoolean("autoRenewing");
    }

    @Override
    public String toString() {
        return "Purchase. Json: " + this.zza;
    }

    private final ArrayList zza() {
        ArrayList arrayList0 = new ArrayList();
        if(this.zzc.has("productIds")) {
            JSONArray jSONArray0 = this.zzc.optJSONArray("productIds");
            if(jSONArray0 != null) {
                for(int v = 0; v < jSONArray0.length(); ++v) {
                    arrayList0.add(jSONArray0.optString(v));
                }
                return arrayList0;
            }
        }
        else if(this.zzc.has("productId")) {
            arrayList0.add(this.zzc.optString("productId"));
        }
        return arrayList0;
    }
}

