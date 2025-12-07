package com.android.billingclient.api;

public final class zzak implements Runnable {
    public final BillingClientImpl zza;
    public final ProductDetailsResponseListener zzb;

    public zzak(BillingClientImpl billingClientImpl0, ProductDetailsResponseListener productDetailsResponseListener0) {
        this.zza = billingClientImpl0;
        this.zzb = productDetailsResponseListener0;
    }

    @Override
    public final void run() {
        this.zza.zzY(this.zzb);
    }
}

