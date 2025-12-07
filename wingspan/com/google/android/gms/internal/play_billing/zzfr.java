package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
public final class zzfr extends AbstractList implements zzds, RandomAccess {
    private final zzds zza;

    public zzfr(zzds zzds0) {
        this.zza = zzds0;
    }

    @Override
    public final Object get(int v) {
        return ((zzdr)this.zza).zzg(v);
    }

    @Override
    public final Iterator iterator() {
        return new zzfq(this);
    }

    @Override
    public final ListIterator listIterator(int v) {
        return new zzfp(this, v);
    }

    @Override
    public final int size() {
        return this.zza.size();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzds
    public final zzds zze() {
        return this;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzds
    public final Object zzf(int v) {
        return this.zza.zzf(v);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzds
    public final List zzh() {
        return this.zza.zzh();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzds
    public final void zzi(zzcc zzcc0) {
        throw new UnsupportedOperationException();
    }
}

