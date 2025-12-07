package com.google.android.gms.internal.drive;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzcj implements Continuation {
    private final zzg zzfp;

    zzcj(zzg zzg0) {
        this.zzfp = zzg0;
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public final Object then(Task task0) {
        return zzch.zza(this.zzfp, task0);
    }
}

