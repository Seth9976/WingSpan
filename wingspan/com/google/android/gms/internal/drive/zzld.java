package com.google.android.gms.internal.drive;

final class zzld extends zzla {
    private zzld() {
        super(null);
    }

    zzld(zzlb zzlb0) {
    }

    @Override  // com.google.android.gms.internal.drive.zzla
    final void zza(Object object0, long v) {
        zzld.zzc(object0, v).zzbp();
    }

    @Override  // com.google.android.gms.internal.drive.zzla
    final void zza(Object object0, Object object1, long v) {
        zzkp zzkp0 = zzld.zzc(object0, v);
        zzkp zzkp1 = zzld.zzc(object1, v);
        int v1 = zzkp0.size();
        int v2 = zzkp1.size();
        if(v1 > 0 && v2 > 0) {
            if(!zzkp0.zzbo()) {
                zzkp0 = zzkp0.zzr(v2 + v1);
            }
            zzkp0.addAll(zzkp1);
        }
        if(v1 > 0) {
            zzkp1 = zzkp0;
        }
        zznd.zza(object0, v, zzkp1);
    }

    private static zzkp zzc(Object object0, long v) {
        return (zzkp)zznd.zzo(object0, v);
    }
}

