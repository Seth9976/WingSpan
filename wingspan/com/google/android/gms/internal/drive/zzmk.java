package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzmk implements Iterator {
    private int pos;
    private Iterator zzvj;
    private final zzmi zzvk;

    private zzmk(zzmi zzmi0) {
        this.zzvk = zzmi0;
        super();
        this.pos = zzmi0.zzve.size();
    }

    zzmk(zzmi zzmi0, zzmj zzmj0) {
        this(zzmi0);
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean hasNext() {
        return this.pos > 0 && this.pos <= this.zzvk.zzve.size() || this.zzew().hasNext();
    }

    @Override
    public final Object next() {
        if(this.zzew().hasNext()) {
            return this.zzew().next();
        }
        int v = this.pos - 1;
        this.pos = v;
        return (Map.Entry)this.zzvk.zzve.get(v);
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator zzew() {
        if(this.zzvj == null) {
            this.zzvj = this.zzvk.zzvh.entrySet().iterator();
        }
        return this.zzvj;
    }
}

