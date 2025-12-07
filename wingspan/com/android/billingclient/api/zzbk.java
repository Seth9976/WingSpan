package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzgh;
import com.google.android.gms.internal.play_billing.zzm;

final class zzbk extends zzm {
    final AlternativeBillingOnlyAvailabilityListener zza;
    final zzby zzb;

    zzbk(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener0, zzby zzby0, zzbj zzbj0) {
        this.zza = alternativeBillingOnlyAvailabilityListener0;
        this.zzb = zzby0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzn
    public final void zza(Bundle bundle0) throws RemoteException {
        if(bundle0 == null) {
            zzgh zzgh0 = zzbx.zzb(67, 14, zzca.zzj);
            this.zzb.zza(zzgh0);
            this.zza.onAlternativeBillingOnlyAvailabilityResponse(zzca.zzj);
            return;
        }
        int v = zzb.zzb(bundle0, "BillingClient");
        BillingResult billingResult0 = zzca.zza(v, zzb.zzg(bundle0, "BillingClient"));
        if(v != 0) {
            zzb.zzk("BillingClient", "isAlternativeBillingOnlyAvailableAsync() failed. Response code: " + v);
            zzgh zzgh1 = zzbx.zzb(23, 14, billingResult0);
            this.zzb.zza(zzgh1);
        }
        this.zza.onAlternativeBillingOnlyAvailabilityResponse(billingResult0);
    }
}

