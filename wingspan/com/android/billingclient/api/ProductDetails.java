package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzai;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ProductDetails {
    public static final class OneTimePurchaseOfferDetails {
        private final String zza;
        private final long zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;
        private final String zzf;
        private final zzai zzg;
        private final Long zzh;
        private final zzcp zzi;
        private final zzct zzj;
        private final zzcq zzk;
        private final zzcr zzl;
        private final zzcs zzm;

        OneTimePurchaseOfferDetails(JSONObject jSONObject0) throws JSONException {
            this.zza = jSONObject0.optString("formattedPrice");
            this.zzb = jSONObject0.optLong("priceAmountMicros");
            this.zzc = jSONObject0.optString("priceCurrencyCode");
            String s = jSONObject0.optString("offerIdToken");
            zzcs zzcs0 = null;
            if(s.isEmpty()) {
                s = null;
            }
            this.zzd = s;
            String s1 = jSONObject0.optString("offerId");
            if(s1.isEmpty()) {
                s1 = null;
            }
            this.zze = s1;
            String s2 = jSONObject0.optString("purchaseOptionId");
            if(s2.isEmpty()) {
                s2 = null;
            }
            this.zzf = s2;
            jSONObject0.optInt("offerType");
            JSONArray jSONArray0 = jSONObject0.optJSONArray("offerTags");
            ArrayList arrayList0 = new ArrayList();
            if(jSONArray0 != null) {
                for(int v = 0; v < jSONArray0.length(); ++v) {
                    arrayList0.add(jSONArray0.getString(v));
                }
            }
            this.zzg = zzai.zzj(arrayList0);
            this.zzh = jSONObject0.has("fullPriceMicros") ? jSONObject0.optLong("fullPriceMicros") : null;
            JSONObject jSONObject1 = jSONObject0.optJSONObject("discountDisplayInfo");
            this.zzi = jSONObject1 == null ? null : new zzcp(jSONObject1);
            JSONObject jSONObject2 = jSONObject0.optJSONObject("validTimeWindow");
            this.zzj = jSONObject2 == null ? null : new zzct(jSONObject2);
            JSONObject jSONObject3 = jSONObject0.optJSONObject("limitedQuantityInfo");
            this.zzk = jSONObject3 == null ? null : new zzcq(jSONObject3);
            JSONObject jSONObject4 = jSONObject0.optJSONObject("preorderDetails");
            this.zzl = jSONObject4 == null ? null : new zzcr(jSONObject4);
            JSONObject jSONObject5 = jSONObject0.optJSONObject("rentalDetails");
            if(jSONObject5 != null) {
                zzcs0 = new zzcs(jSONObject5);
            }
            this.zzm = zzcs0;
        }

        public String getFormattedPrice() {
            return this.zza;
        }

        public long getPriceAmountMicros() {
            return this.zzb;
        }

        public String getPriceCurrencyCode() {
            return this.zzc;
        }

        public final String zza() {
            return this.zzd;
        }
    }

    public static final class PricingPhase {
        private final String zza;
        private final long zzb;
        private final String zzc;
        private final String zzd;
        private final int zze;
        private final int zzf;

        PricingPhase(JSONObject jSONObject0) {
            this.zzd = jSONObject0.optString("billingPeriod");
            this.zzc = jSONObject0.optString("priceCurrencyCode");
            this.zza = jSONObject0.optString("formattedPrice");
            this.zzb = jSONObject0.optLong("priceAmountMicros");
            this.zzf = jSONObject0.optInt("recurrenceMode");
            this.zze = jSONObject0.optInt("billingCycleCount");
        }

        public int getBillingCycleCount() {
            return this.zze;
        }

        public String getBillingPeriod() {
            return this.zzd;
        }

        public String getFormattedPrice() {
            return this.zza;
        }

        public long getPriceAmountMicros() {
            return this.zzb;
        }

        public String getPriceCurrencyCode() {
            return this.zzc;
        }

        public int getRecurrenceMode() {
            return this.zzf;
        }
    }

    public static class PricingPhases {
        private final List zza;

        PricingPhases(JSONArray jSONArray0) {
            ArrayList arrayList0 = new ArrayList();
            if(jSONArray0 != null) {
                for(int v = 0; v < jSONArray0.length(); ++v) {
                    JSONObject jSONObject0 = jSONArray0.optJSONObject(v);
                    if(jSONObject0 != null) {
                        arrayList0.add(new PricingPhase(jSONObject0));
                    }
                }
            }
            this.zza = arrayList0;
        }

        public List getPricingPhaseList() {
            return this.zza;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RecurrenceMode {
        public static final int FINITE_RECURRING = 2;
        public static final int INFINITE_RECURRING = 1;
        public static final int NON_RECURRING = 3;

    }

    public static final class SubscriptionOfferDetails {
        private final String zza;
        private final String zzb;
        private final String zzc;
        private final PricingPhases zzd;
        private final List zze;
        private final zzco zzf;
        private final zzcu zzg;

        SubscriptionOfferDetails(JSONObject jSONObject0) throws JSONException {
            this.zza = jSONObject0.optString("basePlanId");
            String s = jSONObject0.optString("offerId");
            zzcu zzcu0 = null;
            if(s.isEmpty()) {
                s = null;
            }
            this.zzb = s;
            this.zzc = jSONObject0.getString("offerIdToken");
            this.zzd = new PricingPhases(jSONObject0.getJSONArray("pricingPhases"));
            JSONObject jSONObject1 = jSONObject0.optJSONObject("installmentPlanDetails");
            this.zzf = jSONObject1 == null ? null : new zzco(jSONObject1);
            JSONObject jSONObject2 = jSONObject0.optJSONObject("transitionPlanDetails");
            if(jSONObject2 != null) {
                zzcu0 = new zzcu(jSONObject2);
            }
            this.zzg = zzcu0;
            ArrayList arrayList0 = new ArrayList();
            JSONArray jSONArray0 = jSONObject0.optJSONArray("offerTags");
            if(jSONArray0 != null) {
                for(int v = 0; v < jSONArray0.length(); ++v) {
                    arrayList0.add(jSONArray0.getString(v));
                }
            }
            this.zze = arrayList0;
        }

        public String getBasePlanId() {
            return this.zza;
        }

        public String getOfferId() {
            return this.zzb;
        }

        public List getOfferTags() {
            return this.zze;
        }

        public String getOfferToken() {
            return this.zzc;
        }

        public PricingPhases getPricingPhases() {
            return this.zzd;
        }
    }

    private final String zza;
    private final JSONObject zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final String zzi;
    private final String zzj;
    private final String zzk;
    private final List zzl;
    private final List zzm;

    ProductDetails(String s) throws JSONException {
        this.zza = s;
        JSONObject jSONObject0 = new JSONObject(s);
        this.zzb = jSONObject0;
        String s1 = jSONObject0.optString("productId");
        this.zzc = s1;
        String s2 = jSONObject0.optString("type");
        this.zzd = s2;
        if(TextUtils.isEmpty(s1)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if(TextUtils.isEmpty(s2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.zze = jSONObject0.optString("title");
        this.zzf = jSONObject0.optString("name");
        this.zzg = jSONObject0.optString("description");
        this.zzi = jSONObject0.optString("packageDisplayName");
        this.zzj = jSONObject0.optString("iconUrl");
        this.zzh = jSONObject0.optString("skuDetailsToken");
        this.zzk = jSONObject0.optString("serializedDocid");
        JSONArray jSONArray0 = jSONObject0.optJSONArray("subscriptionOfferDetails");
        if(jSONArray0 == null) {
            this.zzl = s2.equals("subs") || s2.equals("play_pass_subs") ? new ArrayList() : null;
        }
        else {
            ArrayList arrayList0 = new ArrayList();
            for(int v1 = 0; v1 < jSONArray0.length(); ++v1) {
                arrayList0.add(new SubscriptionOfferDetails(jSONArray0.getJSONObject(v1)));
            }
            this.zzl = arrayList0;
        }
        JSONObject jSONObject1 = this.zzb.optJSONObject("oneTimePurchaseOfferDetails");
        JSONArray jSONArray1 = this.zzb.optJSONArray("oneTimePurchaseOfferDetailsList");
        ArrayList arrayList1 = new ArrayList();
        if(jSONArray1 != null) {
            for(int v = 0; v < jSONArray1.length(); ++v) {
                arrayList1.add(new OneTimePurchaseOfferDetails(jSONArray1.getJSONObject(v)));
            }
            this.zzm = arrayList1;
            return;
        }
        if(jSONObject1 != null) {
            arrayList1.add(new OneTimePurchaseOfferDetails(jSONObject1));
            this.zzm = arrayList1;
            return;
        }
        this.zzm = null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ProductDetails ? TextUtils.equals(this.zza, ((ProductDetails)object0).zza) : false;
    }

    public String getDescription() {
        return this.zzg;
    }

    public String getName() {
        return this.zzf;
    }

    public OneTimePurchaseOfferDetails getOneTimePurchaseOfferDetails() {
        return this.zzm == null || this.zzm.isEmpty() ? null : ((OneTimePurchaseOfferDetails)this.zzm.get(0));
    }

    public String getProductId() {
        return this.zzc;
    }

    public String getProductType() {
        return this.zzd;
    }

    public List getSubscriptionOfferDetails() {
        return this.zzl;
    }

    public String getTitle() {
        return this.zze;
    }

    @Override
    public int hashCode() {
        return this.zza.hashCode();
    }

    @Override
    public String toString() {
        return "ProductDetails{jsonString=\'" + this.zza + "\', parsedJson=" + this.zzb.toString() + ", productId=\'" + this.zzc + "\', productType=\'" + this.zzd + "\', title=\'" + this.zze + "\', productDetailsToken=\'" + this.zzh + "\', subscriptionOfferDetails=" + this.zzl + "}";
    }

    public final String zza() {
        return this.zzb.optString("packageName");
    }

    final String zzb() {
        return this.zzh;
    }

    public String zzc() {
        return this.zzk;
    }
}

