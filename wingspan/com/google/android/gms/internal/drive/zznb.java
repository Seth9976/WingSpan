package com.google.android.gms.internal.drive;

import java.util.ListIterator;

final class zznb implements ListIterator {
    private ListIterator zzvu;
    private final int zzvv;
    private final zzna zzvw;

    zznb(zzna zzna0, int v) {
        this.zzvw = zzna0;
        this.zzvv = v;
        super();
        this.zzvu = zzna0.zzvt.listIterator(v);
    }

    @Override
    public final void add(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean hasNext() {
        return this.zzvu.hasNext();
    }

    @Override
    public final boolean hasPrevious() {
        return this.zzvu.hasPrevious();
    }

    @Override
    public final Object next() {
        return (String)this.zzvu.next();
    }

    @Override
    public final int nextIndex() {
        return this.zzvu.nextIndex();
    }

    @Override
    public final Object previous() {
        return (String)this.zzvu.previous();
    }

    @Override
    public final int previousIndex() {
        return this.zzvu.previousIndex();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void set(Object object0) {
        throw new UnsupportedOperationException();
    }
}

