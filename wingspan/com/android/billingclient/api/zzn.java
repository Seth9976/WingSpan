package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class zzn implements Callable {
    public final BillingClientImpl zza;
    public final String zzb;
    public final String zzc;

    public zzn(BillingClientImpl billingClientImpl0, String s, String s1) {
        this.zza = billingClientImpl0;
        this.zzb = s;
        this.zzc = s1;
    }

    @Override
    public final Object call() {
        return this.zza.zzd(this.zzb, this.zzc);
    }
}

