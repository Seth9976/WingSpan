package com.google.android.gms.internal.play_billing;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Objects;

final class zzaq extends zzai {
    final zzar zza;

    zzaq(zzar zzar0) {
        this.zza = zzar0;
        super();
    }

    @Override
    public final Object get(int v) {
        zzaa.zza(v, this.zza.zzc, "index");
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(this.zza.zzb[v + v]), Objects.requireNonNull(this.zza.zzb[v * 2 + 1]));
    }

    @Override
    public final int size() {
        return this.zza.zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final boolean zzf() {
        return true;
    }
}

