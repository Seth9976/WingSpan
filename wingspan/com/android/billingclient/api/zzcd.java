package com.android.billingclient.api;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzbg;
import com.google.android.gms.internal.play_billing.zzcp;
import com.google.android.gms.internal.play_billing.zzgh;
import com.google.android.gms.internal.play_billing.zzgl;
import com.google.android.gms.internal.play_billing.zzgn;
import com.google.android.gms.internal.play_billing.zzgr;
import com.google.android.gms.internal.play_billing.zzgw;
import com.google.android.gms.internal.play_billing.zzgy;
import com.google.android.gms.internal.play_billing.zzhb;
import com.google.android.gms.internal.play_billing.zzhd;
import com.google.android.gms.internal.play_billing.zzhe;
import com.google.android.gms.internal.play_billing.zzhk;
import com.google.android.gms.internal.play_billing.zzhl;
import com.google.android.gms.internal.play_billing.zzhn;
import com.google.android.gms.internal.play_billing.zzho;
import com.google.android.gms.internal.play_billing.zzhs;
import java.util.List;

final class zzcd implements zzby {
    private final zzhb zzb;
    private final Context zzc;
    private final zzcf zzd;

    zzcd(Context context0, zzhb zzhb0) {
        zzcf zzcf0 = new zzcf(context0);
        super();
        this.zzd = zzcf0;
        this.zzb = zzhb0;
        this.zzc = context0;
    }

    @Override  // com.android.billingclient.api.zzby
    public final void zza(zzgh zzgh0) {
        if(zzgh0 == null) {
            return;
        }
        try {
            zzhk zzhk0 = zzhl.zzz();
            zzhb zzhb0 = this.zzb;
            if(zzhb0 != null) {
                zzhk0.zzl(zzhb0);
            }
            zzhk0.zzi(zzgh0);
            zzhl zzhl0 = (zzhl)zzhk0.zzc();
            this.zzd.zza(zzhl0);
        }
        catch(Throwable throwable0) {
            zzb.zzl("BillingLogger", "Unable to log.", throwable0);
        }
    }

    @Override  // com.android.billingclient.api.zzby
    public final void zzb(zzgl zzgl0) {
        if(zzgl0 == null) {
            return;
        }
        try {
            zzhk zzhk0 = zzhl.zzz();
            zzhb zzhb0 = this.zzb;
            if(zzhb0 != null) {
                zzhk0.zzl(zzhb0);
            }
            zzhk0.zzj(zzgl0);
            zzhl zzhl0 = (zzhl)zzhk0.zzc();
            this.zzd.zza(zzhl0);
        }
        catch(Throwable throwable0) {
            zzb.zzl("BillingLogger", "Unable to log.", throwable0);
        }
    }

    @Override  // com.android.billingclient.api.zzby
    public final void zzc(byte[] arr_b) {
        try {
            this.zzg(zzgy.zzB(arr_b, zzcp.zza()));
        }
        catch(Throwable throwable0) {
            zzb.zzl("BillingLogger", "Unable to log.", throwable0);
        }
    }

    @Override  // com.android.billingclient.api.zzby
    public final void zzd(zzhs zzhs0) {
        if(zzhs0 == null) {
            return;
        }
        try {
            zzhk zzhk0 = zzhl.zzz();
            zzhb zzhb0 = this.zzb;
            if(zzhb0 != null) {
                zzhk0.zzl(zzhb0);
            }
            zzhk0.zzn(zzhs0);
            zzhl zzhl0 = (zzhl)zzhk0.zzc();
            this.zzd.zza(zzhl0);
        }
        catch(Throwable throwable0) {
            zzb.zzl("BillingLogger", "Unable to log.", throwable0);
        }
    }

    @Override  // com.android.billingclient.api.zzby
    public final void zze(int v, List list0, boolean z, boolean z1) {
        zzgy zzgy0;
        try {
            try {
                zzgw zzgw0 = zzgy.zzz();
                zzgw0.zzn(v);
                zzgw0.zzm(false);
                zzgw0.zzl(z1);
                zzgw0.zzi(list0);
                zzgy0 = (zzgy)zzgw0.zzc();
            }
            catch(Exception exception0) {
                zzb.zzl("BillingLogger", "Unable to create logging payload", exception0);
                zzgy0 = null;
            }
            this.zzg(zzgy0);
        }
        catch(Throwable throwable0) {
            zzb.zzl("BillingLogger", "Unable to log.", throwable0);
        }
    }

    @Override  // com.android.billingclient.api.zzby
    public final void zzf(int v, List list0, List list1, BillingResult billingResult0, boolean z, boolean z1) {
        zzgy zzgy0;
        try {
            try {
                zzgw zzgw0 = zzgy.zzz();
                zzgw0.zzn(4);
                zzgw0.zzi(list0);
                zzgw0.zzm(false);
                zzgw0.zzl(z1);
                for(Object object0: list1) {
                    zzhn zzhn0 = zzho.zzz();
                    zzhn0.zzi(((Purchase)object0).getProducts());
                    zzhn0.zzk(((Purchase)object0).getPurchaseState());
                    zzhn0.zzj(((Purchase)object0).getPackageName());
                    zzgw0.zzj(zzhn0);
                }
                zzgn zzgn0 = zzgr.zzz();
                zzgn0.zzk(billingResult0.getResponseCode());
                zzgn0.zzj(billingResult0.getDebugMessage());
                zzgw0.zzk(zzgn0);
                zzgy0 = (zzgy)zzgw0.zzc();
            }
            catch(Exception exception0) {
                zzb.zzl("BillingLogger", "Unable to create logging payload", exception0);
                zzgy0 = null;
            }
            this.zzg(zzgy0);
        }
        catch(Throwable throwable0) {
            zzb.zzl("BillingLogger", "Unable to log.", throwable0);
        }
    }

    final void zzg(zzgy zzgy0) {
        long v;
        if(zzgy0 != null && this.zzb != null) {
            try {
                String s = null;
                ContentResolver contentResolver0 = this.zzc == null ? null : this.zzc.getContentResolver();
                if(contentResolver0 != null) {
                    s = Settings.Secure.getString(contentResolver0, "android_id");
                }
                v = ((long)((s == null ? 0 : zzbg.zza().zza(s).zza()) % 100)) % 100L;
                if(v < 0L) {
                    goto label_7;
                }
                goto label_8;
            }
            catch(Exception unused_ex) {
                return;
            }
            catch(Throwable throwable0) {
                zzb.zzl("BillingLogger", "Unable to log.", throwable0);
                return;
            }
        label_7:
            v += 100L;
        label_8:
            if(((long)(((int)v))) < 0L) {
                try {
                    zzhk zzhk0 = zzhl.zzz();
                    zzhb zzhb0 = this.zzb;
                    if(zzhb0 != null) {
                        zzhk0.zzl(zzhb0);
                    }
                    zzhk0.zzk(zzgy0);
                    zzhd zzhd0 = zzhe.zzz();
                    zzdi.zza(this.zzc);
                    zzhd0.zzi(false);
                    zzhk0.zzm(zzhd0);
                    zzhl zzhl0 = (zzhl)zzhk0.zzc();
                    this.zzd.zza(zzhl0);
                }
                catch(Throwable throwable0) {
                    zzb.zzl("BillingLogger", "Unable to log.", throwable0);
                }
            }
        }
    }
}

