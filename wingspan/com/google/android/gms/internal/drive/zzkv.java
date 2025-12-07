package com.google.android.gms.internal.drive;

import java.util.Map.Entry;

final class zzkv implements Map.Entry {
    private Map.Entry zztf;

    private zzkv(Map.Entry map$Entry0) {
        this.zztf = map$Entry0;
    }

    zzkv(Map.Entry map$Entry0, zzku zzku0) {
        this(map$Entry0);
    }

    @Override
    public final Object getKey() {
        return this.zztf.getKey();
    }

    @Override
    public final Object getValue() {
        return ((zzkt)this.zztf.getValue()) == null ? null : zzkt.zzdp();
    }

    @Override
    public final Object setValue(Object object0) {
        if(!(object0 instanceof zzlq)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return ((zzkt)this.zztf.getValue()).zzi(((zzlq)object0));
    }

    public final zzkt zzdq() {
        return (zzkt)this.zztf.getValue();
    }
}

