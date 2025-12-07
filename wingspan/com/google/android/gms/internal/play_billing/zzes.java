package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzes {
    private static final zzes zza;
    private final zzew zzb;
    private final ConcurrentMap zzc;

    static {
        zzes.zza = new zzes();
    }

    private zzes() {
        this.zzc = new ConcurrentHashMap();
        this.zzb = new zzec();
    }

    public static zzes zza() {
        return zzes.zza;
    }

    public final zzev zzb(Class class0) {
        zzdl.zzc(class0, "messageType");
        zzev zzev0 = (zzev)this.zzc.get(class0);
        if(zzev0 == null) {
            zzev0 = this.zzb.zza(class0);
            zzdl.zzc(class0, "messageType");
            zzev zzev1 = (zzev)this.zzc.putIfAbsent(class0, zzev0);
            return zzev1 == null ? zzev0 : zzev1;
        }
        return zzev0;
    }
}

