package com.android.billingclient.api;

public final class zzan implements Runnable {
    public final BillingClientImpl zza;
    public final ExternalOfferAvailabilityListener zzb;

    public zzan(BillingClientImpl billingClientImpl0, ExternalOfferAvailabilityListener externalOfferAvailabilityListener0) {
        this.zza = billingClientImpl0;
        this.zzb = externalOfferAvailabilityListener0;
    }

    @Override
    public final void run() {
        this.zza.zzX(this.zzb);
    }
}

