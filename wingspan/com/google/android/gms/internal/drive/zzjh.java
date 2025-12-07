package com.google.android.gms.internal.drive;

final class zzjh extends zzjm {
    private final int zznv;
    private final int zznw;

    zzjh(byte[] arr_b, int v, int v1) {
        super(arr_b);
        zzjh.zzb(v, v + v1, arr_b.length);
        this.zznv = v;
        this.zznw = v1;
    }

    @Override  // com.google.android.gms.internal.drive.zzjm
    public final int size() {
        return this.zznw;
    }

    @Override  // com.google.android.gms.internal.drive.zzjm
    protected final int zzbw() {
        return this.zznv;
    }

    @Override  // com.google.android.gms.internal.drive.zzjm
    public final byte zzs(int v) {
        int v1 = this.size();
        if((v1 - (v + 1) | v) < 0) {
            throw v >= 0 ? new ArrayIndexOutOfBoundsException("Index > length: " + v + ", " + v1) : new ArrayIndexOutOfBoundsException("Index < 0: " + v);
        }
        return this.zzny[this.zznv + v];
    }

    @Override  // com.google.android.gms.internal.drive.zzjm
    final byte zzt(int v) {
        return this.zzny[this.zznv + v];
    }
}

