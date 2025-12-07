package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

public final class zzao implements Callable {
    public final BillingClientImpl zza;
    public final int zzb;
    public final String zzc;
    public final String zzd;
    public final BillingFlowParams zze;
    public final Bundle zzf;

    public zzao(BillingClientImpl billingClientImpl0, int v, String s, String s1, BillingFlowParams billingFlowParams0, Bundle bundle0) {
        this.zza = billingClientImpl0;
        this.zzb = v;
        this.zzc = s;
        this.zzd = s1;
        this.zze = billingFlowParams0;
        this.zzf = bundle0;
    }

    @Override
    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}

