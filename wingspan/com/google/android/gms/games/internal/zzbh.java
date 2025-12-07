package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbh extends zza {
    final TaskCompletionSource zza;

    zzbh(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zze(int v, Bundle bundle0) {
        if(v == 0) {
            CaptureState captureState0 = CaptureState.zza(bundle0);
            this.zza.setResult(captureState0);
            return;
        }
        GamesStatusUtils.zza(this.zza, v);
    }
}

