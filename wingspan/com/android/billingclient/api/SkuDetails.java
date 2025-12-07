package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class SkuDetails {
    private final String zza;
    private final JSONObject zzb;

    public SkuDetails(String s) throws JSONException {
        this.zza = s;
        JSONObject jSONObject0 = new JSONObject(s);
        this.zzb = jSONObject0;
        if(TextUtils.isEmpty(jSONObject0.optString("productId"))) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        }
        if(TextUtils.isEmpty(jSONObject0.optString("type"))) {
            throw new IllegalArgumentException("SkuType cannot be empty.");
        }
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof SkuDetails ? TextUtils.equals(this.zza, ((SkuDetails)object0).zza) : false;
    }

    public String getDescription() {
        return this.zzb.optString("description");
    }

    public String getFreeTrialPeriod() {
        return this.zzb.optString("freeTrialPeriod");
    }

    public String getIconUrl() {
        return this.zzb.optString("iconUrl");
    }

    public String getIntroductoryPrice() {
        return this.zzb.optString("introductoryPrice");
    }

    public long getIntroductoryPriceAmountMicros() {
        return this.zzb.optLong("introductoryPriceAmountMicros");
    }

    public int getIntroductoryPriceCycles() {
        return this.zzb.optInt("introductoryPriceCycles");
    }

    public String getIntroductoryPricePeriod() {
        return this.zzb.optString("introductoryPricePeriod");
    }

    public String getOriginalJson() {
        return this.zza;
    }

    // 去混淆评级： 低(20)
    public String getOriginalPrice() {
        return this.zzb.has("original_price") ? this.zzb.optString("original_price") : this.getPrice();
    }

    // 去混淆评级： 低(20)
    public long getOriginalPriceAmountMicros() {
        return this.zzb.has("original_price_micros") ? this.zzb.optLong("original_price_micros") : this.getPriceAmountMicros();
    }

    public String getPrice() {
        return this.zzb.optString("price");
    }

    public long getPriceAmountMicros() {
        return this.zzb.optLong("price_amount_micros");
    }

    public String getPriceCurrencyCode() {
        return this.zzb.optString("price_currency_code");
    }

    public String getSku() {
        return this.zzb.optString("productId");
    }

    public String getSubscriptionPeriod() {
        return this.zzb.optString("subscriptionPeriod");
    }

    public String getTitle() {
        return this.zzb.optString("title");
    }

    public String getType() {
        return this.zzb.optString("type");
    }

    @Override
    public int hashCode() {
        return this.zza.hashCode();
    }

    @Override
    public String toString() {
        return "SkuDetails: " + this.zza;
    }

    public int zza() {
        return this.zzb.optInt("offer_type");
    }

    public String zzb() {
        return this.zzb.optString("offer_id");
    }

    public String zzc() {
        String s = this.zzb.optString("offerIdToken");
        return s.isEmpty() ? this.zzb.optString("offer_id_token") : s;
    }

    public final String zzd() {
        return this.zzb.optString("packageName");
    }

    public String zze() {
        return this.zzb.optString("serializedDocid");
    }

    final String zzf() {
        return this.zzb.optString("skuDetailsToken");
    }
}

