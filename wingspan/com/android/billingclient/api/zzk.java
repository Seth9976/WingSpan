package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

final class zzk {
    private final Context zza;
    private final PurchasesUpdatedListener zzb;
    private final AlternativeBillingListener zzc;
    private final UserChoiceBillingListener zzd;
    private final zzby zze;
    private final zzj zzf;
    private final zzj zzg;
    private boolean zzh;

    zzk(Context context0, PurchasesUpdatedListener purchasesUpdatedListener0, zzcg zzcg0, AlternativeBillingListener alternativeBillingListener0, UserChoiceBillingListener userChoiceBillingListener0, zzby zzby0) {
        this.zza = context0;
        this.zzb = purchasesUpdatedListener0;
        this.zzc = alternativeBillingListener0;
        this.zzd = userChoiceBillingListener0;
        this.zze = zzby0;
        this.zzf = new zzj(this, true);
        this.zzg = new zzj(this, false);
    }

    final PurchasesUpdatedListener zzd() {
        return this.zzb;
    }

    final void zzf() {
        this.zzf.zzb(this.zza);
        this.zzg.zzb(this.zza);
    }

    final void zzg(boolean z) {
        IntentFilter intentFilter0 = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter1 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter1.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.zzh = z;
        this.zzg.zza(this.zza, intentFilter1);
        if(this.zzh) {
            zzdi.zza(this.zza);
        }
        this.zzf.zza(this.zza, intentFilter0);
    }
}

