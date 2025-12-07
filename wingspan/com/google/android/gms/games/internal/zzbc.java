package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;

final class zzbc extends zzao implements LoadPlayerScoreResult {
    private final LeaderboardScoreEntity zza;

    zzbc(DataHolder dataHolder0) {
        super(dataHolder0);
        LeaderboardScoreBuffer leaderboardScoreBuffer0 = new LeaderboardScoreBuffer(dataHolder0);
        try {
            this.zza = leaderboardScoreBuffer0.getCount() > 0 ? new LeaderboardScoreEntity(leaderboardScoreBuffer0.get(0)) : null;
        }
        finally {
            leaderboardScoreBuffer0.release();
        }
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboards$LoadPlayerScoreResult
    public final LeaderboardScore getScore() {
        return this.zza;
    }
}

