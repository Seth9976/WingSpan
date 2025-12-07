package com.google.android.gms.internal.drive;

final class zzme implements zzlo {
    private final int flags;
    private final String info;
    private final Object[] zzue;
    private final zzlq zzuh;

    zzme(zzlq zzlq0, String s, Object[] arr_object) {
        this.zzuh = zzlq0;
        this.info = s;
        this.zzue = arr_object;
        int v = s.charAt(0);
        if(v < 0xD800) {
            this.flags = v;
            return;
        }
        int v1 = v & 0x1FFF;
        int v2 = 13;
        int v4;
        for(int v3 = 1; (v4 = s.charAt(v3)) >= 0xD800; ++v3) {
            v1 |= (v4 & 0x1FFF) << v2;
            v2 += 13;
        }
        this.flags = v1 | v4 << v2;
    }

    @Override  // com.google.android.gms.internal.drive.zzlo
    public final int zzec() {
        return (this.flags & 1) == 1 ? zze.zzsf : zze.zzsg;
    }

    @Override  // com.google.android.gms.internal.drive.zzlo
    public final boolean zzed() {
        return (this.flags & 2) == 2;
    }

    @Override  // com.google.android.gms.internal.drive.zzlo
    public final zzlq zzee() {
        return this.zzuh;
    }

    final String zzek() {
        return this.info;
    }

    final Object[] zzel() {
        return this.zzue;
    }
}

