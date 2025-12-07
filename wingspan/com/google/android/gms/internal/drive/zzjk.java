package com.google.android.gms.internal.drive;

final class zzjk {
    private final byte[] buffer;
    private final zzjr zznx;

    private zzjk(int v) {
        byte[] arr_b = new byte[v];
        this.buffer = arr_b;
        this.zznx = zzjr.zzb(arr_b);
    }

    zzjk(int v, zzjd zzjd0) {
        this(v);
    }

    public final zzjc zzbx() {
        this.zznx.zzcb();
        return new zzjm(this.buffer);
    }

    public final zzjr zzby() {
        return this.zznx;
    }
}

