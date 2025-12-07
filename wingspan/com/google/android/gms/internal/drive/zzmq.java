package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzmq implements Iterator {
    private int pos;
    private Iterator zzvj;
    private final zzmi zzvk;
    private boolean zzvo;

    private zzmq(zzmi zzmi0) {
        this.zzvk = zzmi0;
        super();
        this.pos = -1;
    }

    zzmq(zzmi zzmi0, zzmj zzmj0) {
        this(zzmi0);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean hasNext() {
        return this.pos + 1 < this.zzvk.zzve.size() || !this.zzvk.zzvf.isEmpty() && this.zzew().hasNext();
    }

    @Override
    public final Object next() {
        this.zzvo = true;
        int v = this.pos + 1;
        this.pos = v;
        return v < this.zzvk.zzve.size() ? ((Map.Entry)this.zzvk.zzve.get(this.pos)) : this.zzew().next();
    }

    @Override
    public final void remove() {
        if(!this.zzvo) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzvo = false;
        this.zzvk.zzeu();
        if(this.pos < this.zzvk.zzve.size()) {
            int v = this.pos;
            this.pos = v - 1;
            this.zzvk.zzax(v);
            return;
        }
        this.zzew().remove();
    }

    private final Iterator zzew() {
        if(this.zzvj == null) {
            this.zzvj = this.zzvk.zzvf.entrySet().iterator();
        }
        return this.zzvj;
    }
}

