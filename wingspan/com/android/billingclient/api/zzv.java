package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class zzv implements Callable {
    public final BillingClientImpl zza;
    public final AlternativeBillingOnlyReportingDetailsListener zzb;

    public zzv(BillingClientImpl billingClientImpl0, AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener0) {
        this.zza = billingClientImpl0;
        this.zzb = alternativeBillingOnlyReportingDetailsListener0;
    }

    @Override
    public final Object call() {
        this.zza.zzq(this.zzb);
        return null;
    }
}

