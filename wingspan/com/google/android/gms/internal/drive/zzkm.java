package com.google.android.gms.internal.drive;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzkm {
    private static final Charset ISO_8859_1;
    static final Charset UTF_8;
    public static final byte[] zzsn;
    private static final ByteBuffer zzso;
    private static final zzjo zzsp;

    static {
        zzkm.UTF_8 = Charset.forName("UTF-8");
        zzkm.ISO_8859_1 = Charset.forName("ISO-8859-1");
        byte[] arr_b = new byte[0];
        zzkm.zzsn = arr_b;
        zzkm.zzso = ByteBuffer.wrap(arr_b);
        zzkm.zzsp = zzjo.zza(arr_b, 0, 0, false);
    }

    static Object checkNotNull(Object object0) {
        object0.getClass();
        return object0;
    }

    public static int hashCode(byte[] arr_b) {
        int v = zzkm.zza(arr_b.length, arr_b, 0, arr_b.length);
        return v == 0 ? 1 : v;
    }

    static int zza(int v, byte[] arr_b, int v1, int v2) {
        for(int v3 = v1; v3 < v1 + v2; ++v3) {
            v = v * 0x1F + arr_b[v3];
        }
        return v;
    }

    static Object zza(Object object0, Object object1) {
        return ((zzlq)object0).zzcy().zza(((zzlq)object1)).zzde();
    }

    static Object zza(Object object0, String s) {
        if(object0 == null) {
            throw new NullPointerException(s);
        }
        return object0;
    }

    public static boolean zzd(byte[] arr_b) {
        return zznf.zzd(arr_b);
    }

    // 去混淆评级： 低(20)
    public static int zze(boolean z) {
        return z ? 0x4CF : 0x4D5;
    }

    public static String zze(byte[] arr_b) {
        return new String(arr_b, zzkm.UTF_8);
    }

    static boolean zzf(zzlq zzlq0) {
        return false;
    }

    public static int zzu(long v) {
        return (int)(v ^ v >>> 0x20);
    }
}

