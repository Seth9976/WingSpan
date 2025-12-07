package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbj extends zza {
    final TaskCompletionSource zza;

    zzbj(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzu(int v, boolean z) {
        if(v == 0) {
            this.zza.setResult(Boolean.valueOf(z));
            return;
        }
        GamesStatusUtils.zza(this.zza, v);
    }
}

