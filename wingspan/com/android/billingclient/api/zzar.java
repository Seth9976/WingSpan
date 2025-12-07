package com.android.billingclient.api;

import java.util.concurrent.Callable;

final class zzar implements Callable {
    final String zza;
    final PurchaseHistoryResponseListener zzb;
    final BillingClientImpl zzc;

    zzar(BillingClientImpl billingClientImpl0, String s, PurchaseHistoryResponseListener purchaseHistoryResponseListener0) {
        this.zza = s;
        this.zzb = purchaseHistoryResponseListener0;
        this.zzc = billingClientImpl0;
        super();
    }

    @Override
    public final Object call() throws Exception {
        zzbp zzbp0 = BillingClientImpl.zzg(this.zzc, this.zza);
        this.zzb.onPurchaseHistoryResponse(zzbp0.zza(), zzbp0.zzb());
        return null;
    }
}

