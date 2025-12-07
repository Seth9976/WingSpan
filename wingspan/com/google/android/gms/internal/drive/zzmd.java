package com.google.android.gms.internal.drive;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzmd {
    private static final zzmd zzuw;
    private final zzmg zzux;
    private final ConcurrentMap zzuy;

    static {
        zzmd.zzuw = new zzmd();
    }

    private zzmd() {
        this.zzuy = new ConcurrentHashMap();
        this.zzux = new zzlf();
    }

    public static zzmd zzej() {
        return zzmd.zzuw;
    }

    public final zzmf zzf(Class class0) {
        zzkm.zza(class0, "messageType");
        zzmf zzmf0 = (zzmf)this.zzuy.get(class0);
        if(zzmf0 == null) {
            zzmf0 = this.zzux.zze(class0);
            zzkm.zza(class0, "messageType");
            zzkm.zza(zzmf0, "schema");
            zzmf zzmf1 = (zzmf)this.zzuy.putIfAbsent(class0, zzmf0);
            return zzmf1 == null ? zzmf0 : zzmf1;
        }
        return zzmf0;
    }

    public final zzmf zzq(Object object0) {
        return this.zzf(object0.getClass());
    }
}

