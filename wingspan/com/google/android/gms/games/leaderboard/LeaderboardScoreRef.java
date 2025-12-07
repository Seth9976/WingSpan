package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef extends DataBufferRef implements LeaderboardScore {
    private final PlayerRef zza;

    public LeaderboardScoreRef(DataHolder dataHolder0, int v) {
        super(dataHolder0, v);
        this.zza = new PlayerRef(dataHolder0, v, null);
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object object0) {
        return LeaderboardScoreEntity.zzc(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return new LeaderboardScoreEntity(this);
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getDisplayRank() {
        return this.getString("display_rank");
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayRank(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer("display_rank", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getDisplayScore() {
        return this.getString("display_score");
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayScore(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer("display_score", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRank() {
        return this.getLong("rank");
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRawScore() {
        return this.getLong("raw_score");
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Player getScoreHolder() {
        return this.hasNull("external_player_id") ? null : this.zza;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreHolderDisplayName() {
        return this.hasNull("external_player_id") ? this.getString("default_display_name") : this.zza.getDisplayName();
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer0) {
        if(this.hasNull("external_player_id")) {
            this.copyToBuffer("default_display_name", charArrayBuffer0);
            return;
        }
        this.zza.getDisplayName(charArrayBuffer0);
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Uri getScoreHolderHiResImageUri() {
        return this.hasNull("external_player_id") ? null : this.zza.getHiResImageUri();
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getScoreHolderHiResImageUrl() {
        return this.hasNull("external_player_id") ? null : this.zza.getHiResImageUrl();
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Uri getScoreHolderIconImageUri() {
        return this.hasNull("external_player_id") ? this.parseUri("default_display_image_uri") : this.zza.getIconImageUri();
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getScoreHolderIconImageUrl() {
        return this.hasNull("external_player_id") ? this.getString("default_display_image_url") : this.zza.getIconImageUrl();
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreTag() {
        return this.getString("score_tag");
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getTimestampMillis() {
        return this.getLong("achieved_timestamp");
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    @Override
    public final String toString() {
        return LeaderboardScoreEntity.zzb(this);
    }
}

