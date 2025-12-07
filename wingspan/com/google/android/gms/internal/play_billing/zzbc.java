package com.google.android.gms.internal.play_billing;

import javax.annotation.CheckForNull;

public abstract class zzbc {
    private static final char[] zza;
    public static final int zzb;

    static {
        zzbc.zza = "0123456789abcdef".toCharArray();
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(@CheckForNull Object object0) {
        return object0 instanceof zzbc && this.zzb() == ((zzbc)object0).zzb() && this.zzc(((zzbc)object0));
    }

    @Override
    public final int hashCode() {
        if(this.zzb() >= 0x20) {
            return this.zza();
        }
        byte[] arr_b = this.zzd();
        int v = arr_b[0] & 0xFF;
        for(int v1 = 1; v1 < arr_b.length; ++v1) {
            v |= (arr_b[v1] & 0xFF) << v1 * 8;
        }
        return v;
    }

    @Override
    public final String toString() {
        byte[] arr_b = this.zzd();
        StringBuilder stringBuilder0 = new StringBuilder(arr_b.length + arr_b.length);
        for(int v = 0; v < arr_b.length; ++v) {
            int v1 = arr_b[v];
            stringBuilder0.append(zzbc.zza[v1 >> 4 & 15]);
            stringBuilder0.append(zzbc.zza[v1 & 15]);
        }
        return stringBuilder0.toString();
    }

    public abstract int zza();

    public abstract int zzb();

    abstract boolean zzc(zzbc arg1);

    byte[] zzd() {
        throw null;
    }
}

