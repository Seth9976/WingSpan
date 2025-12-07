package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;

final class zzbt extends zzbv {
    final zzcc zza;
    private int zzb;
    private final int zzc;

    zzbt(zzcc zzcc0) {
        this.zza = zzcc0;
        super();
        this.zzb = 0;
        this.zzc = zzcc0.zzd();
    }

    @Override
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbx
    public final byte zza() {
        int v = this.zzb;
        if(v >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = v + 1;
        return this.zza.zzb(v);
    }
}

