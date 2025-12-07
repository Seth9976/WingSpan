package com.google.android.gms.internal.play_billing;

import java.util.Objects;

final class zzat extends zzai {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzat(Object[] arr_object, int v, int v1) {
        this.zza = arr_object;
        this.zzb = v;
        this.zzc = v1;
    }

    @Override
    public final Object get(int v) {
        zzaa.zza(v, this.zzc, "index");
        return Objects.requireNonNull(this.zza[v + v + this.zzb]);
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    final boolean zzf() {
        return true;
    }
}

