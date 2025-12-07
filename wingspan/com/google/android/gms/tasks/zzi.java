package com.google.android.gms.tasks;

final class zzi implements Runnable {
    final Task zza;
    final zzj zzb;

    zzi(zzj zzj0, Task task0) {
        this.zzb = zzj0;
        this.zza = task0;
        super();
    }

    @Override
    public final void run() {
        synchronized(this.zzb.zzb) {
            zzj zzj0 = this.zzb;
            if(zzj0.zzc != null) {
                zzj0.zzc.onComplete(this.zza);
            }
        }
    }
}

