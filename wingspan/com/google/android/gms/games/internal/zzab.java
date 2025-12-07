package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzab extends zza {
    private final TaskCompletionSource zza;

    zzab(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzb(int v, String s) {
        if(v != 0 && v != 3003) {
            GamesStatusUtils.zza(this.zza, v);
            return;
        }
        this.zza.setResult(null);
    }
}

