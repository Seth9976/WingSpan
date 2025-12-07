package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class zzab implements Callable {
    public final BillingClientImpl zza;
    public final AlternativeBillingOnlyAvailabilityListener zzb;

    public zzab(BillingClientImpl billingClientImpl0, AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener0) {
        this.zza = billingClientImpl0;
        this.zzb = alternativeBillingOnlyAvailabilityListener0;
    }

    @Override
    public final Object call() {
        this.zza.zzs(this.zzb);
        return null;
    }
}

