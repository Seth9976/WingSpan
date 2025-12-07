package com.google.android.play.core.review.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

final class zzm extends zzj {
    final zzj zza;
    final zzt zzb;

    zzm(zzt zzt0, TaskCompletionSource taskCompletionSource0, zzj zzj0) {
        this.zzb = zzt0;
        this.zza = zzj0;
        super(taskCompletionSource0);
    }

    @Override  // com.google.android.play.core.review.internal.zzj
    public final void zza() {
        zzt.zzm(this.zzb, this.zza);
    }
}

