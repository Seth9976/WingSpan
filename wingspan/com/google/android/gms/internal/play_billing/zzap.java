package com.google.android.gms.internal.play_billing;

import java.util.Objects;

final class zzap extends zzai {
    static final zzai zza;
    final transient Object[] zzb;
    private final transient int zzc;

    static {
        zzap.zza = new zzap(new Object[0], 0);
    }

    zzap(Object[] arr_object, int v) {
        this.zzb = arr_object;
        this.zzc = v;
    }

    @Override
    public final Object get(int v) {
        zzaa.zza(v, this.zzc, "index");
        return Objects.requireNonNull(this.zzb[v]);
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzai
    final int zza(Object[] arr_object, int v) {
        System.arraycopy(this.zzb, 0, arr_object, 0, this.zzc);
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    final int zzb() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    final int zzc() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    final boolean zzf() {
        return false;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    final Object[] zzg() {
        return this.zzb;
    }
}

