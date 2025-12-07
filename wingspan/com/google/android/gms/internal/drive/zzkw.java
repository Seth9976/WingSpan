package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzkw implements Iterator {
    private Iterator zztg;

    public zzkw(Iterator iterator0) {
        this.zztg = iterator0;
    }

    @Override
    public final boolean hasNext() {
        return this.zztg.hasNext();
    }

    @Override
    public final Object next() {
        Object object0 = this.zztg.next();
        return ((Map.Entry)object0).getValue() instanceof zzkt ? new zzkv(((Map.Entry)object0), null) : ((Map.Entry)object0);
    }

    @Override
    public final void remove() {
        this.zztg.remove();
    }
}

