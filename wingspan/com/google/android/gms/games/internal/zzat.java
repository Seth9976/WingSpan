package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.LeaderboardsClient.LeaderboardScores;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzat extends zza {
    final zzbz zza;
    private final TaskCompletionSource zzb;

    zzat(zzbz zzbz0, TaskCompletionSource taskCompletionSource0) {
        this.zza = zzbz0;
        super();
        this.zzb = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzi(DataHolder dataHolder0, DataHolder dataHolder1) {
        Object object0;
        int v = dataHolder1.getStatusCode();
        switch(v) {
            case 0: {
                break;
            }
            case 10003: {
                zzbz.zzL(this.zza, this.zzb);
                dataHolder0.close();
                dataHolder1.close();
                return;
            label_7:
                if(v != 3) {
                    GamesStatusUtils.zza(this.zzb, v);
                    dataHolder0.close();
                    dataHolder1.close();
                    return;
                }
                break;
            }
            default: {
                goto label_7;
            }
        }
        try(LeaderboardBuffer leaderboardBuffer0 = new LeaderboardBuffer(dataHolder0)) {
            object0 = leaderboardBuffer0.getCount() > 0 ? ((Leaderboard)leaderboardBuffer0.get(0)).freeze() : null;
        }
        AnnotatedData annotatedData0 = new AnnotatedData(new LeaderboardScores(((Leaderboard)object0), new LeaderboardScoreBuffer(dataHolder1)), v == 3);
        this.zzb.setResult(annotatedData0);
    }
}

