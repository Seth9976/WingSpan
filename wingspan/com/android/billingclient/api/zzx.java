package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final class zzx implements Callable {
    public final BillingClientImpl zza;
    public final ExternalOfferReportingDetailsListener zzb;

    public zzx(BillingClientImpl billingClientImpl0, ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener0) {
        this.zza = billingClientImpl0;
        this.zzb = externalOfferReportingDetailsListener0;
    }

    @Override
    public final Object call() {
        this.zza.zzr(this.zzb);
        return null;
    }
}

