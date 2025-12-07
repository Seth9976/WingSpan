package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

final class zzex {
    public static final int zza;
    private static final Class zzb;
    private static final zzfm zzc;
    private static final zzfm zzd;

    static {
        Class class1;
        Class class0;
        zzfm zzfm0 = null;
        try {
            class0 = null;
            class0 = Class.forName("com.google.protobuf.GeneratedMessage");
        }
        catch(Throwable unused_ex) {
        }
        try {
            zzex.zzb = class0;
            class1 = null;
            class1 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        }
        catch(Throwable unused_ex) {
        }
        if(class1 != null) {
            try {
                zzfm0 = (zzfm)class1.getConstructor().newInstance();
            }
            catch(Throwable unused_ex) {
            }
        }
        zzex.zzc = zzfm0;
        zzex.zzd = new zzfo();
    }

    public static void zzA(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzz(v, list0, z);
        }
    }

    public static void zzB(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzB(v, list0, z);
        }
    }

    public static void zzC(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzD(v, list0, z);
        }
    }

    public static void zzD(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzI(v, list0, z);
        }
    }

    public static void zzE(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzK(v, list0, z);
        }
    }

    // 去混淆评级： 低(20)
    static boolean zzF(Object object0, Object object1) {
        return object0 == object1 || object0 != null && object0.equals(object1);
    }

    static int zza(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzde) {
            v2 = 0;
            while(v1 < v) {
                v2 += zzck.zzx(((zzde)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += zzck.zzx(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    static int zzb(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : v1 * (zzck.zzw(v << 3) + 4);
    }

    static int zzc(List list0) {
        return list0.size() * 4;
    }

    static int zzd(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : v1 * (zzck.zzw(v << 3) + 8);
    }

    static int zze(List list0) {
        return list0.size() * 8;
    }

    static int zzf(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzde) {
            v2 = 0;
            while(v1 < v) {
                v2 += zzck.zzx(((zzde)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += zzck.zzx(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    static int zzg(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzdz) {
            v2 = 0;
            while(v1 < v) {
                v2 += zzck.zzx(((zzdz)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += zzck.zzx(((long)(((Long)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    static int zzh(int v, Object object0, zzev zzev0) {
        if(object0 instanceof zzdq) {
            int v1 = ((zzdq)object0).zza();
            return zzck.zzw(v << 3) + (zzck.zzw(v1) + v1);
        }
        return zzck.zzw(v << 3) + zzck.zzu(((zzek)object0), zzev0);
    }

    static int zzi(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzde) {
            v2 = 0;
            while(v1 < v) {
                int v3 = ((zzde)list0).zze(v1);
                v2 += zzck.zzw(v3 >> 0x1F ^ v3 + v3);
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            int v4 = (int)(((Integer)list0.get(v1)));
            v2 += zzck.zzw(v4 >> 0x1F ^ v4 + v4);
            ++v1;
        }
        return v2;
    }

    static int zzj(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzdz) {
            v2 = 0;
            while(v1 < v) {
                long v3 = ((zzdz)list0).zze(v1);
                v2 += zzck.zzx(v3 >> 0x3F ^ v3 + v3);
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            long v4 = (long)(((Long)list0.get(v1)));
            v2 += zzck.zzx(v4 >> 0x3F ^ v4 + v4);
            ++v1;
        }
        return v2;
    }

    static int zzk(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzde) {
            v2 = 0;
            while(v1 < v) {
                v2 += zzck.zzw(((zzde)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += zzck.zzw(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    static int zzl(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzdz) {
            v2 = 0;
            while(v1 < v) {
                v2 += zzck.zzx(((zzdz)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += zzck.zzx(((long)(((Long)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    public static zzfm zzm() {
        return zzex.zzc;
    }

    public static zzfm zzn() {
        return zzex.zzd;
    }

    static Object zzo(Object object0, int v, int v1, Object object1, zzfm zzfm0) {
        if(object1 == null) {
            object1 = zzfm0.zzc(object0);
        }
        zzfm0.zzf(object1, v, ((long)v1));
        return object1;
    }

    static void zzp(zzfm zzfm0, Object object0, Object object1) {
        zzfm0.zzh(object0, zzfm0.zze(zzfm0.zzd(object0), zzfm0.zzd(object1)));
    }

    public static void zzq(Class class0) {
        if(!zzdd.class.isAssignableFrom(class0) && (zzex.zzb != null && !zzex.zzb.isAssignableFrom(class0))) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzr(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzc(v, list0, z);
        }
    }

    public static void zzs(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzg(v, list0, z);
        }
    }

    public static void zzt(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzj(v, list0, z);
        }
    }

    public static void zzu(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzl(v, list0, z);
        }
    }

    public static void zzv(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzn(v, list0, z);
        }
    }

    public static void zzw(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzp(v, list0, z);
        }
    }

    public static void zzx(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzs(v, list0, z);
        }
    }

    public static void zzy(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzu(v, list0, z);
        }
    }

    public static void zzz(int v, List list0, zzge zzge0, boolean z) throws IOException {
        if(list0 != null && !list0.isEmpty()) {
            zzge0.zzx(v, list0, z);
        }
    }
}

