package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbm extends zza {
    private final TaskCompletionSource zza;

    zzbm(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzl(DataHolder dataHolder0) {
        PlayerStatsEntity playerStatsEntity0;
        boolean z;
        int v = dataHolder0.getStatusCode();
        if(v != 0 && v != 3) {
            GamesStatusUtils.zza(this.zza, v);
            dataHolder0.close();
            return;
        }
        try(PlayerStatsBuffer playerStatsBuffer0 = new PlayerStatsBuffer(dataHolder0)) {
            z = true;
            playerStatsEntity0 = playerStatsBuffer0.getCount() > 0 ? new PlayerStatsEntity(playerStatsBuffer0.zza(0)) : null;
        }
        if(v != 3) {
            z = false;
        }
        AnnotatedData annotatedData0 = new AnnotatedData(playerStatsEntity0, z);
        this.zza.setResult(annotatedData0);
    }
}

