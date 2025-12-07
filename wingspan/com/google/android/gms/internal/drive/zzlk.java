package com.google.android.gms.internal.drive;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public final class zzlk extends LinkedHashMap {
    private boolean zznh;
    private static final zzlk zzty;

    static {
        zzlk zzlk0 = new zzlk();
        zzlk.zzty = zzlk0;
        zzlk0.zznh = false;
    }

    private zzlk() {
        this.zznh = true;
    }

    private zzlk(Map map0) {
        super(map0);
        this.zznh = true;
    }

    @Override
    public final void clear() {
        this.zzdy();
        super.clear();
    }

    // 去混淆评级： 低(20)
    @Override
    public final Set entrySet() {
        return this.isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 instanceof Map) {
            if(this != ((Map)object0)) {
                if(this.size() == ((Map)object0).size()) {
                    Iterator iterator0 = this.entrySet().iterator();
                    while(true) {
                        if(!iterator0.hasNext()) {
                            return true;
                        }
                        Object object1 = iterator0.next();
                        if(!((Map)object0).containsKey(((Map.Entry)object1).getKey())) {
                            break;
                        }
                        Object object2 = ((Map.Entry)object1).getValue();
                        Object object3 = ((Map)object0).get(((Map.Entry)object1).getKey());
                        if((!(object2 instanceof byte[]) || !(object3 instanceof byte[]) ? object2.equals(object3) : Arrays.equals(((byte[])object2), ((byte[])object3)))) {
                            continue;
                        }
                        return false;
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        for(Object object0: this.entrySet()) {
            int v1 = zzlk.zzg(((Map.Entry)object0).getKey());
            v += zzlk.zzg(((Map.Entry)object0).getValue()) ^ v1;
        }
        return v;
    }

    public final boolean isMutable() {
        return this.zznh;
    }

    @Override
    public final Object put(Object object0, Object object1) {
        this.zzdy();
        zzkm.checkNotNull(object0);
        zzkm.checkNotNull(object1);
        return super.put(object0, object1);
    }

    @Override
    public final void putAll(Map map0) {
        this.zzdy();
        for(Object object0: map0.keySet()) {
            zzkm.checkNotNull(object0);
            zzkm.checkNotNull(map0.get(object0));
        }
        super.putAll(map0);
    }

    @Override
    public final Object remove(Object object0) {
        this.zzdy();
        return super.remove(object0);
    }

    public final void zza(zzlk zzlk0) {
        this.zzdy();
        if(!zzlk0.isEmpty()) {
            this.putAll(zzlk0);
        }
    }

    public final void zzbp() {
        this.zznh = false;
    }

    public static zzlk zzdw() {
        return zzlk.zzty;
    }

    // 去混淆评级： 低(20)
    public final zzlk zzdx() {
        return this.isEmpty() ? new zzlk() : new zzlk(this);
    }

    private final void zzdy() {
        if(!this.zznh) {
            throw new UnsupportedOperationException();
        }
    }

    private static int zzg(Object object0) {
        if(object0 instanceof byte[]) {
            return zzkm.hashCode(((byte[])object0));
        }
        if(object0 instanceof zzkn) {
            throw new UnsupportedOperationException();
        }
        return object0.hashCode();
    }
}

