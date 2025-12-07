package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

public final class zzb extends DataBufferRef implements LeaderboardVariant {
    zzb(DataHolder dataHolder0, int v) {
        super(dataHolder0, v);
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object object0) {
        return LeaderboardVariantEntity.zzf(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return new LeaderboardVariantEntity(this);
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getCollection() {
        return this.getInteger("collection");
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerRank() {
        return this.getString("player_display_rank");
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerScore() {
        return this.getString("player_display_score");
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getNumScores() {
        return this.hasNull("total_scores") ? -1L : this.getLong("total_scores");
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getPlayerRank() {
        return this.hasNull("player_rank") ? -1L : this.getLong("player_rank");
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getPlayerScoreTag() {
        return this.getString("player_score_tag");
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getRawPlayerScore() {
        return this.hasNull("player_raw_score") ? -1L : this.getLong("player_raw_score");
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getTimeSpan() {
        return this.getInteger("timespan");
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final boolean hasPlayerInfo() {
        return !this.hasNull("player_raw_score");
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return LeaderboardVariantEntity.zzd(this);
    }

    @Override
    public final String toString() {
        return LeaderboardVariantEntity.zze(this);
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zza() {
        return this.getString("top_page_token_next");
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzb() {
        return this.getString("window_page_token_next");
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzc() {
        return this.getString("window_page_token_prev");
    }
}

