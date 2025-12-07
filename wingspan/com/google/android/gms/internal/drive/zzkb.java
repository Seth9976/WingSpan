package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzkb {
    final zzmi zzos;
    private boolean zzot;
    private boolean zzou;
    private static final zzkb zzov;

    static {
        zzkb.zzov = new zzkb(true);
    }

    private zzkb() {
        this.zzou = false;
        this.zzos = zzmi.zzav(16);
    }

    private zzkb(boolean z) {
        this.zzou = false;
        this.zzos = zzmi.zzav(0);
        this.zzbp();
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        zzkb zzkb0 = new zzkb();
        for(int v = 0; v < this.zzos.zzer(); ++v) {
            Map.Entry map$Entry0 = this.zzos.zzaw(v);
            zzkb0.zza(((zzkd)map$Entry0.getKey()), map$Entry0.getValue());
        }
        for(Object object0: this.zzos.zzes()) {
            zzkb0.zza(((zzkd)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue());
        }
        zzkb0.zzou = this.zzou;
        return zzkb0;
    }

    final Iterator descendingIterator() {
        return this.zzou ? new zzkw(this.zzos.zzet().iterator()) : this.zzos.zzet().iterator();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzkb ? this.zzos.equals(((zzkb)object0).zzos) : false;
    }

    @Override
    public final int hashCode() {
        return this.zzos.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzot;
    }

    public final boolean isInitialized() {
        for(int v = 0; v < this.zzos.zzer(); ++v) {
            if(!zzkb.zzb(this.zzos.zzaw(v))) {
                return false;
            }
        }
        for(Object object0: this.zzos.zzes()) {
            if(!zzkb.zzb(((Map.Entry)object0))) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    public final Iterator iterator() {
        return this.zzou ? new zzkw(this.zzos.entrySet().iterator()) : this.zzos.entrySet().iterator();
    }

    static int zza(zznm zznm0, int v, Object object0) {
        int v1 = zzjr.zzab(v);
        if(zznm0 == zznm.zzxd) {
            zzlq zzlq0 = (zzlq)object0;
            v1 <<= 1;
        }
        return v1 + zzkb.zzb(zznm0, object0);
    }

    private final Object zza(zzkd zzkd0) {
        zzlq zzlq0 = this.zzos.get(zzkd0);
        return zzlq0 instanceof zzkt ? zzkt.zzdp() : zzlq0;
    }

    static void zza(zzjr zzjr0, zznm zznm0, int v, Object object0) throws IOException {
        if(zznm0 == zznm.zzxd) {
            zzjr0.zzb(v, 3);
            ((zzlq)object0).zzb(zzjr0);
            zzjr0.zzb(v, 4);
            return;
        }
        zzjr0.zzb(v, zznm0.zzfk());
        switch(zznm0) {
            case 1: {
                zzjr0.zza(((double)(((Double)object0))));
                return;
            }
            case 2: {
                zzjr0.zza(((float)(((Float)object0))));
                return;
            }
            case 3: {
                zzjr0.zzl(((long)(((Long)object0))));
                return;
            }
            case 4: {
                zzjr0.zzl(((long)(((Long)object0))));
                return;
            }
            case 5: {
                zzjr0.zzx(((int)(((Integer)object0))));
                return;
            }
            case 6: {
                zzjr0.zzn(((long)(((Long)object0))));
                return;
            }
            case 7: {
                zzjr0.zzaa(((int)(((Integer)object0))));
                return;
            }
            case 8: {
                zzjr0.zzc(((Boolean)object0).booleanValue());
                return;
            }
            case 9: {
                ((zzlq)object0).zzb(zzjr0);
                return;
            }
            case 10: {
                zzjr0.zzb(((zzlq)object0));
                return;
            }
            case 11: {
                if(object0 instanceof zzjc) {
                    zzjr0.zza(((zzjc)object0));
                    return;
                }
                zzjr0.zzl(((String)object0));
                return;
            }
            case 12: {
                if(object0 instanceof zzjc) {
                    zzjr0.zza(((zzjc)object0));
                    return;
                }
                zzjr0.zzd(((byte[])object0), 0, ((byte[])object0).length);
                return;
            }
            case 13: {
                zzjr0.zzy(((int)(((Integer)object0))));
                return;
            }
            case 14: {
                zzjr0.zzaa(((int)(((Integer)object0))));
                return;
            }
            case 15: {
                zzjr0.zzn(((long)(((Long)object0))));
                return;
            }
            case 16: {
                zzjr0.zzz(((int)(((Integer)object0))));
                return;
            }
            case 17: {
                zzjr0.zzm(((long)(((Long)object0))));
                return;
            }
            case 18: {
                if(object0 instanceof zzkn) {
                    zzjr0.zzx(((zzkn)object0).zzcp());
                    return;
                }
                zzjr0.zzx(((int)(((Integer)object0))));
            }
        }
    }

    private final void zza(zzkd zzkd0, Object object0) {
        if(zzkd0.zzcs()) {
            if(!(object0 instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList0 = new ArrayList();
            arrayList0.addAll(((List)object0));
            int v = arrayList0.size();
            int v1 = 0;
            while(v1 < v) {
                Object object1 = arrayList0.get(v1);
                ++v1;
                zzkb.zza(zzkd0.zzcq(), object1);
            }
            object0 = arrayList0;
        }
        else {
            zzkb.zza(zzkd0.zzcq(), object0);
        }
        if(object0 instanceof zzkt) {
            this.zzou = true;
        }
        this.zzos.zza(zzkd0, object0);
    }

    private static void zza(zznm zznm0, Object object0) {
        zzkm.checkNotNull(object0);
        boolean z = true;
        boolean z1 = false;
        switch(zznm0.zzfj()) {
            case 1: {
                z1 = object0 instanceof Integer;
                break;
            }
            case 2: {
                z1 = object0 instanceof Long;
                break;
            }
            case 3: {
                z1 = object0 instanceof Float;
                break;
            }
            case 4: {
                z1 = object0 instanceof Double;
                break;
            }
            case 5: {
                z1 = object0 instanceof Boolean;
                break;
            }
            case 6: {
                z1 = object0 instanceof String;
                break;
            }
            case 7: {
                if(!(object0 instanceof zzjc) && !(object0 instanceof byte[])) {
                    z = false;
                }
                z1 = z;
                break;
            }
            case 8: {
                if(!(object0 instanceof Integer) && !(object0 instanceof zzkn)) {
                    z = false;
                }
                z1 = z;
                break;
            }
            case 9: {
                if(!(object0 instanceof zzlq) && !(object0 instanceof zzkt)) {
                    z = false;
                }
                z1 = z;
            }
        }
        if(!z1) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final void zza(zzkb zzkb0) {
        for(int v = 0; v < zzkb0.zzos.zzer(); ++v) {
            this.zzc(zzkb0.zzos.zzaw(v));
        }
        for(Object object0: zzkb0.zzos.zzes()) {
            this.zzc(((Map.Entry)object0));
        }
    }

    public static int zzb(zzkd zzkd0, Object object0) {
        int v = 0;
        zznm zznm0 = zzkd0.zzcq();
        int v1 = zzkd0.zzcp();
        if(zzkd0.zzcs()) {
            if(zzkd0.zzct()) {
                for(Object object1: ((List)object0)) {
                    v += zzkb.zzb(zznm0, object1);
                }
                return zzjr.zzab(v1) + v + zzjr.zzaj(v);
            }
            for(Object object2: ((List)object0)) {
                v += zzkb.zza(zznm0, v1, object2);
            }
            return v;
        }
        return zzkb.zza(zznm0, v1, object0);
    }

    private static int zzb(zznm zznm0, Object object0) {
        switch(zzkc.zzox[zznm0.ordinal()]) {
            case 1: {
                return zzjr.zzb(((double)(((Double)object0))));
            }
            case 2: {
                return zzjr.zzb(((float)(((Float)object0))));
            }
            case 3: {
                return zzjr.zzo(((long)(((Long)object0))));
            }
            case 4: {
                return zzjr.zzp(((long)(((Long)object0))));
            }
            case 5: {
                return zzjr.zzac(((int)(((Integer)object0))));
            }
            case 6: {
                return zzjr.zzr(((long)(((Long)object0))));
            }
            case 7: {
                return zzjr.zzaf(((int)(((Integer)object0))));
            }
            case 8: {
                return zzjr.zzd(((Boolean)object0).booleanValue());
            }
            case 9: {
                return zzjr.zzd(((zzlq)object0));
            }
            case 10: {
                return object0 instanceof zzkt ? zzjr.zza(((zzkt)object0)) : zzjr.zzc(((zzlq)object0));
            }
            case 11: {
                return object0 instanceof zzjc ? zzjr.zzb(((zzjc)object0)) : zzjr.zzm(((String)object0));
            }
            case 12: {
                return object0 instanceof zzjc ? zzjr.zzb(((zzjc)object0)) : zzjr.zzc(((byte[])object0));
            }
            case 13: {
                return zzjr.zzad(((int)(((Integer)object0))));
            }
            case 14: {
                return zzjr.zzag(((int)(((Integer)object0))));
            }
            case 15: {
                return zzjr.zzs(((long)(((Long)object0))));
            }
            case 16: {
                return zzjr.zzae(((int)(((Integer)object0))));
            }
            case 17: {
                return zzjr.zzq(((long)(((Long)object0))));
            }
            case 18: {
                return object0 instanceof zzkn ? zzjr.zzah(((zzkn)object0).zzcp()) : zzjr.zzah(((int)(((Integer)object0))));
            }
            default: {
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
    }

    private static boolean zzb(Map.Entry map$Entry0) {
        zzkd zzkd0 = (zzkd)map$Entry0.getKey();
        if(zzkd0.zzcr() == zznr.zzxx) {
            if(zzkd0.zzcs()) {
                Iterator iterator0 = ((List)map$Entry0.getValue()).iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        return true;
                    }
                    Object object0 = iterator0.next();
                    if(((zzlq)object0).isInitialized()) {
                        continue;
                    }
                    return false;
                }
            }
            Object object1 = map$Entry0.getValue();
            if(object1 instanceof zzlq) {
                return ((zzlq)object1).isInitialized();
            }
            if(!(object1 instanceof zzkt)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            return true;
        }
        return true;
    }

    public final void zzbp() {
        if(this.zzot) {
            return;
        }
        this.zzos.zzbp();
        this.zzot = true;
    }

    private final void zzc(Map.Entry map$Entry0) {
        zzkd zzkd0 = (zzkd)map$Entry0.getKey();
        zzlq zzlq0 = map$Entry0.getValue();
        if(zzlq0 instanceof zzkt) {
            zzlq0 = zzkt.zzdp();
        }
        if(zzkd0.zzcs()) {
            ArrayList arrayList0 = this.zza(zzkd0);
            if(arrayList0 == null) {
                arrayList0 = new ArrayList();
            }
            for(Object object0: ((List)zzlq0)) {
                arrayList0.add(zzkb.zze(object0));
            }
            this.zzos.zza(zzkd0, arrayList0);
            return;
        }
        if(zzkd0.zzcr() == zznr.zzxx) {
            Object object1 = this.zza(zzkd0);
            if(object1 == null) {
                Object object2 = zzkb.zze(zzlq0);
                this.zzos.zza(zzkd0, object2);
                return;
            }
            zzlq zzlq1 = object1 instanceof zzlx ? zzkd0.zza(((zzlx)object1), ((zzlx)zzlq0)) : zzkd0.zza(((zzlq)object1).zzcy(), zzlq0).zzdf();
            this.zzos.zza(zzkd0, zzlq1);
            return;
        }
        Object object3 = zzkb.zze(zzlq0);
        this.zzos.zza(zzkd0, object3);
    }

    public static zzkb zzcn() {
        return zzkb.zzov;
    }

    public final int zzco() {
        int v1 = 0;
        for(int v = 0; v < this.zzos.zzer(); ++v) {
            v1 += zzkb.zzd(this.zzos.zzaw(v));
        }
        for(Object object0: this.zzos.zzes()) {
            v1 += zzkb.zzd(((Map.Entry)object0));
        }
        return v1;
    }

    private static int zzd(Map.Entry map$Entry0) {
        zzkd zzkd0 = (zzkd)map$Entry0.getKey();
        Object object0 = map$Entry0.getValue();
        if(zzkd0.zzcr() == zznr.zzxx && !zzkd0.zzcs() && !zzkd0.zzct()) {
            return object0 instanceof zzkt ? zzjr.zzb(((zzkd)map$Entry0.getKey()).zzcp(), ((zzkt)object0)) : zzjr.zzb(((zzkd)map$Entry0.getKey()).zzcp(), ((zzlq)object0));
        }
        return zzkb.zzb(zzkd0, object0);
    }

    private static Object zze(Object object0) {
        if(object0 instanceof zzlx) {
            return ((zzlx)object0).zzef();
        }
        if(object0 instanceof byte[]) {
            byte[] arr_b = new byte[((byte[])object0).length];
            System.arraycopy(((byte[])object0), 0, arr_b, 0, ((byte[])object0).length);
            return arr_b;
        }
        return object0;
    }
}

