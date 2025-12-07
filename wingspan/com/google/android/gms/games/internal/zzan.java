package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzan extends zza {
    private final TaskCompletionSource zza;

    zzan(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzh(DataHolder dataHolder0) {
        GameEntity gameEntity0;
        boolean z;
        int v = dataHolder0.getStatusCode();
        if(v != 0 && v != 3) {
            GamesStatusUtils.zza(this.zza, v);
            dataHolder0.close();
            return;
        }
        try(GameBuffer gameBuffer0 = new GameBuffer(dataHolder0)) {
            z = true;
            gameEntity0 = gameBuffer0.getCount() > 0 ? new GameEntity(gameBuffer0.get(0)) : null;
        }
        if(v != 3) {
            z = false;
        }
        AnnotatedData annotatedData0 = new AnnotatedData(gameEntity0, z);
        this.zza.setResult(annotatedData0);
    }
}

