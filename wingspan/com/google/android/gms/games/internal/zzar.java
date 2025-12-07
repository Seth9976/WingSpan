package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzar extends zza {
    final zzbz zza;
    private final TaskCompletionSource zzb;

    zzar(zzbz zzbz0, TaskCompletionSource taskCompletionSource0) {
        this.zza = zzbz0;
        super();
        this.zzb = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzk(DataHolder dataHolder0) {
        LeaderboardScoreEntity leaderboardScoreEntity0;
        int v = dataHolder0.getStatusCode();
        switch(v) {
            case 0: {
                break;
            }
            case 10003: {
                zzbz.zzL(this.zza, this.zzb);
                dataHolder0.close();
                return;
            label_6:
                if(v != 3) {
                    GamesStatusUtils.zza(this.zzb, v);
                    dataHolder0.close();
                    return;
                }
                break;
            }
            default: {
                goto label_6;
            }
        }
        try(LeaderboardScoreBuffer leaderboardScoreBuffer0 = new LeaderboardScoreBuffer(dataHolder0)) {
            leaderboardScoreEntity0 = leaderboardScoreBuffer0.getCount() > 0 ? new LeaderboardScoreEntity(leaderboardScoreBuffer0.get(0)) : null;
        }
        AnnotatedData annotatedData0 = new AnnotatedData(leaderboardScoreEntity0, v == 3);
        this.zzb.setResult(annotatedData0);
    }
}

