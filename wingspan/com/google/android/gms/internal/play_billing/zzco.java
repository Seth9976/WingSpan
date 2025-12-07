package com.google.android.gms.internal.play_billing;

final class zzco {
    private final Object zza;
    private final int zzb;

    zzco(Object object0, int v) {
        this.zza = object0;
        this.zzb = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzco ? this.zza == ((zzco)object0).zza && this.zzb == ((zzco)object0).zzb : false;
    }

    @Override
    public final int hashCode() {
        return System.identityHashCode(this.zza) * 0xFFFF + this.zzb;
    }
}

