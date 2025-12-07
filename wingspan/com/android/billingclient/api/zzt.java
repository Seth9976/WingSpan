package com.android.billingclient.api;

public final class zzt implements Runnable {
    public final BillingClientImpl zza;
    public final BillingConfigResponseListener zzb;

    public zzt(BillingClientImpl billingClientImpl0, BillingConfigResponseListener billingConfigResponseListener0) {
        this.zza = billingClientImpl0;
        this.zzb = billingConfigResponseListener0;
    }

    @Override
    public final void run() {
        this.zza.zzV(this.zzb);
    }
}

