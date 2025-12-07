package com.android.billingclient.api;

public final class zzai implements Runnable {
    public final BillingClientImpl zza;
    public final PurchaseHistoryResponseListener zzb;

    public zzai(BillingClientImpl billingClientImpl0, PurchaseHistoryResponseListener purchaseHistoryResponseListener0) {
        this.zza = billingClientImpl0;
        this.zzb = purchaseHistoryResponseListener0;
    }

    @Override
    public final void run() {
        this.zza.zzZ(this.zzb);
    }
}

