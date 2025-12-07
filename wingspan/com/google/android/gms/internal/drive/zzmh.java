package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzmh {
    private static final Class zzuz;
    private static final zzmx zzva;
    private static final zzmx zzvb;
    private static final zzmx zzvc;

    static {
        zzmh.zzuz = zzmh.zzep();
        zzmh.zzva = zzmh.zzf(false);
        zzmh.zzvb = zzmh.zzf(true);
        zzmh.zzvc = new zzmz();
    }

    static int zza(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzle) {
            v2 = 0;
            while(v1 < v) {
                v2 += zzjr.zzo(((zzle)list0).getLong(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += zzjr.zzo(((long)(((Long)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    private static Object zza(int v, int v1, Object object0, zzmx zzmx0) {
        if(object0 == null) {
            object0 = zzmx0.zzez();
        }
        zzmx0.zza(object0, v, ((long)v1));
        return object0;
    }

    static Object zza(int v, List list0, zzko zzko0, Object object0, zzmx zzmx0) {
        if(zzko0 == null) {
            return object0;
        }
        if(list0 instanceof RandomAccess) {
            int v1 = list0.size();
            int v3 = 0;
            for(int v2 = 0; v2 < v1; ++v2) {
                int v4 = (int)(((Integer)list0.get(v2)));
                if(zzko0.zzan(v4)) {
                    if(v2 != v3) {
                        list0.set(v3, v4);
                    }
                    ++v3;
                }
                else {
                    object0 = zzmh.zza(v, v4, object0, zzmx0);
                }
            }
            if(v3 != v1) {
                list0.subList(v3, v1).clear();
                return object0;
            }
        }
        else {
            Iterator iterator0 = list0.iterator();
            while(iterator0.hasNext()) {
                Object object1 = iterator0.next();
                int v5 = (int)(((Integer)object1));
                if(!zzko0.zzan(v5)) {
                    object0 = zzmh.zza(v, v5, object0, zzmx0);
                    iterator0.remove();
                }
            }
        }
        return object0;
    }

    public static void zza(int v, List list0, zzns zzns0) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zza(v, list0);
        }
    }

    public static void zza(int v, List list0, zzns zzns0, zzmf zzmf0) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zza(v, list0, zzmf0);
        }
    }

    public static void zza(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzg(v, list0, z);
        }
    }

    static void zza(zzjy zzjy0, Object object0, Object object1) {
        zzkb zzkb0 = zzjy0.zzb(object1);
        if(!zzkb0.zzos.isEmpty()) {
            zzjy0.zzc(object0).zza(zzkb0);
        }
    }

    static void zza(zzll zzll0, Object object0, Object object1, long v) {
        zznd.zza(object0, v, zzll0.zzb(zznd.zzo(object0, v), zznd.zzo(object1, v)));
    }

    static void zza(zzmx zzmx0, Object object0, Object object1) {
        zzmx0.zze(object0, zzmx0.zzg(zzmx0.zzr(object0), zzmx0.zzr(object1)));
    }

    static int zzb(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzle) {
            v2 = 0;
            while(v1 < v) {
                v2 += zzjr.zzp(((zzle)list0).getLong(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += zzjr.zzp(((long)(((Long)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    public static void zzb(int v, List list0, zzns zzns0) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzb(v, list0);
        }
    }

    public static void zzb(int v, List list0, zzns zzns0, zzmf zzmf0) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzb(v, list0, zzmf0);
        }
    }

    public static void zzb(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzf(v, list0, z);
        }
    }

    // 去混淆评级： 低(20)
    static int zzc(int v, Object object0, zzmf zzmf0) {
        return object0 instanceof zzkx ? zzjr.zza(v, ((zzkx)object0)) : zzjr.zzb(v, ((zzlq)object0), zzmf0);
    }

    static int zzc(int v, List list0) {
        int v1 = list0.size();
        int v2 = 0;
        if(v1 == 0) {
            return 0;
        }
        int v3 = zzjr.zzab(v) * v1;
        if(list0 instanceof zzkz) {
            while(v2 < v1) {
                Object object0 = ((zzkz)list0).zzao(v2);
                v3 += (object0 instanceof zzjc ? zzjr.zzb(((zzjc)object0)) : zzjr.zzm(((String)object0)));
                ++v2;
            }
            return v3;
        }
        while(v2 < v1) {
            Object object1 = list0.get(v2);
            v3 += (object1 instanceof zzjc ? zzjr.zzb(((zzjc)object1)) : zzjr.zzm(((String)object1)));
            ++v2;
        }
        return v3;
    }

    static int zzc(int v, List list0, zzmf zzmf0) {
        int v1 = list0.size();
        if(v1 == 0) {
            return 0;
        }
        int v3 = zzjr.zzab(v) * v1;
        for(int v2 = 0; v2 < v1; ++v2) {
            Object object0 = list0.get(v2);
            v3 += (object0 instanceof zzkx ? zzjr.zza(((zzkx)object0)) : zzjr.zza(((zzlq)object0), zzmf0));
        }
        return v3;
    }

    static int zzc(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzle) {
            v2 = 0;
            while(v1 < v) {
                v2 += zzjr.zzq(((zzle)list0).getLong(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += zzjr.zzq(((long)(((Long)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    public static void zzc(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzc(v, list0, z);
        }
    }

    static int zzd(int v, List list0) {
        int v1 = list0.size();
        if(v1 == 0) {
            return 0;
        }
        int v3 = v1 * zzjr.zzab(v);
        for(int v2 = 0; v2 < list0.size(); ++v2) {
            v3 += zzjr.zzb(((zzjc)list0.get(v2)));
        }
        return v3;
    }

    static int zzd(int v, List list0, zzmf zzmf0) {
        int v1 = list0.size();
        if(v1 == 0) {
            return 0;
        }
        int v3 = 0;
        for(int v2 = 0; v2 < v1; ++v2) {
            v3 += zzjr.zzc(v, ((zzlq)list0.get(v2)), zzmf0);
        }
        return v3;
    }

    static int zzd(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzkl) {
            v2 = 0;
            while(v1 < v) {
                v2 += zzjr.zzah(((zzkl)list0).getInt(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += zzjr.zzah(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    public static void zzd(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzd(v, list0, z);
        }
    }

    // 去混淆评级： 低(20)
    static boolean zzd(Object object0, Object object1) {
        return object0 == object1 || object0 != null && object0.equals(object1);
    }

    static int zze(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzkl) {
            v2 = 0;
            while(v1 < v) {
                v2 += zzjr.zzac(((zzkl)list0).getInt(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += zzjr.zzac(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    public static void zze(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzn(v, list0, z);
        }
    }

    public static zzmx zzem() {
        return zzmh.zzva;
    }

    public static zzmx zzen() {
        return zzmh.zzvb;
    }

    public static zzmx zzeo() {
        return zzmh.zzvc;
    }

    private static Class zzep() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    private static Class zzeq() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    static int zzf(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzkl) {
            v2 = 0;
            while(v1 < v) {
                v2 += zzjr.zzad(((zzkl)list0).getInt(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += zzjr.zzad(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    private static zzmx zzf(boolean z) {
        try {
            Class class0 = zzmh.zzeq();
            return class0 == null ? null : ((zzmx)class0.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z)));
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    public static void zzf(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zze(v, list0, z);
        }
    }

    static int zzg(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzkl) {
            v2 = 0;
            while(v1 < v) {
                v2 += zzjr.zzae(((zzkl)list0).getInt(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += zzjr.zzae(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    public static void zzg(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzl(v, list0, z);
        }
    }

    public static void zzg(Class class0) {
        if(!zzkk.class.isAssignableFrom(class0) && (zzmh.zzuz != null && !zzmh.zzuz.isAssignableFrom(class0))) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static int zzh(List list0) {
        return list0.size() << 2;
    }

    public static void zzh(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zza(v, list0, z);
        }
    }

    static int zzi(List list0) {
        return list0.size() << 3;
    }

    public static void zzi(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzj(v, list0, z);
        }
    }

    static int zzj(List list0) {
        return list0.size();
    }

    public static void zzj(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzm(v, list0, z);
        }
    }

    public static void zzk(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzb(v, list0, z);
        }
    }

    public static void zzl(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzk(v, list0, z);
        }
    }

    public static void zzm(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzh(v, list0, z);
        }
    }

    public static void zzn(int v, List list0, zzns zzns0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzns0.zzi(v, list0, z);
        }
    }

    static int zzo(int v, List list0, boolean z) {
        return list0.size() == 0 ? 0 : zzmh.zza(list0) + list0.size() * zzjr.zzab(v);
    }

    static int zzp(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : zzmh.zzb(list0) + v1 * zzjr.zzab(v);
    }

    static int zzq(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : zzmh.zzc(list0) + v1 * zzjr.zzab(v);
    }

    static int zzr(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : zzmh.zzd(list0) + v1 * zzjr.zzab(v);
    }

    static int zzs(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : zzmh.zze(list0) + v1 * zzjr.zzab(v);
    }

    static int zzt(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : zzmh.zzf(list0) + v1 * zzjr.zzab(v);
    }

    static int zzu(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : zzmh.zzg(list0) + v1 * zzjr.zzab(v);
    }

    static int zzv(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : v1 * zzjr.zzj(v, 0);
    }

    static int zzw(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : v1 * zzjr.zzg(v, 0L);
    }

    static int zzx(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : v1 * zzjr.zzc(v, true);
    }
}

