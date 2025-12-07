package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

final class zzfq implements Iterator {
    final Iterator zza;
    final zzfr zzb;

    zzfq(zzfr zzfr0) {
        this.zzb = zzfr0;
        super();
        this.zza = zzfr0.zza.iterator();
    }

    @Override
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override
    public final Object next() {
        return this.zza.next();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

