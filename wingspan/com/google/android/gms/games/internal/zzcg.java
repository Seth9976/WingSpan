package com.google.android.gms.games.internal;

public final class zzcg {
    private static final zzcg zza;
    private volatile boolean zzb;

    static {
        zzcg.zza = new zzcg();
    }

    zzcg() {
        this.zzb = false;
    }

    public static zzcg zza() {
        return zzcg.zza;
    }

    public final void zzb() {
        this.zzb = true;
    }
}

