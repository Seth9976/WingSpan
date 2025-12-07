package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzai extends zza {
    private final TaskCompletionSource zza;

    zzai(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzr(int v, String s) {
        if(v == 0) {
            this.zza.setResult(s);
            return;
        }
        GamesStatusUtils.zza(this.zza, v);
    }
}

