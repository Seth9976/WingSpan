package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

public abstract class zzjc implements Serializable, Iterable {
    public static final zzjc zznq;
    private static final zzji zznr;
    private int zzns;
    private static final Comparator zznt;

    static {
        zzjc.zznq = new zzjm(zzkm.zzsn);
        zzjc.zznr = new zzjg(null);
        zzjc.zznt = new zzje();
    }

    zzjc() {
        this.zzns = 0;
    }

    @Override
    public abstract boolean equals(Object arg1);

    @Override
    public final int hashCode() {
        int v = this.zzns;
        if(v == 0) {
            int v1 = this.size();
            v = this.zza(v1, 0, v1);
            if(v == 0) {
                v = 1;
            }
            this.zzns = v;
        }
        return v;
    }

    @Override
    public Iterator iterator() {
        return new zzjd(this);
    }

    public abstract int size();

    @Override
    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), this.size());
    }

    private static int zza(byte b) [...] // Inlined contents

    protected abstract int zza(int arg1, int arg2, int arg3);

    public abstract zzjc zza(int arg1, int arg2);

    protected abstract String zza(Charset arg1);

    abstract void zza(zzjb arg1) throws IOException;

    static int zzb(byte b) {
        return b & 0xFF;
    }

    static int zzb(int v, int v1, int v2) {
        int v3 = v1 - v;
        if((v | v1 | v3 | v2 - v1) < 0) {
            if(v < 0) {
                throw new IndexOutOfBoundsException("Beginning index: " + v + " < 0");
            }
            throw v1 >= v ? new IndexOutOfBoundsException("End index: " + v1 + " >= " + v2) : new IndexOutOfBoundsException("Beginning index larger than ending index: " + v + ", " + v1);
        }
        return v3;
    }

    public static zzjc zzb(byte[] arr_b, int v, int v1) {
        zzjc.zzb(v, v + v1, arr_b.length);
        return new zzjm(zzjc.zznr.zzc(arr_b, v, v1));
    }

    public final String zzbt() {
        return this.size() == 0 ? "" : this.zza(zzkm.UTF_8);
    }

    public abstract boolean zzbu();

    protected final int zzbv() {
        return this.zzns;
    }

    public static zzjc zzk(String s) {
        return new zzjm(s.getBytes(zzkm.UTF_8));
    }

    public abstract byte zzs(int arg1);

    abstract byte zzt(int arg1);

    static zzjk zzu(int v) {
        return new zzjk(v, null);
    }
}

