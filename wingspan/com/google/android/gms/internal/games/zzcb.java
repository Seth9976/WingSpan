package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;

final class zzcb implements LeaderboardMetadataResult {
    final Status zza;

    zzcb(zzcd zzcd0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboards$LeaderboardMetadataResult
    public final LeaderboardBuffer getLeaderboards() {
        return new LeaderboardBuffer(DataHolder.empty(14));
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override  // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}

