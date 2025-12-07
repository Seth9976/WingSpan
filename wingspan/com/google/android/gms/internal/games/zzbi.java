package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbi implements RemoteCall {
    public final LeaderboardScoreBuffer zza;
    public final int zzb;
    public final int zzc;

    public zzbi(LeaderboardScoreBuffer leaderboardScoreBuffer0, int v, int v1) {
        this.zza = leaderboardScoreBuffer0;
        this.zzb = v;
        this.zzc = v1;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzau(((TaskCompletionSource)object1), this.zza, this.zzb, this.zzc);
    }
}

