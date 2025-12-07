package com.google.android.gms.internal.drive;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzmi extends AbstractMap {
    private boolean zzot;
    private final int zzvd;
    private List zzve;
    private Map zzvf;
    private volatile zzmr zzvg;
    private Map zzvh;
    private volatile zzml zzvi;

    private zzmi(int v) {
        this.zzvd = v;
        this.zzve = Collections.emptyList();
        this.zzvf = Collections.emptyMap();
        this.zzvh = Collections.emptyMap();
    }

    zzmi(int v, zzmj zzmj0) {
        this(v);
    }

    @Override
    public void clear() {
        this.zzeu();
        if(!this.zzve.isEmpty()) {
            this.zzve.clear();
        }
        if(!this.zzvf.isEmpty()) {
            this.zzvf.clear();
        }
    }

    @Override
    public boolean containsKey(Object object0) {
        return this.zza(((Comparable)object0)) >= 0 || this.zzvf.containsKey(((Comparable)object0));
    }

    @Override
    public Set entrySet() {
        if(this.zzvg == null) {
            this.zzvg = new zzmr(this, null);
        }
        return this.zzvg;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzmi)) {
            return super.equals(object0);
        }
        int v = this.size();
        if(v != ((zzmi)object0).size()) {
            return false;
        }
        int v1 = this.zzer();
        if(v1 != ((zzmi)object0).zzer()) {
            return this.entrySet().equals(((zzmi)object0).entrySet());
        }
        for(int v2 = 0; v2 < v1; ++v2) {
            if(!this.zzaw(v2).equals(((zzmi)object0).zzaw(v2))) {
                return false;
            }
        }
        return v1 == v ? true : this.zzvf.equals(((zzmi)object0).zzvf);
    }

    @Override
    public Object get(Object object0) {
        int v = this.zza(((Comparable)object0));
        return v < 0 ? this.zzvf.get(((Comparable)object0)) : ((zzmp)this.zzve.get(v)).getValue();
    }

    @Override
    public int hashCode() {
        int v = this.zzer();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += ((zzmp)this.zzve.get(v1)).hashCode();
        }
        return this.zzvf.size() <= 0 ? v2 : v2 + this.zzvf.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzot;
    }

    @Override
    public Object put(Object object0, Object object1) {
        return this.zza(((Comparable)object0), object1);
    }

    @Override
    public Object remove(Object object0) {
        this.zzeu();
        int v = this.zza(((Comparable)object0));
        if(v >= 0) {
            return this.zzax(v);
        }
        return this.zzvf.isEmpty() ? null : this.zzvf.remove(((Comparable)object0));
    }

    @Override
    public int size() {
        return this.zzve.size() + this.zzvf.size();
    }

    private final int zza(Comparable comparable0) {
        int v = this.zzve.size() - 1;
        if(v >= 0) {
            int v1 = comparable0.compareTo(((Comparable)((zzmp)this.zzve.get(v)).getKey()));
            if(v1 > 0) {
                return -(v + 2);
            }
            if(v1 == 0) {
                return v;
            }
        }
        int v2 = 0;
        while(v2 <= v) {
            int v3 = (v2 + v) / 2;
            int v4 = comparable0.compareTo(((Comparable)((zzmp)this.zzve.get(v3)).getKey()));
            if(v4 < 0) {
                v = v3 - 1;
                continue;
            }
            if(v4 > 0) {
                v2 = v3 + 1;
                continue;
            }
            return v3;
        }
        return -(v2 + 1);
    }

    public final Object zza(Comparable comparable0, Object object0) {
        this.zzeu();
        int v = this.zza(comparable0);
        if(v >= 0) {
            return ((zzmp)this.zzve.get(v)).setValue(object0);
        }
        this.zzeu();
        if(this.zzve.isEmpty() && !(this.zzve instanceof ArrayList)) {
            this.zzve = new ArrayList(this.zzvd);
        }
        if(-(v + 1) >= this.zzvd) {
            return this.zzev().put(comparable0, object0);
        }
        int v1 = this.zzvd;
        if(this.zzve.size() == v1) {
            zzmp zzmp0 = (zzmp)this.zzve.remove(v1 - 1);
            this.zzev().put(((Comparable)zzmp0.getKey()), zzmp0.getValue());
        }
        this.zzve.add(-(v + 1), new zzmp(this, comparable0, object0));
        return null;
    }

    static zzmi zzav(int v) {
        return new zzmj(v);
    }

    public final Map.Entry zzaw(int v) {
        return (Map.Entry)this.zzve.get(v);
    }

    private final Object zzax(int v) {
        this.zzeu();
        Object object0 = ((zzmp)this.zzve.remove(v)).getValue();
        if(!this.zzvf.isEmpty()) {
            Iterator iterator0 = this.zzev().entrySet().iterator();
            List list0 = this.zzve;
            Object object1 = iterator0.next();
            list0.add(new zzmp(this, ((Map.Entry)object1)));
            iterator0.remove();
        }
        return object0;
    }

    public void zzbp() {
        if(!this.zzot) {
            this.zzvf = this.zzvf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzvf);
            this.zzvh = this.zzvh.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzvh);
            this.zzot = true;
        }
    }

    public final int zzer() {
        return this.zzve.size();
    }

    public final Iterable zzes() {
        return this.zzvf.isEmpty() ? zzmm.zzex() : this.zzvf.entrySet();
    }

    final Set zzet() {
        if(this.zzvi == null) {
            this.zzvi = new zzml(this, null);
        }
        return this.zzvi;
    }

    private final void zzeu() {
        if(this.zzot) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap zzev() {
        this.zzeu();
        if(this.zzvf.isEmpty() && !(this.zzvf instanceof TreeMap)) {
            TreeMap treeMap0 = new TreeMap();
            this.zzvf = treeMap0;
            this.zzvh = treeMap0.descendingMap();
        }
        return (SortedMap)this.zzvf;
    }
}

