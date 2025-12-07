package com.google.android.gms.internal.drive;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzmr extends AbstractSet {
    private final zzmi zzvk;

    private zzmr(zzmi zzmi0) {
        this.zzvk = zzmi0;
        super();
    }

    zzmr(zzmi zzmi0, zzmj zzmj0) {
        this(zzmi0);
    }

    @Override
    public boolean add(Object object0) {
        if(!this.contains(((Map.Entry)object0))) {
            Comparable comparable0 = (Comparable)((Map.Entry)object0).getKey();
            Object object1 = ((Map.Entry)object0).getValue();
            this.zzvk.zza(comparable0, object1);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        this.zzvk.clear();
    }

    @Override
    public boolean contains(Object object0) {
        Object object1 = ((Map.Entry)object0).getKey();
        Object object2 = this.zzvk.get(object1);
        Object object3 = ((Map.Entry)object0).getValue();
        return object2 == object3 || object2 != null && object2.equals(object3);
    }

    @Override
    public Iterator iterator() {
        return new zzmq(this.zzvk, null);
    }

    @Override
    public boolean remove(Object object0) {
        if(this.contains(((Map.Entry)object0))) {
            Object object1 = ((Map.Entry)object0).getKey();
            this.zzvk.remove(object1);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.zzvk.size();
    }
}

