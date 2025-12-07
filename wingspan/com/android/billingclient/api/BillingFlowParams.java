package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzaa;
import com.google.android.gms.internal.play_billing.zzai;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class BillingFlowParams {
    public static class Builder {
        private String zza;
        private String zzb;
        private List zzc;
        private ArrayList zzd;
        private boolean zze;
        private com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder zzf;

        private Builder() {
            com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder billingFlowParams$SubscriptionUpdateParams$Builder0 = SubscriptionUpdateParams.newBuilder();
            com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder.zza(billingFlowParams$SubscriptionUpdateParams$Builder0);
            this.zzf = billingFlowParams$SubscriptionUpdateParams$Builder0;
        }

        Builder(zzbr zzbr0) {
            com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder billingFlowParams$SubscriptionUpdateParams$Builder0 = SubscriptionUpdateParams.newBuilder();
            com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder.zza(billingFlowParams$SubscriptionUpdateParams$Builder0);
            this.zzf = billingFlowParams$SubscriptionUpdateParams$Builder0;
        }

        public BillingFlowParams build() {
            boolean z = true;
            boolean z1 = this.zzd != null && !this.zzd.isEmpty();
            boolean z2 = this.zzc != null && !this.zzc.isEmpty();
            if(!z1 && !z2) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if(z1 && z2) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            if(z1) {
                if(this.zzd.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if(this.zzd.size() > 1) {
                    SkuDetails skuDetails0 = (SkuDetails)this.zzd.get(0);
                    String s = skuDetails0.getType();
                    ArrayList arrayList0 = this.zzd;
                    int v = arrayList0.size();
                    for(int v1 = 0; v1 < v; ++v1) {
                        SkuDetails skuDetails1 = (SkuDetails)arrayList0.get(v1);
                        if(!s.equals("play_pass_subs") && !skuDetails1.getType().equals("play_pass_subs") && !s.equals(skuDetails1.getType())) {
                            throw new IllegalArgumentException("SKUs should have the same type.");
                        }
                    }
                    String s1 = skuDetails0.zzd();
                    ArrayList arrayList1 = this.zzd;
                    int v2 = arrayList1.size();
                    for(int v3 = 0; v3 < v2; ++v3) {
                        SkuDetails skuDetails2 = (SkuDetails)arrayList1.get(v3);
                        if(!s.equals("play_pass_subs") && !skuDetails2.getType().equals("play_pass_subs") && !s1.equals(skuDetails2.zzd())) {
                            throw new IllegalArgumentException("All SKUs must have the same package name.");
                        }
                    }
                }
            }
            else {
                ProductDetailsParams billingFlowParams$ProductDetailsParams0 = (ProductDetailsParams)this.zzc.get(0);
                for(int v4 = 0; v4 < this.zzc.size(); ++v4) {
                    ProductDetailsParams billingFlowParams$ProductDetailsParams1 = (ProductDetailsParams)this.zzc.get(v4);
                    if(billingFlowParams$ProductDetailsParams1 == null) {
                        throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                    }
                    if(v4 != 0 && !billingFlowParams$ProductDetailsParams1.zza().getProductType().equals(billingFlowParams$ProductDetailsParams0.zza().getProductType()) && !billingFlowParams$ProductDetailsParams1.zza().getProductType().equals("play_pass_subs")) {
                        throw new IllegalArgumentException("All products should have same ProductType.");
                    }
                }
                String s2 = billingFlowParams$ProductDetailsParams0.zza().zza();
                for(Object object0: this.zzc) {
                    if(!billingFlowParams$ProductDetailsParams0.zza().getProductType().equals("play_pass_subs") && !((ProductDetailsParams)object0).zza().getProductType().equals("play_pass_subs") && !s2.equals(((ProductDetailsParams)object0).zza().zza())) {
                        throw new IllegalArgumentException("All products must have the same package name.");
                    }
                    if(false) {
                        break;
                    }
                }
            }
            BillingFlowParams billingFlowParams0 = new BillingFlowParams(null);
            if((!z1 || ((SkuDetails)this.zzd.get(0)).zzd().isEmpty()) && (!z2 || ((ProductDetailsParams)this.zzc.get(0)).zza().zza().isEmpty())) {
                z = false;
            }
            billingFlowParams0.zza = z;
            billingFlowParams0.zzb = this.zza;
            billingFlowParams0.zzc = this.zzb;
            billingFlowParams0.zzd = this.zzf.build();
            ArrayList arrayList2 = this.zzd;
            billingFlowParams0.zzf = arrayList2 == null ? new ArrayList() : new ArrayList(arrayList2);
            billingFlowParams0.zzg = this.zze;
            billingFlowParams0.zze = this.zzc == null ? zzai.zzk() : zzai.zzj(this.zzc);
            return billingFlowParams0;
        }

        public Builder setIsOfferPersonalized(boolean z) {
            this.zze = z;
            return this;
        }

        public Builder setObfuscatedAccountId(String s) {
            this.zza = s;
            return this;
        }

        public Builder setObfuscatedProfileId(String s) {
            this.zzb = s;
            return this;
        }

        public Builder setProductDetailsParamsList(List list0) {
            this.zzc = new ArrayList(list0);
            return this;
        }

        @Deprecated
        public Builder setSkuDetails(SkuDetails skuDetails0) {
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(skuDetails0);
            this.zzd = arrayList0;
            return this;
        }

        public Builder setSubscriptionUpdateParams(SubscriptionUpdateParams billingFlowParams$SubscriptionUpdateParams0) {
            this.zzf = SubscriptionUpdateParams.zzc(billingFlowParams$SubscriptionUpdateParams0);
            return this;
        }
    }

    public static final class ProductDetailsParams {
        public static class com.android.billingclient.api.BillingFlowParams.ProductDetailsParams.Builder {
            private ProductDetails zza;
            private String zzb;

            private com.android.billingclient.api.BillingFlowParams.ProductDetailsParams.Builder() {
            }

            com.android.billingclient.api.BillingFlowParams.ProductDetailsParams.Builder(zzbs zzbs0) {
            }

            public ProductDetailsParams build() {
                zzaa.zzc(this.zza, "ProductDetails is required for constructing ProductDetailsParams.");
                if(this.zza.getSubscriptionOfferDetails() != null) {
                    zzaa.zzc(this.zzb, "offerToken is required for constructing ProductDetailsParams for subscriptions.");
                }
                return new ProductDetailsParams(this, null);
            }

            public com.android.billingclient.api.BillingFlowParams.ProductDetailsParams.Builder setOfferToken(String s) {
                this.zzb = s;
                return this;
            }

            public com.android.billingclient.api.BillingFlowParams.ProductDetailsParams.Builder setProductDetails(ProductDetails productDetails0) {
                this.zza = productDetails0;
                if(productDetails0.getOneTimePurchaseOfferDetails() != null) {
                    productDetails0.getOneTimePurchaseOfferDetails().getClass();
                    OneTimePurchaseOfferDetails productDetails$OneTimePurchaseOfferDetails0 = productDetails0.getOneTimePurchaseOfferDetails();
                    if(productDetails$OneTimePurchaseOfferDetails0.zza() != null) {
                        this.zzb = productDetails$OneTimePurchaseOfferDetails0.zza();
                    }
                }
                return this;
            }
        }

        private final ProductDetails zza;
        private final String zzb;

        ProductDetailsParams(com.android.billingclient.api.BillingFlowParams.ProductDetailsParams.Builder billingFlowParams$ProductDetailsParams$Builder0, zzbt zzbt0) {
            this.zza = billingFlowParams$ProductDetailsParams$Builder0.zza;
            this.zzb = billingFlowParams$ProductDetailsParams$Builder0.zzb;
        }

        public static com.android.billingclient.api.BillingFlowParams.ProductDetailsParams.Builder newBuilder() {
            return new com.android.billingclient.api.BillingFlowParams.ProductDetailsParams.Builder(null);
        }

        public final ProductDetails zza() {
            return this.zza;
        }

        public final String zzb() {
            return this.zzb;
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProrationMode {
        public static final int DEFERRED = 4;
        public static final int IMMEDIATE_AND_CHARGE_FULL_PRICE = 5;
        public static final int IMMEDIATE_AND_CHARGE_PRORATED_PRICE = 2;
        public static final int IMMEDIATE_WITHOUT_PRORATION = 3;
        public static final int IMMEDIATE_WITH_TIME_PRORATION = 1;
        public static final int UNKNOWN_SUBSCRIPTION_UPGRADE_DOWNGRADE_POLICY;

    }

    public static class SubscriptionUpdateParams {
        public static class com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder {
            private String zza;
            private String zzb;
            private boolean zzc;
            private int zzd;
            private int zze;

            private com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder() {
                this.zzd = 0;
                this.zze = 0;
            }

            com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder(zzbu zzbu0) {
                this.zzd = 0;
                this.zze = 0;
            }

            public SubscriptionUpdateParams build() {
                boolean z = !TextUtils.isEmpty(this.zza) || !TextUtils.isEmpty(null);
                boolean z1 = TextUtils.isEmpty(this.zzb);
                if(z && (true ^ z1) != 0) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if(!this.zzc && !z && (true ^ z1) == 0) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                SubscriptionUpdateParams billingFlowParams$SubscriptionUpdateParams0 = new SubscriptionUpdateParams(null);
                billingFlowParams$SubscriptionUpdateParams0.zza = this.zza;
                billingFlowParams$SubscriptionUpdateParams0.zzc = this.zzd;
                billingFlowParams$SubscriptionUpdateParams0.zzd = this.zze;
                billingFlowParams$SubscriptionUpdateParams0.zzb = this.zzb;
                return billingFlowParams$SubscriptionUpdateParams0;
            }

            public com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder setOldPurchaseToken(String s) {
                this.zza = s;
                return this;
            }

            @Deprecated
            public com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder setOldSkuPurchaseToken(String s) {
                this.zza = s;
                return this;
            }

            public com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder setOriginalExternalTransactionId(String s) {
                this.zzb = s;
                return this;
            }

            @Deprecated
            public com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder setReplaceProrationMode(int v) {
                this.zzd = v;
                return this;
            }

            @Deprecated
            public com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder setReplaceSkusProrationMode(int v) {
                this.zzd = v;
                return this;
            }

            public com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder setSubscriptionReplacementMode(int v) {
                this.zze = v;
                return this;
            }

            static com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder zza(com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder billingFlowParams$SubscriptionUpdateParams$Builder0) {
                billingFlowParams$SubscriptionUpdateParams$Builder0.zzc = true;
                return billingFlowParams$SubscriptionUpdateParams$Builder0;
            }
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface ReplacementMode {
            public static final int CHARGE_FULL_PRICE = 5;
            public static final int CHARGE_PRORATED_PRICE = 2;
            public static final int DEFERRED = 6;
            public static final int UNKNOWN_REPLACEMENT_MODE = 0;
            public static final int WITHOUT_PRORATION = 3;
            public static final int WITH_TIME_PRORATION = 1;

        }

        private String zza;
        private String zzb;
        private int zzc;
        private int zzd;

        private SubscriptionUpdateParams() {
            this.zzc = 0;
            this.zzd = 0;
        }

        SubscriptionUpdateParams(zzbv zzbv0) {
            this.zzc = 0;
            this.zzd = 0;
        }

        public static com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder newBuilder() {
            return new com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder(null);
        }

        @Deprecated
        final int zza() {
            return this.zzc;
        }

        final int zzb() {
            return this.zzd;
        }

        static com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder zzc(SubscriptionUpdateParams billingFlowParams$SubscriptionUpdateParams0) {
            com.android.billingclient.api.BillingFlowParams.SubscriptionUpdateParams.Builder billingFlowParams$SubscriptionUpdateParams$Builder0 = SubscriptionUpdateParams.newBuilder();
            billingFlowParams$SubscriptionUpdateParams$Builder0.setOldSkuPurchaseToken(billingFlowParams$SubscriptionUpdateParams0.zza);
            billingFlowParams$SubscriptionUpdateParams$Builder0.setReplaceSkusProrationMode(billingFlowParams$SubscriptionUpdateParams0.zzc);
            billingFlowParams$SubscriptionUpdateParams$Builder0.setSubscriptionReplacementMode(billingFlowParams$SubscriptionUpdateParams0.zzd);
            billingFlowParams$SubscriptionUpdateParams$Builder0.setOriginalExternalTransactionId(billingFlowParams$SubscriptionUpdateParams0.zzb);
            return billingFlowParams$SubscriptionUpdateParams$Builder0;
        }

        final String zzd() {
            return this.zza;
        }

        final String zze() {
            return this.zzb;
        }
    }

    public static final String EXTRA_PARAM_KEY_ACCOUNT_ID = "accountId";
    private boolean zza;
    private String zzb;
    private String zzc;
    private SubscriptionUpdateParams zzd;
    private zzai zze;
    private ArrayList zzf;
    private boolean zzg;

    private BillingFlowParams() {
    }

    BillingFlowParams(zzbw zzbw0) {
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    @Deprecated
    public final int zza() {
        return this.zzd.zza();
    }

    public final int zzb() {
        return this.zzd.zzb();
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzd.zzd();
    }

    public final String zzf() {
        return this.zzd.zze();
    }

    public final ArrayList zzg() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.addAll(this.zzf);
        return arrayList0;
    }

    public final List zzh() {
        return this.zze;
    }

    public final boolean zzp() {
        return this.zzg;
    }

    // 去混淆评级： 低(20)
    final boolean zzq() {
        return this.zzb != null || this.zzc != null || this.zzd.zze() != null || this.zzd.zza() != 0 || this.zzd.zzb() != 0 || this.zza || this.zzg;
    }
}

