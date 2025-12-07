package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;

final class zzch implements LoadScoresResult {
    final Status zza;

    zzch(zzcj zzcj0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboards$LoadScoresResult
    public final Leaderboard getLeaderboard() {
        return null;
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboards$LoadScoresResult
    public final LeaderboardScoreBuffer getScores() {
        return new LeaderboardScoreBuffer(DataHolder.empty(14));
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override  // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}

