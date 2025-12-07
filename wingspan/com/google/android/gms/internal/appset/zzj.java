package com.google.android.gms.internal.appset;

import com.google.android.gms.common.util.DefaultClock;

final class zzj implements Runnable {
    final zzl zza;

    zzj(zzl zzl0, zzi zzi0) {
        this.zza = zzl0;
        super();
    }

    @Override
    public final void run() {
        long v = this.zza.zza();
        if(v != -1L && DefaultClock.getInstance().currentTimeMillis() > v) {
            zzl.zze(this.zza.zzb);
        }
    }
}

