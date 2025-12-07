package com.google.android.gms.internal.drive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzky extends zziw implements zzkz, RandomAccess {
    private final List zziu;
    private static final zzky zztk;
    private static final zzkz zztl;

    static {
        zzky zzky0 = new zzky();
        zzky.zztk = zzky0;
        zzky0.zzbp();
        zzky.zztl = zzky0;
    }

    public zzky() {
        this(10);
    }

    public zzky(int v) {
        this(new ArrayList(v));
    }

    private zzky(ArrayList arrayList0) {
        this.zziu = arrayList0;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final void add(int v, Object object0) {
        this.zzbq();
        this.zziu.add(v, ((String)object0));
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean addAll(int v, Collection collection0) {
        this.zzbq();
        if(collection0 instanceof zzkz) {
            collection0 = ((zzkz)collection0).zzdr();
        }
        boolean z = this.zziu.addAll(v, collection0);
        ++this.modCount;
        return z;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean addAll(Collection collection0) {
        return this.addAll(this.size(), collection0);
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final void clear() {
        this.zzbq();
        this.zziu.clear();
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean equals(Object object0) {
        return super.equals(object0);
    }

    @Override
    public final Object get(int v) {
        Object object0 = this.zziu.get(v);
        if(object0 instanceof String) {
            return (String)object0;
        }
        if(object0 instanceof zzjc) {
            String s = ((zzjc)object0).zzbt();
            if(((zzjc)object0).zzbu()) {
                this.zziu.set(v, s);
            }
            return s;
        }
        String s1 = zzkm.zze(((byte[])object0));
        if(zzkm.zzd(((byte[])object0))) {
            this.zziu.set(v, s1);
        }
        return s1;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final int hashCode() {
        return super.hashCode();
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final Object remove(int v) {
        this.zzbq();
        Object object0 = this.zziu.remove(v);
        ++this.modCount;
        return zzky.zzf(object0);
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean remove(Object object0) {
        return super.remove(object0);
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean removeAll(Collection collection0) {
        return super.removeAll(collection0);
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean retainAll(Collection collection0) {
        return super.retainAll(collection0);
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final Object set(int v, Object object0) {
        this.zzbq();
        return zzky.zzf(this.zziu.set(v, ((String)object0)));
    }

    @Override
    public final int size() {
        return this.zziu.size();
    }

    @Override  // com.google.android.gms.internal.drive.zzkz
    public final Object zzao(int v) {
        return this.zziu.get(v);
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean zzbo() {
        return super.zzbo();
    }

    @Override  // com.google.android.gms.internal.drive.zzkz
    public final List zzdr() {
        return Collections.unmodifiableList(this.zziu);
    }

    @Override  // com.google.android.gms.internal.drive.zzkz
    public final zzkz zzds() {
        return this.zzbo() ? new zzna(this) : this;
    }

    private static String zzf(Object object0) {
        if(object0 instanceof String) {
            return (String)object0;
        }
        return object0 instanceof zzjc ? ((zzjc)object0).zzbt() : zzkm.zze(((byte[])object0));
    }

    @Override  // com.google.android.gms.internal.drive.zzkp
    public final zzkp zzr(int v) {
        if(v < this.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList0 = new ArrayList(v);
        arrayList0.addAll(this.zziu);
        return new zzky(arrayList0);
    }
}

