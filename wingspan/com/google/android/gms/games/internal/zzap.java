package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzap extends zza {
    private final TaskCompletionSource zza;

    zzap(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzj(DataHolder dataHolder0) {
        Object object0;
        int v = dataHolder0.getStatusCode();
        if(v != 0 && v != 3) {
            GamesStatusUtils.zza(this.zza, v);
            dataHolder0.close();
            return;
        }
        try(LeaderboardBuffer leaderboardBuffer0 = new LeaderboardBuffer(dataHolder0)) {
            object0 = leaderboardBuffer0.getCount() > 0 ? ((Leaderboard)leaderboardBuffer0.get(0)).freeze() : null;
        }
        AnnotatedData annotatedData0 = new AnnotatedData(object0, v == 3);
        this.zza.setResult(annotatedData0);
    }
}

