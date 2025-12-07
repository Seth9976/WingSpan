package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbk extends zza {
    final TaskCompletionSource zza;

    zzbk(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzv(int v, VideoCapabilities videoCapabilities0) {
        if(v == 0) {
            this.zza.setResult(videoCapabilities0);
            return;
        }
        GamesStatusUtils.zza(this.zza, v);
    }
}

