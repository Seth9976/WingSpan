package com.google.android.gms.internal.play_billing;

final class zzdw extends zzdy {
    private zzdw() {
        super(null);
    }

    zzdw(zzdv zzdv0) {
        super(null);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdy
    final void zza(Object object0, long v) {
        ((zzdk)zzfw.zzf(object0, v)).zzb();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdy
    final void zzb(Object object0, Object object1, long v) {
        zzdk zzdk0 = (zzdk)zzfw.zzf(object0, v);
        zzdk zzdk1 = (zzdk)zzfw.zzf(object1, v);
        int v1 = zzdk0.size();
        int v2 = zzdk1.size();
        if(v1 > 0 && v2 > 0) {
            if(!zzdk0.zzc()) {
                zzdk0 = zzdk0.zzd(v2 + v1);
            }
            zzdk0.addAll(zzdk1);
        }
        if(v1 > 0) {
            zzdk1 = zzdk0;
        }
        zzfw.zzs(object0, v, zzdk1);
    }
}

