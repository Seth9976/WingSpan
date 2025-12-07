package com.google.android.gms.internal.play_billing;

import java.util.List;
import javax.annotation.CheckForNull;

final class zzah extends zzai {
    final transient int zza;
    final transient int zzb;
    final zzai zzc;

    zzah(zzai zzai0, int v, int v1) {
        this.zzc = zzai0;
        super();
        this.zza = v;
        this.zzb = v1;
    }

    @Override
    public final Object get(int v) {
        zzaa.zza(v, this.zzb, "index");
        return this.zzc.get(v + this.zza);
    }

    @Override
    public final int size() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzai
    public final List subList(int v, int v1) {
        return this.zzh(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    final boolean zzf() {
        return true;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    @CheckForNull
    final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzai
    public final zzai zzh(int v, int v1) {
        zzaa.zzd(v, v1, this.zzb);
        return this.zzc.zzh(v + this.zza, v1 + this.zza);
    }
}

