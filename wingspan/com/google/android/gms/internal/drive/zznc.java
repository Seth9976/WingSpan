package com.google.android.gms.internal.drive;

import java.util.Iterator;

final class zznc implements Iterator {
    private final zzna zzvw;
    private Iterator zzvx;

    zznc(zzna zzna0) {
        this.zzvw = zzna0;
        super();
        this.zzvx = zzna0.zzvt.iterator();
    }

    @Override
    public final boolean hasNext() {
        return this.zzvx.hasNext();
    }

    @Override
    public final Object next() {
        return this.zzvx.next();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

