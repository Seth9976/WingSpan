package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzc implements Runnable {
    final LifecycleCallback zza;
    final String zzb;
    final zzd zzc;

    zzc(zzd zzd0, LifecycleCallback lifecycleCallback0, String s) {
        this.zzc = zzd0;
        this.zza = lifecycleCallback0;
        this.zzb = s;
        super();
    }

    @Override
    public final void run() {
        zzd zzd0 = this.zzc;
        if(zzd0.zzc > 0) {
            Bundle bundle0 = zzd0.zzd == null ? null : zzd0.zzd.getBundle(this.zzb);
            this.zza.onCreate(bundle0);
        }
        if(this.zzc.zzc >= 2) {
            this.zza.onStart();
        }
        if(this.zzc.zzc >= 3) {
            this.zza.onResume();
        }
        if(this.zzc.zzc >= 4) {
            this.zza.onStop();
        }
        if(this.zzc.zzc >= 5) {
            this.zza.onDestroy();
        }
    }
}

