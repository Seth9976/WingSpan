package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class zzaj implements Callable {
    public final BillingClientImpl zza;
    public final QueryProductDetailsParams zzb;
    public final ProductDetailsResponseListener zzc;

    public zzaj(BillingClientImpl billingClientImpl0, QueryProductDetailsParams queryProductDetailsParams0, ProductDetailsResponseListener productDetailsResponseListener0) {
        this.zza = billingClientImpl0;
        this.zzb = queryProductDetailsParams0;
        this.zzc = productDetailsResponseListener0;
    }

    @Override
    public final Object call() {
        this.zza.zzn(this.zzb, this.zzc);
        return null;
    }
}

