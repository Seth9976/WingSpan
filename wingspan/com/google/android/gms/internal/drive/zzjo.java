package com.google.android.gms.internal.drive;

public abstract class zzjo {
    private int zznz;
    private int zzoa;
    private boolean zzob;

    private zzjo() {
        this.zznz = 100;
        this.zzoa = 0x7FFFFFFF;
        this.zzob = false;
    }

    zzjo(zzjp zzjp0) {
    }

    static zzjo zza(byte[] arr_b, int v, int v1, boolean z) {
        zzjo zzjo0 = new zzjq(arr_b, 0, v1, false, null);
        try {
            zzjo0.zzv(v1);
            return zzjo0;
        }
        catch(zzkq zzkq0) {
            throw new IllegalArgumentException(zzkq0);
        }
    }

    public abstract int zzbz();

    public static long zzk(long v) [...] // Inlined contents

    public abstract int zzv(int arg1) throws zzkq;

    public static int zzw(int v) [...] // Inlined contents
}

