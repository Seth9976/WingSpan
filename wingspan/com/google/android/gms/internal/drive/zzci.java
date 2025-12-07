package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzci implements Continuation {
    private final ListenerHolder zzfo;

    zzci(ListenerHolder listenerHolder0) {
        this.zzfo = listenerHolder0;
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public final Object then(Task task0) {
        return zzch.zza(this.zzfo, task0);
    }
}

