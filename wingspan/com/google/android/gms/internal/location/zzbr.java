package com.google.android.gms.internal.location;

import java.util.List;

final class zzbr extends zzbs {
    final transient int zza;
    final transient int zzb;
    final zzbs zzc;

    zzbr(zzbs zzbs0, int v, int v1) {
        this.zzc = zzbs0;
        super();
        this.zza = v;
        this.zzb = v1;
    }

    @Override
    public final Object get(int v) {
        zzbm.zza(v, this.zzb, "index");
        return this.zzc.get(v + this.zza);
    }

    @Override
    public final int size() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.internal.location.zzbs
    public final List subList(int v, int v1) {
        return this.zzh(v, v1);
    }

    @Override  // com.google.android.gms.internal.location.zzbp
    final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override  // com.google.android.gms.internal.location.zzbp
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override  // com.google.android.gms.internal.location.zzbp
    final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override  // com.google.android.gms.internal.location.zzbp
    final boolean zzf() {
        return true;
    }

    @Override  // com.google.android.gms.internal.location.zzbs
    public final zzbs zzh(int v, int v1) {
        zzbm.zzc(v, v1, this.zzb);
        return this.zzc.zzh(v + this.zza, v1 + this.zza);
    }
}

