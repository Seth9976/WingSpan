package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;

final class zzbf extends zzao implements LoadScoresResult {
    private final LeaderboardEntity zza;
    private final LeaderboardScoreBuffer zzb;

    zzbf(DataHolder dataHolder0, DataHolder dataHolder1) {
        super(dataHolder1);
        LeaderboardBuffer leaderboardBuffer0 = new LeaderboardBuffer(dataHolder0);
        try {
            this.zza = leaderboardBuffer0.getCount() > 0 ? ((LeaderboardEntity)((Leaderboard)leaderboardBuffer0.get(0)).freeze()) : null;
        }
        finally {
            leaderboardBuffer0.release();
        }
        this.zzb = new LeaderboardScoreBuffer(dataHolder1);
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboards$LoadScoresResult
    public final Leaderboard getLeaderboard() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboards$LoadScoresResult
    public final LeaderboardScoreBuffer getScores() {
        return this.zzb;
    }
}

