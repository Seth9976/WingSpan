package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.nio.charset.Charset;

class zzjm extends zzjl {
    protected final byte[] zzny;

    zzjm(byte[] arr_b) {
        arr_b.getClass();
        this.zzny = arr_b;
    }

    @Override  // com.google.android.gms.internal.drive.zzjc
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof zzjc)) {
            return false;
        }
        if(this.size() != ((zzjc)object0).size()) {
            return false;
        }
        if(this.size() == 0) {
            return true;
        }
        if(object0 instanceof zzjm) {
            int v = this.zzbv();
            int v1 = ((zzjm)object0).zzbv();
            return v == 0 || v1 == 0 || v == v1 ? this.zza(((zzjm)object0), 0, this.size()) : false;
        }
        return object0.equals(this);
    }

    @Override  // com.google.android.gms.internal.drive.zzjc
    public int size() {
        return this.zzny.length;
    }

    @Override  // com.google.android.gms.internal.drive.zzjc
    protected final int zza(int v, int v1, int v2) {
        return zzkm.zza(v, this.zzny, this.zzbw(), v2);
    }

    @Override  // com.google.android.gms.internal.drive.zzjc
    public final zzjc zza(int v, int v1) {
        int v2 = zzjm.zzb(0, v1, this.size());
        return v2 == 0 ? zzjc.zznq : new zzjh(this.zzny, this.zzbw(), v2);
    }

    @Override  // com.google.android.gms.internal.drive.zzjc
    protected final String zza(Charset charset0) {
        return new String(this.zzny, this.zzbw(), this.size(), charset0);
    }

    @Override  // com.google.android.gms.internal.drive.zzjc
    final void zza(zzjb zzjb0) throws IOException {
        zzjb0.zza(this.zzny, this.zzbw(), this.size());
    }

    @Override  // com.google.android.gms.internal.drive.zzjl
    final boolean zza(zzjc zzjc0, int v, int v1) {
        if(v1 > zzjc0.size()) {
            throw new IllegalArgumentException("Length too large: " + v1 + this.size());
        }
        if(v1 > zzjc0.size()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + v1 + ", " + zzjc0.size());
        }
        if(zzjc0 instanceof zzjm) {
            byte[] arr_b = this.zzny;
            byte[] arr_b1 = ((zzjm)zzjc0).zzny;
            int v2 = this.zzbw();
            int v3 = this.zzbw();
            for(int v4 = ((zzjm)zzjc0).zzbw(); v3 < v2 + v1; ++v4) {
                if(arr_b[v3] != arr_b1[v4]) {
                    return false;
                }
                ++v3;
            }
            return true;
        }
        return zzjc0.zza(0, v1).equals(this.zza(0, v1));
    }

    @Override  // com.google.android.gms.internal.drive.zzjc
    public final boolean zzbu() {
        int v = this.zzbw();
        return zznf.zze(this.zzny, v, this.size() + v);
    }

    protected int zzbw() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.drive.zzjc
    public byte zzs(int v) {
        return this.zzny[v];
    }

    @Override  // com.google.android.gms.internal.drive.zzjc
    byte zzt(int v) {
        return this.zzny[v];
    }
}

