package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzal;
import com.google.android.gms.internal.play_billing.zzgh;
import com.google.android.gms.internal.play_billing.zzgl;
import com.google.android.gms.internal.play_billing.zzgv;
import com.google.android.gms.internal.play_billing.zzhs;
import java.util.List;

interface zzby {
    public static final zzal zza;

    static {
        zzby.zza = zzal.zzc("com.android.vending.billing.PURCHASES_UPDATED", zzgv.zzb, "com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", zzgv.zzc, "com.android.vending.billing.ALTERNATIVE_BILLING", zzgv.zzd);
    }

    void zza(zzgh arg1);

    void zzb(zzgl arg1);

    void zzc(byte[] arg1);

    void zzd(zzhs arg1);

    void zze(int arg1, List arg2, boolean arg3, boolean arg4);

    void zzf(int arg1, List arg2, List arg3, BillingResult arg4, boolean arg5, boolean arg6);
}

