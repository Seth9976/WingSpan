package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;

final class zzce implements LoadPlayerScoreResult {
    final Status zza;

    zzce(zzcg zzcg0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboards$LoadPlayerScoreResult
    public final LeaderboardScore getScore() {
        return null;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

