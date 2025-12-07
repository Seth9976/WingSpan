package com.android.billingclient.api;

public final class zzac implements Runnable {
    public final BillingClientImpl zza;
    public final AlternativeBillingOnlyAvailabilityListener zzb;

    public zzac(BillingClientImpl billingClientImpl0, AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener0) {
        this.zza = billingClientImpl0;
        this.zzb = alternativeBillingOnlyAvailabilityListener0;
    }

    @Override
    public final void run() {
        this.zza.zzW(this.zzb);
    }
}

