package com.google.android.gms.internal.drive;

final class zzjq extends zzjo {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzoc;
    private int zzod;
    private int zzoe;
    private int zzof;

    private zzjq(byte[] arr_b, int v, int v1, boolean z) {
        super(null);
        this.zzof = 0x7FFFFFFF;
        this.buffer = arr_b;
        this.limit = v1 + v;
        this.pos = v;
        this.zzoe = v;
        this.zzoc = z;
    }

    zzjq(byte[] arr_b, int v, int v1, boolean z, zzjp zzjp0) {
        this(arr_b, v, v1, z);
    }

    @Override  // com.google.android.gms.internal.drive.zzjo
    public final int zzbz() {
        return this.pos - this.zzoe;
    }

    @Override  // com.google.android.gms.internal.drive.zzjo
    public final int zzv(int v) throws zzkq {
        if(v < 0) {
            throw zzkq.zzdj();
        }
        int v1 = v + this.zzbz();
        int v2 = this.zzof;
        if(v1 > v2) {
            throw zzkq.zzdi();
        }
        this.zzof = v1;
        int v3 = this.limit + this.zzod;
        this.limit = v3;
        int v4 = v3 - this.zzoe;
        if(v4 > v1) {
            int v5 = v4 - v1;
            this.zzod = v5;
            this.limit = v3 - v5;
            return v2;
        }
        this.zzod = 0;
        return v2;
    }
}

