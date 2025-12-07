package com.google.android.play.core.review.internal;

import android.os.IBinder;

final class zzp extends zzj {
    final IBinder zza;
    final zzs zzb;

    zzp(zzs zzs0, IBinder iBinder0) {
        this.zzb = zzs0;
        this.zza = iBinder0;
        super();
    }

    @Override  // com.google.android.play.core.review.internal.zzj
    public final void zza() {
        zzf zzf0 = zze.zzb(this.zza);
        zzt.zzk(this.zzb.zza, zzf0);
        zzt.zzn(this.zzb.zza);
        zzt.zzj(this.zzb.zza, false);
        for(Object object0: zzt.zzg(this.zzb.zza)) {
            ((Runnable)object0).run();
        }
        zzt.zzg(this.zzb.zza).clear();
    }
}

