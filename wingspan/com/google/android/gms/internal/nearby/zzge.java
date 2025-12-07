package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.DiscoveryOptions;

public final class zzge {
    private final zzgc zzeo;

    public zzge() {
        this.zzeo = new zzgc(null);
    }

    public final zzge zza(zzdr zzdr0) {
        this.zzeo.zzen = zzdr0;
        return this;
    }

    public final zzge zze(long v) {
        this.zzeo.durationMillis = v;
        return this;
    }

    public final zzge zze(DiscoveryOptions discoveryOptions0) {
        this.zzeo.zzem = discoveryOptions0;
        return this;
    }

    public final zzge zzf(zzdz zzdz0) {
        this.zzeo.zzar = zzdz0;
        return this;
    }

    public final zzge zzk(String s) {
        this.zzeo.zzu = s;
        return this;
    }

    public final zzgc zzw() {
        return this.zzeo;
    }
}

