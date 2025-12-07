package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzck extends zzbs {
    zzcl zza;
    private static final Logger zzb;
    private static final boolean zzc;

    static {
        zzck.zzb = Logger.getLogger("com.google.android.gms.internal.play_billing.zzck");
        zzck.zzc = false;
    }

    private zzck() {
    }

    zzck(zzcj zzcj0) {
    }

    final void zzA(String s, zzga zzga0) throws IOException {
        zzck.zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzga0);
        byte[] arr_b = s.getBytes(zzdl.zzb);
        try {
            this.zzq(arr_b.length);
            this.zzl(arr_b, 0, arr_b.length);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzci(indexOutOfBoundsException0);
        }
    }

    static boolean zzB() [...] // 潜在的解密器

    public abstract int zza();

    public abstract void zzb(byte arg1) throws IOException;

    public abstract void zzd(int arg1, boolean arg2) throws IOException;

    public abstract void zze(int arg1, zzcc arg2) throws IOException;

    public abstract void zzf(int arg1, int arg2) throws IOException;

    public abstract void zzg(int arg1) throws IOException;

    public abstract void zzh(int arg1, long arg2) throws IOException;

    public abstract void zzi(long arg1) throws IOException;

    public abstract void zzj(int arg1, int arg2) throws IOException;

    public abstract void zzk(int arg1) throws IOException;

    public abstract void zzl(byte[] arg1, int arg2, int arg3) throws IOException;

    public abstract void zzm(int arg1, String arg2) throws IOException;

    public abstract void zzo(int arg1, int arg2) throws IOException;

    public abstract void zzp(int arg1, int arg2) throws IOException;

    public abstract void zzq(int arg1) throws IOException;

    public abstract void zzr(int arg1, long arg2) throws IOException;

    public abstract void zzs(long arg1) throws IOException;

    @Deprecated
    static int zzt(int v, zzek zzek0, zzev zzev0) {
        int v1 = zzck.zzw(v << 3);
        return v1 + v1 + ((zzbm)zzek0).zza(zzev0);
    }

    static int zzu(zzek zzek0, zzev zzev0) {
        int v = ((zzbm)zzek0).zza(zzev0);
        return zzck.zzw(v) + v;
    }

    public static int zzv(String s) {
        int v;
        try {
            v = zzgb.zzc(s);
            return zzck.zzw(v) + v;
        }
        catch(zzga unused_ex) {
            v = s.getBytes(zzdl.zzb).length;
            return zzck.zzw(v) + v;
        }
    }

    public static int zzw(int v) [...] // 潜在的解密器

    public static int zzx(long v) {
        return 640 - Long.numberOfLeadingZeros(v) * 9 >>> 6;
    }

    public static zzck zzy(byte[] arr_b, int v, int v1) {
        return new zzch(arr_b, 0, v1);
    }

    public final void zzz() {
        if(this.zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }
}

