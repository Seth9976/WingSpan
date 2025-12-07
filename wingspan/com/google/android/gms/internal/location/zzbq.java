package com.google.android.gms.internal.location;

final class zzbq extends zzbo {
    private final zzbs zza;

    zzbq(zzbs zzbs0, int v) {
        super(zzbs0.size(), v);
        this.zza = zzbs0;
    }

    @Override  // com.google.android.gms.internal.location.zzbo
    protected final Object zza(int v) {
        return this.zza.get(v);
    }
}

