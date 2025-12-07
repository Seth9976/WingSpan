package com.google.android.gms.internal.drive;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zziw extends AbstractList implements zzkp {
    private boolean zznh;

    zziw() {
        this.zznh = true;
    }

    @Override
    public void add(int v, Object object0) {
        this.zzbq();
        super.add(v, object0);
    }

    @Override
    public boolean add(Object object0) {
        this.zzbq();
        return super.add(object0);
    }

    @Override
    public boolean addAll(int v, Collection collection0) {
        this.zzbq();
        return super.addAll(v, collection0);
    }

    @Override
    public boolean addAll(Collection collection0) {
        this.zzbq();
        return super.addAll(collection0);
    }

    @Override
    public void clear() {
        this.zzbq();
        super.clear();
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof List)) {
            return false;
        }
        if(!(object0 instanceof RandomAccess)) {
            return super.equals(object0);
        }
        int v = this.size();
        if(v != ((List)object0).size()) {
            return false;
        }
        for(int v1 = 0; v1 < v; ++v1) {
            if(!this.get(v1).equals(((List)object0).get(v1))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int v = this.size();
        int v1 = 1;
        for(int v2 = 0; v2 < v; ++v2) {
            v1 = v1 * 0x1F + this.get(v2).hashCode();
        }
        return v1;
    }

    @Override
    public Object remove(int v) {
        this.zzbq();
        return super.remove(v);
    }

    @Override
    public boolean remove(Object object0) {
        this.zzbq();
        return super.remove(object0);
    }

    @Override
    public boolean removeAll(Collection collection0) {
        this.zzbq();
        return super.removeAll(collection0);
    }

    @Override
    public boolean retainAll(Collection collection0) {
        this.zzbq();
        return super.retainAll(collection0);
    }

    @Override
    public Object set(int v, Object object0) {
        this.zzbq();
        return super.set(v, object0);
    }

    @Override  // com.google.android.gms.internal.drive.zzkp
    public boolean zzbo() {
        return this.zznh;
    }

    @Override  // com.google.android.gms.internal.drive.zzkp
    public final void zzbp() {
        this.zznh = false;
    }

    protected final void zzbq() {
        if(!this.zznh) {
            throw new UnsupportedOperationException();
        }
    }
}

