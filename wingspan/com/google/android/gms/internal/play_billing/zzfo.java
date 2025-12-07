package com.google.android.gms.internal.play_billing;

import java.io.IOException;

final class zzfo extends zzfm {
    @Override  // com.google.android.gms.internal.play_billing.zzfm
    final int zza(Object object0) {
        return ((zzfn)object0).zza();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfm
    final int zzb(Object object0) {
        return ((zzfn)object0).zzb();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfm
    final Object zzc(Object object0) {
        zzfn zzfn0 = ((zzdd)object0).zzc;
        if(zzfn0 == zzfn.zzc()) {
            zzfn0 = zzfn.zzf();
            ((zzdd)object0).zzc = zzfn0;
        }
        return zzfn0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfm
    final Object zzd(Object object0) {
        return ((zzdd)object0).zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfm
    final Object zze(Object object0, Object object1) {
        if(!zzfn.zzc().equals(object1)) {
            if(zzfn.zzc().equals(object0)) {
                return zzfn.zze(((zzfn)object0), ((zzfn)object1));
            }
            ((zzfn)object0).zzd(((zzfn)object1));
        }
        return object0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfm
    final void zzf(Object object0, int v, long v1) {
        ((zzfn)object0).zzj(v << 3, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfm
    final void zzg(Object object0) {
        ((zzdd)object0).zzc.zzh();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfm
    final void zzh(Object object0, Object object1) {
        ((zzdd)object0).zzc = (zzfn)object1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfm
    final void zzi(Object object0, zzge zzge0) throws IOException {
        ((zzfn)object0).zzk(zzge0);
    }
}

