package com.android.billingclient.api;

public final class zzag implements Runnable {
    public final BillingClientImpl zza;
    public final ExternalOfferReportingDetailsListener zzb;

    public zzag(BillingClientImpl billingClientImpl0, ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener0) {
        this.zza = billingClientImpl0;
        this.zzb = externalOfferReportingDetailsListener0;
    }

    @Override
    public final void run() {
        this.zza.zzU(this.zzb);
    }
}

