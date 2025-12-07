package com.google.android.gms.internal.play_billing;

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

class zzfi extends AbstractMap {
    private final int zza;
    private List zzb;
    private Map zzc;
    private boolean zzd;
    private volatile zzfg zze;
    private Map zzf;

    zzfi(int v, zzfh zzfh0) {
        this.zza = v;
        this.zzb = Collections.emptyList();
        this.zzc = Collections.emptyMap();
        this.zzf = Collections.emptyMap();
    }

    @Override
    public final void clear() {
        this.zzn();
        if(!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if(!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    @Override
    public final boolean containsKey(Object object0) {
        return this.zzk(((Comparable)object0)) >= 0 || this.zzc.containsKey(((Comparable)object0));
    }

    @Override
    public final Set entrySet() {
        if(this.zze == null) {
            this.zze = new zzfg(this, null);
        }
        return this.zze;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzfi)) {
            return super.equals(object0);
        }
        int v = this.size();
        if(v != ((zzfi)object0).size()) {
            return false;
        }
        int v1 = this.zzb();
        if(v1 == ((zzfi)object0).zzb()) {
            for(int v2 = 0; v2 < v1; ++v2) {
                if(!this.zzg(v2).equals(((zzfi)object0).zzg(v2))) {
                    return false;
                }
            }
            return v1 == v ? true : this.zzc.equals(((zzfi)object0).zzc);
        }
        return this.entrySet().equals(((zzfi)object0).entrySet());
    }

    @Override
    public final Object get(Object object0) {
        int v = this.zzk(((Comparable)object0));
        return v < 0 ? this.zzc.get(((Comparable)object0)) : ((zzfc)this.zzb.get(v)).getValue();
    }

    @Override
    public final int hashCode() {
        int v = this.zzb();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += ((zzfc)this.zzb.get(v1)).hashCode();
        }
        return this.zzc.size() <= 0 ? v2 : v2 + this.zzc.hashCode();
    }

    @Override
    public final Object put(Object object0, Object object1) {
        return this.zze(((Comparable)object0), object1);
    }

    @Override
    public final Object remove(Object object0) {
        this.zzn();
        int v = this.zzk(((Comparable)object0));
        if(v >= 0) {
            return this.zzl(v);
        }
        return this.zzc.isEmpty() ? null : this.zzc.remove(((Comparable)object0));
    }

    @Override
    public final int size() {
        return this.zzb.size() + this.zzc.size();
    }

    public void zza() {
        if(!this.zzd) {
            this.zzc = this.zzc.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzc);
            this.zzf = this.zzf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzf);
            this.zzd = true;
        }
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final Iterable zzc() {
        return this.zzc.isEmpty() ? zzfb.zza() : this.zzc.entrySet();
    }

    public final Object zze(Comparable comparable0, Object object0) {
        this.zzn();
        int v = this.zzk(comparable0);
        if(v >= 0) {
            return ((zzfc)this.zzb.get(v)).setValue(object0);
        }
        this.zzn();
        if(this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        if(-(v + 1) >= this.zza) {
            return this.zzm().put(comparable0, object0);
        }
        int v1 = this.zza;
        if(this.zzb.size() == v1) {
            zzfc zzfc0 = (zzfc)this.zzb.remove(v1 - 1);
            this.zzm().put(zzfc0.zza(), zzfc0.getValue());
        }
        this.zzb.add(-(v + 1), new zzfc(this, comparable0, object0));
        return null;
    }

    public final Map.Entry zzg(int v) {
        return (Map.Entry)this.zzb.get(v);
    }

    public final boolean zzj() {
        return this.zzd;
    }

    private final int zzk(Comparable comparable0) {
        int v = this.zzb.size() - 1;
        int v1 = 0;
        if(v >= 0) {
            int v2 = comparable0.compareTo(((zzfc)this.zzb.get(v)).zza());
            if(v2 > 0) {
                return -(v + 2);
            }
            if(v2 == 0) {
                return v;
            }
        }
        while(v1 <= v) {
            int v3 = (v1 + v) / 2;
            int v4 = comparable0.compareTo(((zzfc)this.zzb.get(v3)).zza());
            if(v4 < 0) {
                v = v3 - 1;
                continue;
            }
            if(v4 > 0) {
                v1 = v3 + 1;
                continue;
            }
            return v3;
        }
        return -(v1 + 1);
    }

    private final Object zzl(int v) {
        this.zzn();
        Object object0 = ((zzfc)this.zzb.remove(v)).getValue();
        if(!this.zzc.isEmpty()) {
            Iterator iterator0 = this.zzm().entrySet().iterator();
            List list0 = this.zzb;
            Object object1 = iterator0.next();
            list0.add(new zzfc(this, ((Comparable)((Map.Entry)object1).getKey()), ((Map.Entry)object1).getValue()));
            iterator0.remove();
        }
        return object0;
    }

    private final SortedMap zzm() {
        this.zzn();
        if(this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap0 = new TreeMap();
            this.zzc = treeMap0;
            this.zzf = treeMap0.descendingMap();
        }
        return (SortedMap)this.zzc;
    }

    private final void zzn() {
        if(this.zzd) {
            throw new UnsupportedOperationException();
        }
    }
}

