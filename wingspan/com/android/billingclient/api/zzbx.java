package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzgg;
import com.google.android.gms.internal.play_billing.zzgh;
import com.google.android.gms.internal.play_billing.zzgk;
import com.google.android.gms.internal.play_billing.zzgl;
import com.google.android.gms.internal.play_billing.zzgn;
import com.google.android.gms.internal.play_billing.zzgr;
import com.google.android.gms.internal.play_billing.zzgv;
import com.google.android.gms.internal.play_billing.zzgw;
import com.google.android.gms.internal.play_billing.zzgy;
import java.util.List;

public final class zzbx {
    public static final int zza;

    static {
    }

    public static zzgv zza(String s) {
        return (zzgv)zzby.zza.getOrDefault(s, zzgv.zza);
    }

    public static zzgh zzb(int v, int v1, BillingResult billingResult0) {
        try {
            zzgg zzgg0 = zzgh.zzz();
            zzgn zzgn0 = zzgr.zzz();
            zzgn0.zzk(billingResult0.getResponseCode());
            zzgn0.zzj(billingResult0.getDebugMessage());
            zzgn0.zzl(v);
            zzgg0.zzi(zzgn0);
            zzgg0.zzk(v1);
            return (zzgh)zzgg0.zzc();
        }
        catch(Exception exception0) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", exception0);
            return null;
        }
    }

    public static zzgh zzc(int v, int v1, BillingResult billingResult0, String s) {
        try {
            zzgn zzgn0 = zzgr.zzz();
            zzgn0.zzk(billingResult0.getResponseCode());
            zzgn0.zzj(billingResult0.getDebugMessage());
            zzgn0.zzl(v);
            if(s != null) {
                zzgn0.zzi(s);
            }
            zzgg zzgg0 = zzgh.zzz();
            zzgg0.zzi(zzgn0);
            zzgg0.zzk(v1);
            return (zzgh)zzgg0.zzc();
        }
        catch(Exception exception0) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", exception0);
            return null;
        }
    }

    public static zzgl zzd(int v) {
        try {
            zzgk zzgk0 = zzgl.zzz();
            zzgk0.zzj(v);
            return (zzgl)zzgk0.zzc();
        }
        catch(Exception exception0) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", exception0);
            return null;
        }
    }

    public static zzgy zze(int v, List list0) {
        try {
            zzgw zzgw0 = zzgy.zzz();
            zzgw0.zzn(3);
            zzgw0.zzi(list0);
            return (zzgy)zzgw0.zzc();
        }
        catch(Exception exception0) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", exception0);
            return null;
        }
    }
}

