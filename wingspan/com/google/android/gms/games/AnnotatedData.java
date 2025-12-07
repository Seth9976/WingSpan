package com.google.android.gms.games;

public class AnnotatedData {
    private final Object zza;
    private final boolean zzb;

    public AnnotatedData(Object object0, boolean z) {
        this.zza = object0;
        this.zzb = z;
    }

    public Object get() {
        return this.zza;
    }

    public boolean isStale() {
        return this.zzb;
    }
}

