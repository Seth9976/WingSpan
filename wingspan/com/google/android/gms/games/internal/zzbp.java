package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbp extends zza {
    private final TaskCompletionSource zza;

    zzbp(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzm(DataHolder dataHolder0) {
        PlayerEntity playerEntity0;
        int v = dataHolder0.getStatusCode();
        if(v != 0 && v != 3) {
            GamesStatusUtils.zza(this.zza, v);
            dataHolder0.close();
            return;
        }
        boolean z = false;
        PlayerBuffer playerBuffer0 = new PlayerBuffer(dataHolder0);
        try {
            playerEntity0 = playerBuffer0.getCount() <= 0 ? null : new PlayerEntity(playerBuffer0.get(0));
        }
        finally {
            playerBuffer0.release();
        }
        if(v == 3) {
            z = true;
        }
        AnnotatedData annotatedData0 = new AnnotatedData(playerEntity0, z);
        this.zza.setResult(annotatedData0);
    }
}

