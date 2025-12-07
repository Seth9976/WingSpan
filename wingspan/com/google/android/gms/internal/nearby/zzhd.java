package com.google.android.gms.internal.nearby;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzhd {
    private final Map map;

    public zzhd() {
        this.map = new WeakHashMap();
    }

    public final void clear() {
        this.map.clear();
    }

    public final boolean containsKey(Object object0) {
        return this.get(object0) != null;
    }

    public final Object get(Object object0) {
        WeakReference weakReference0 = (WeakReference)this.map.get(object0);
        return weakReference0 == null ? null : weakReference0.get();
    }

    public final void remove(Object object0) {
        this.map.remove(object0);
    }

    public final void zza(Object object0, Object object1) {
        WeakReference weakReference0 = new WeakReference(object1);
        this.map.put(object0, weakReference0);
    }
}

