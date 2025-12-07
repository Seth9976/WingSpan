package com.android.billingclient.api;

public final class zzae implements Runnable {
    public final BillingClientImpl zza;
    public final ConsumeResponseListener zzb;
    public final ConsumeParams zzc;

    public zzae(BillingClientImpl billingClientImpl0, ConsumeResponseListener consumeResponseListener0, ConsumeParams consumeParams0) {
        this.zza = billingClientImpl0;
        this.zzb = consumeResponseListener0;
        this.zzc = consumeParams0;
    }

    @Override
    public final void run() {
        this.zza.zzS(this.zzb, this.zzc);
    }
}

