package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

public final class zzs implements Callable {
    public final BillingClientImpl zza;
    public final Bundle zzb;
    public final BillingConfigResponseListener zzc;

    public zzs(BillingClientImpl billingClientImpl0, Bundle bundle0, BillingConfigResponseListener billingConfigResponseListener0) {
        this.zza = billingClientImpl0;
        this.zzb = bundle0;
        this.zzc = billingConfigResponseListener0;
    }

    @Override
    public final Object call() {
        this.zza.zzm(this.zzb, this.zzc);
        return null;
    }
}

