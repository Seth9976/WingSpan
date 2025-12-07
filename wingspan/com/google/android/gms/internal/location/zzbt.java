package com.google.android.gms.internal.location;

final class zzbt extends zzbs {
    static final zzbs zza;
    final transient Object[] zzb;
    private final transient int zzc;

    static {
        zzbt.zza = new zzbt(new Object[0], 0);
    }

    zzbt(Object[] arr_object, int v) {
        this.zzb = arr_object;
        this.zzc = v;
    }

    @Override
    public final Object get(int v) {
        zzbm.zza(v, this.zzc, "index");
        return this.zzb[v];
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.location.zzbp
    final Object[] zzb() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.internal.location.zzbp
    final int zzc() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.location.zzbp
    final int zzd() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.location.zzbp
    final boolean zzf() {
        return false;
    }

    @Override  // com.google.android.gms.internal.location.zzbs
    final int zzg(Object[] arr_object, int v) {
        System.arraycopy(this.zzb, 0, arr_object, 0, this.zzc);
        return this.zzc;
    }
}

