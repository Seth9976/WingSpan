package com.google.android.gms.internal.play_billing;

abstract class zzdy {
    private static final zzdy zza;
    private static final zzdy zzb;

    static {
        zzdy.zza = new zzdu(null);
        zzdy.zzb = new zzdw(null);
    }

    zzdy(zzdx zzdx0) {
    }

    abstract void zza(Object arg1, long arg2);

    abstract void zzb(Object arg1, Object arg2, long arg3);

    static zzdy zzc() {
        return zzdy.zza;
    }

    static zzdy zzd() {
        return zzdy.zzb;
    }
}

