package com.google.android.gms.internal.drive;

import java.io.IOException;

final class zzmz extends zzmx {
    private static void zza(Object object0, zzmy zzmy0) {
        ((zzkk)object0).zzrq = zzmy0;
    }

    @Override  // com.google.android.gms.internal.drive.zzmx
    final void zza(Object object0, int v, long v1) {
        ((zzmy)object0).zzb(v << 3, v1);
    }

    @Override  // com.google.android.gms.internal.drive.zzmx
    final void zza(Object object0, int v, zzjc zzjc0) {
        ((zzmy)object0).zzb(v << 3 | 2, zzjc0);
    }

    @Override  // com.google.android.gms.internal.drive.zzmx
    final void zza(Object object0, zzns zzns0) throws IOException {
        ((zzmy)object0).zzb(zzns0);
    }

    @Override  // com.google.android.gms.internal.drive.zzmx
    final void zzc(Object object0, zzns zzns0) throws IOException {
        ((zzmy)object0).zza(zzns0);
    }

    @Override  // com.google.android.gms.internal.drive.zzmx
    final void zzd(Object object0) {
        ((zzkk)object0).zzrq.zzbp();
    }

    @Override  // com.google.android.gms.internal.drive.zzmx
    final void zze(Object object0, Object object1) {
        zzmz.zza(object0, ((zzmy)object1));
    }

    @Override  // com.google.android.gms.internal.drive.zzmx
    final Object zzez() {
        return zzmy.zzfb();
    }

    @Override  // com.google.android.gms.internal.drive.zzmx
    final void zzf(Object object0, Object object1) {
        zzmz.zza(object0, ((zzmy)object1));
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.internal.drive.zzmx
    final Object zzg(Object object0, Object object1) {
        return ((zzmy)object1).equals(zzmy.zzfa()) ? ((zzmy)object0) : zzmy.zza(((zzmy)object0), ((zzmy)object1));
    }

    @Override  // com.google.android.gms.internal.drive.zzmx
    final int zzn(Object object0) {
        return ((zzmy)object0).zzcx();
    }

    @Override  // com.google.android.gms.internal.drive.zzmx
    final Object zzr(Object object0) {
        return ((zzkk)object0).zzrq;
    }

    @Override  // com.google.android.gms.internal.drive.zzmx
    final int zzs(Object object0) {
        return ((zzmy)object0).zzfc();
    }
}

