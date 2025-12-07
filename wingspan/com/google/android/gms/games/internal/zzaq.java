package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;

final class zzaq extends zzao implements LeaderboardMetadataResult {
    private final LeaderboardBuffer zza;

    zzaq(DataHolder dataHolder0) {
        super(dataHolder0);
        this.zza = new LeaderboardBuffer(dataHolder0);
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboards$LeaderboardMetadataResult
    public final LeaderboardBuffer getLeaderboards() {
        return this.zza;
    }
}

