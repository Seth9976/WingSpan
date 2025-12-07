package com.google.android.gms.location;

import com.google.android.gms.tasks.TaskCompletionSource;

final class zzz implements zzan {
    private final TaskCompletionSource zza;

    zzz(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.location.zzan
    public final void zza() {
        this.zza.trySetResult(null);
    }
}

