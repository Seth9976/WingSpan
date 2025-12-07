package com.google.android.gms.internal.drive;

abstract class zzla {
    private static final zzla zztm;
    private static final zzla zztn;

    static {
        zzla.zztm = new zzlc(null);
        zzla.zztn = new zzld(null);
    }

    private zzla() {
    }

    zzla(zzlb zzlb0) {
    }

    abstract void zza(Object arg1, long arg2);

    abstract void zza(Object arg1, Object arg2, long arg3);

    static zzla zzdt() {
        return zzla.zztm;
    }

    static zzla zzdu() {
        return zzla.zztn;
    }
}

