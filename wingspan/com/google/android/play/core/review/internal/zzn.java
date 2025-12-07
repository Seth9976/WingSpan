package com.google.android.play.core.review.internal;

final class zzn extends zzj {
    final zzt zza;

    zzn(zzt zzt0) {
        this.zza = zzt0;
        super();
    }

    @Override  // com.google.android.play.core.review.internal.zzj
    public final void zza() {
        zzt zzt0 = this.zza;
        if(zzt.zzd(zzt0) != null) {
            zzt.zzf(zzt0).zzd("Unbind from service.", new Object[0]);
            zzt.zza(this.zza).unbindService(zzt.zzb(this.zza));
            zzt.zzj(this.zza, false);
            zzt.zzk(this.zza, null);
            zzt.zzi(this.zza, null);
        }
        zzt.zzl(this.zza);
    }
}

