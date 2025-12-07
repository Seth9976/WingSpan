package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class zzq implements Callable {
    public final BillingClientImpl zza;
    public final AcknowledgePurchaseParams zzb;
    public final AcknowledgePurchaseResponseListener zzc;

    public zzq(BillingClientImpl billingClientImpl0, AcknowledgePurchaseParams acknowledgePurchaseParams0, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener0) {
        this.zza = billingClientImpl0;
        this.zzb = acknowledgePurchaseParams0;
        this.zzc = acknowledgePurchaseResponseListener0;
    }

    @Override
    public final Object call() {
        this.zza.zzk(this.zzb, this.zzc);
        return null;
    }
}

