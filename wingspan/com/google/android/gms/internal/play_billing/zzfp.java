package com.google.android.gms.internal.play_billing;

import java.util.ListIterator;

final class zzfp implements ListIterator {
    final ListIterator zza;
    final int zzb;
    final zzfr zzc;

    zzfp(zzfr zzfr0, int v) {
        this.zzb = v;
        this.zzc = zzfr0;
        super();
        this.zza = zzfr0.zza.listIterator(v);
    }

    @Override
    public final void add(Object object0) {
        String s = (String)object0;
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override
    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    @Override
    public final Object next() {
        return (String)this.zza.next();
    }

    @Override
    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    @Override
    public final Object previous() {
        return (String)this.zza.previous();
    }

    @Override
    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void set(Object object0) {
        String s = (String)object0;
        throw new UnsupportedOperationException();
    }
}

