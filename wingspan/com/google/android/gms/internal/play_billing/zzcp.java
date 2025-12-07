package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzcp {
    static final zzcp zza;
    public static final int zzb;
    private static volatile boolean zzc;
    private static volatile zzcp zzd;
    private final Map zze;

    static {
        zzcp.zza = new zzcp(true);
    }

    zzcp() {
        this.zze = new HashMap();
    }

    zzcp(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzcp zza() {
        zzcp zzcp0 = zzcp.zzd;
        if(zzcp0 != null) {
            return zzcp0;
        }
        synchronized(zzcp.class) {
            zzcp zzcp1 = zzcp.zzd;
            if(zzcp1 != null) {
                return zzcp1;
            }
            zzcp zzcp2 = zzcx.zzb(zzcp.class);
            zzcp.zzd = zzcp2;
            return zzcp2;
        }
    }

    public final zzdb zzb(zzek zzek0, int v) {
        zzco zzco0 = new zzco(zzek0, v);
        return (zzdb)this.zze.get(zzco0);
    }
}

