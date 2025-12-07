package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef extends DataBufferRef implements Leaderboard {
    private final int zza;
    private final Game zzb;

    LeaderboardRef(DataHolder dataHolder0, int v, int v1) {
        super(dataHolder0, v);
        this.zza = v1;
        this.zzb = new GameRef(dataHolder0, v);
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object object0) {
        return LeaderboardEntity.zzd(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return new LeaderboardEntity(this);
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getDisplayName() {
        return this.getString("name");
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final void getDisplayName(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer("name", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final Uri getIconImageUri() {
        return this.parseUri("board_icon_image_uri");
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public String getIconImageUrl() {
        return this.getString("board_icon_image_url");
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getLeaderboardId() {
        return this.getString("external_leaderboard_id");
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final int getScoreOrder() {
        return this.getInteger("score_order");
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final ArrayList getVariants() {
        ArrayList arrayList0 = new ArrayList(this.zza);
        for(int v = 0; v < this.zza; ++v) {
            arrayList0.add(new zzb(this.mDataHolder, this.mDataRow + v));
        }
        return arrayList0;
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return LeaderboardEntity.zzb(this);
    }

    @Override
    public final String toString() {
        return LeaderboardEntity.zzc(this);
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final Game zza() {
        return this.zzb;
    }
}

