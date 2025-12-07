package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.ExecutorService;

public abstract class BillingClient {
    @Retention(RetentionPolicy.SOURCE)
    public @interface BillingResponseCode {
        public static final int BILLING_UNAVAILABLE = 3;
        public static final int DEVELOPER_ERROR = 5;
        public static final int ERROR = 6;
        public static final int FEATURE_NOT_SUPPORTED = -2;
        public static final int ITEM_ALREADY_OWNED = 7;
        public static final int ITEM_NOT_OWNED = 8;
        public static final int ITEM_UNAVAILABLE = 4;
        public static final int NETWORK_ERROR = 12;
        public static final int OK = 0;
        public static final int SERVICE_DISCONNECTED = -1;
        @Deprecated
        public static final int SERVICE_TIMEOUT = -3;
        public static final int SERVICE_UNAVAILABLE = 2;
        public static final int USER_CANCELED = 1;

    }

    public static final class Builder {
        private volatile String zza;
        private volatile zzcn zzb;
        private final Context zzc;
        private volatile PurchasesUpdatedListener zzd;
        private volatile zzcg zze;
        private volatile zzby zzf;
        private volatile AlternativeBillingListener zzg;
        private volatile UserChoiceBillingListener zzh;
        private volatile ExecutorService zzi;
        private volatile boolean zzj;
        private volatile boolean zzk;

        Builder(Context context0, zzl zzl0) {
            this.zzc = context0;
        }

        public BillingClient build() {
            if(this.zzc == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            if(this.zzg != null && this.zzh != null) {
                throw new IllegalArgumentException("Please provide only one valid listener for alternative billing/user choice billing updates.");
            }
            if(this.zzd == null) {
                if(this.zzg != null) {
                    throw new IllegalArgumentException("Please provide a valid listener for Google Play Billing purchases updates when enabling Alternative Billing.");
                }
                if(this.zzh != null) {
                    throw new IllegalArgumentException("Please provide a valid listener for Google Play Billing purchases updates when enabling User Choice Billing.");
                }
                if(!this.zzj && !this.zzk) {
                    throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
                }
                return new BillingClientImpl(null, this.zzc, null, null);
            }
            if(this.zzb == null) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            if(this.zzd != null) {
                return this.zzh == null ? new BillingClientImpl(null, this.zzb, this.zzc, this.zzd, this.zzg, null, null) : new BillingClientImpl(null, this.zzb, this.zzc, this.zzd, this.zzh, null, null);
            }
            return new BillingClientImpl(null, this.zzb, this.zzc, null, null, null);
        }

        @Deprecated
        public Builder enableAlternativeBilling(AlternativeBillingListener alternativeBillingListener0) {
            this.zzg = alternativeBillingListener0;
            return this;
        }

        public Builder enableAlternativeBillingOnly() {
            this.zzj = true;
            return this;
        }

        public Builder enableExternalOffer() {
            this.zzk = true;
            return this;
        }

        public Builder enablePendingPurchases() {
            zzcl zzcl0 = new zzcl(null);
            zzcl0.zza();
            this.zzb = zzcl0.zzb();
            return this;
        }

        public Builder enableUserChoiceBilling(UserChoiceBillingListener userChoiceBillingListener0) {
            this.zzh = userChoiceBillingListener0;
            return this;
        }

        public Builder setListener(PurchasesUpdatedListener purchasesUpdatedListener0) {
            this.zzd = purchasesUpdatedListener0;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionState {
        public static final int CLOSED = 3;
        public static final int CONNECTED = 2;
        public static final int CONNECTING = 1;
        public static final int DISCONNECTED;

    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FeatureType {
        public static final String ALTERNATIVE_BILLING_ONLY = "jjj";
        public static final String BILLING_CONFIG = "ggg";
        public static final String EXTERNAL_OFFER = "kkk";
        public static final String IN_APP_MESSAGING = "bbb";
        public static final String PRICE_CHANGE_CONFIRMATION = "priceChangeConfirmation";
        public static final String PRODUCT_DETAILS = "fff";
        public static final String SUBSCRIPTIONS = "subscriptions";
        public static final String SUBSCRIPTIONS_UPDATE = "subscriptionsUpdate";

    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProductType {
        public static final String INAPP = "inapp";
        public static final String SUBS = "subs";

    }

    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    public @interface SkuType {
        public static final String INAPP = "inapp";
        public static final String SUBS = "subs";

    }

    public abstract void acknowledgePurchase(AcknowledgePurchaseParams arg1, AcknowledgePurchaseResponseListener arg2);

    public abstract void consumeAsync(ConsumeParams arg1, ConsumeResponseListener arg2);

    public abstract void createAlternativeBillingOnlyReportingDetailsAsync(AlternativeBillingOnlyReportingDetailsListener arg1);

    public abstract void createExternalOfferReportingDetailsAsync(ExternalOfferReportingDetailsListener arg1);

    public abstract void endConnection();

    public abstract void getBillingConfigAsync(GetBillingConfigParams arg1, BillingConfigResponseListener arg2);

    public abstract int getConnectionState();

    public abstract void isAlternativeBillingOnlyAvailableAsync(AlternativeBillingOnlyAvailabilityListener arg1);

    public abstract void isExternalOfferAvailableAsync(ExternalOfferAvailabilityListener arg1);

    public abstract BillingResult isFeatureSupported(String arg1);

    public abstract boolean isReady();

    public abstract BillingResult launchBillingFlow(Activity arg1, BillingFlowParams arg2);

    public static Builder newBuilder(Context context0) {
        return new Builder(context0, null);
    }

    public abstract void queryProductDetailsAsync(QueryProductDetailsParams arg1, ProductDetailsResponseListener arg2);

    public abstract void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams arg1, PurchaseHistoryResponseListener arg2);

    @Deprecated
    public abstract void queryPurchaseHistoryAsync(String arg1, PurchaseHistoryResponseListener arg2);

    public abstract void queryPurchasesAsync(QueryPurchasesParams arg1, PurchasesResponseListener arg2);

    @Deprecated
    public abstract void queryPurchasesAsync(String arg1, PurchasesResponseListener arg2);

    @Deprecated
    public abstract void querySkuDetailsAsync(SkuDetailsParams arg1, SkuDetailsResponseListener arg2);

    public abstract BillingResult showAlternativeBillingOnlyInformationDialog(Activity arg1, AlternativeBillingOnlyInformationDialogListener arg2);

    public abstract BillingResult showExternalOfferInformationDialog(Activity arg1, ExternalOfferInformationDialogListener arg2);

    public abstract BillingResult showInAppMessages(Activity arg1, InAppMessageParams arg2, InAppMessageResponseListener arg3);

    public abstract void startConnection(BillingClientStateListener arg1);
}

