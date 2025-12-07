package com.google.android.gms.internal.appset;

import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzh implements Runnable {
    public final zzl zza;
    public final TaskCompletionSource zzb;

    public zzh(zzl zzl0, TaskCompletionSource taskCompletionSource0) {
        this.zza = zzl0;
        this.zzb = taskCompletionSource0;
    }

    @Override
    public final void run() {
        this.zza.zzd(this.zzb);
    }
}

