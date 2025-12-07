package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzai;
import java.util.concurrent.Callable;

final class zzaq implements Callable {
    final String zza;
    final PurchasesResponseListener zzb;
    final BillingClientImpl zzc;

    zzaq(BillingClientImpl billingClientImpl0, String s, PurchasesResponseListener purchasesResponseListener0) {
        this.zza = s;
        this.zzb = purchasesResponseListener0;
        this.zzc = billingClientImpl0;
        super();
    }

    @Override
    public final Object call() throws Exception {
        zzcx zzcx0 = BillingClientImpl.zzaf(this.zzc, this.zza, 9);
        if(zzcx0.zzb() != null) {
            this.zzb.onQueryPurchasesResponse(zzcx0.zza(), zzcx0.zzb());
            return null;
        }
        this.zzb.onQueryPurchasesResponse(zzcx0.zza(), zzai.zzk());
        return null;
    }
}

