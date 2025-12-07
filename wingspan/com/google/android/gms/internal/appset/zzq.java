package com.google.android.gms.internal.appset;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final class zzq implements Continuation {
    public final zzr zza;

    public zzq(zzr zzr0) {
        this.zza = zzr0;
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public final Object then(Task task0) {
        return zzr.zza(this.zza, task0);
    }
}

