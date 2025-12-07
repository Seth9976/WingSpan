package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzgh;
import com.google.android.gms.internal.play_billing.zzo;

final class zzbm extends zzo {
    final ExternalOfferAvailabilityListener zza;
    final zzby zzb;

    zzbm(ExternalOfferAvailabilityListener externalOfferAvailabilityListener0, zzby zzby0, zzbl zzbl0) {
        this.zza = externalOfferAvailabilityListener0;
        this.zzb = zzby0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzp
    public final void zza(Bundle bundle0) throws RemoteException {
        if(bundle0 == null) {
            zzgh zzgh0 = zzbx.zzb(92, 23, zzca.zzj);
            this.zzb.zza(zzgh0);
            this.zza.onExternalOfferAvailabilityResponse(zzca.zzj);
            return;
        }
        int v = zzb.zzb(bundle0, "BillingClient");
        BillingResult billingResult0 = zzca.zza(v, zzb.zzg(bundle0, "BillingClient"));
        if(v != 0) {
            zzb.zzk("BillingClient", "isExternalOfferAvailableAsync() failed. Response code: " + v);
            zzgh zzgh1 = zzbx.zzb(23, 23, billingResult0);
            this.zzb.zza(zzgh1);
        }
        this.zza.onExternalOfferAvailabilityResponse(billingResult0);
    }
}

