package com.google.android.gms.internal.drive;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzna extends AbstractList implements zzkz, RandomAccess {
    private final zzkz zzvt;

    public zzna(zzkz zzkz0) {
        this.zzvt = zzkz0;
    }

    @Override
    public final Object get(int v) {
        return (String)this.zzvt.get(v);
    }

    @Override
    public final Iterator iterator() {
        return new zznc(this);
    }

    @Override
    public final ListIterator listIterator(int v) {
        return new zznb(this, v);
    }

    @Override
    public final int size() {
        return this.zzvt.size();
    }

    @Override  // com.google.android.gms.internal.drive.zzkz
    public final Object zzao(int v) {
        return this.zzvt.zzao(v);
    }

    @Override  // com.google.android.gms.internal.drive.zzkz
    public final List zzdr() {
        return this.zzvt.zzdr();
    }

    @Override  // com.google.android.gms.internal.drive.zzkz
    public final zzkz zzds() {
        return this;
    }
}

