package com.android.billingclient.api;

public final class zzm implements Runnable {
    public final BillingClientImpl zza;
    public final BillingResult zzb;

    public zzm(BillingClientImpl billingClientImpl0, BillingResult billingResult0) {
        this.zza = billingClientImpl0;
        this.zzb = billingResult0;
    }

    @Override
    public final void run() {
        this.zza.zzR(this.zzb);
    }
}

