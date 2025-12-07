package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final long zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final long zze;
    private final String zzf;
    private final Uri zzg;
    private final Uri zzh;
    private final PlayerEntity zzi;
    private final String zzj;
    private final String zzk;
    private final String zzl;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardScore0) {
        this.zza = leaderboardScore0.getRank();
        this.zzb = (String)Preconditions.checkNotNull(leaderboardScore0.getDisplayRank());
        this.zzc = (String)Preconditions.checkNotNull(leaderboardScore0.getDisplayScore());
        this.zzd = leaderboardScore0.getRawScore();
        this.zze = leaderboardScore0.getTimestampMillis();
        this.zzf = leaderboardScore0.getScoreHolderDisplayName();
        this.zzg = leaderboardScore0.getScoreHolderIconImageUri();
        this.zzh = leaderboardScore0.getScoreHolderHiResImageUri();
        Player player0 = leaderboardScore0.getScoreHolder();
        this.zzi = player0 == null ? null : new PlayerEntity(player0);
        this.zzj = leaderboardScore0.getScoreTag();
        this.zzk = leaderboardScore0.getScoreHolderIconImageUrl();
        this.zzl = leaderboardScore0.getScoreHolderHiResImageUrl();
    }

    @Override
    public final boolean equals(Object object0) {
        return LeaderboardScoreEntity.zzc(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getDisplayRank() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayRank(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getDisplayScore() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayScore(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zzc, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRank() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRawScore() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Player getScoreHolder() {
        return this.zzi;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreHolderDisplayName() {
        return this.zzi == null ? this.zzf : this.zzi.getDisplayName();
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer0) {
        PlayerEntity playerEntity0 = this.zzi;
        if(playerEntity0 == null) {
            DataUtils.copyStringToBuffer(this.zzf, charArrayBuffer0);
            return;
        }
        playerEntity0.getDisplayName(charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Uri getScoreHolderHiResImageUri() {
        return this.zzi == null ? this.zzh : this.zzi.getHiResImageUri();
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getScoreHolderHiResImageUrl() {
        return this.zzi == null ? this.zzl : this.zzi.getHiResImageUrl();
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Uri getScoreHolderIconImageUri() {
        return this.zzi == null ? this.zzg : this.zzi.getIconImageUri();
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getScoreHolderIconImageUrl() {
        return this.zzi == null ? this.zzk : this.zzi.getIconImageUrl();
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreTag() {
        return this.zzj;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getTimestampMillis() {
        return this.zze;
    }

    @Override
    public final int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override
    public final String toString() {
        return LeaderboardScoreEntity.zzb(this);
    }

    static int zza(LeaderboardScore leaderboardScore0) {
        return Objects.hashCode(new Object[]{leaderboardScore0.getRank(), leaderboardScore0.getDisplayRank(), leaderboardScore0.getRawScore(), leaderboardScore0.getDisplayScore(), leaderboardScore0.getTimestampMillis(), leaderboardScore0.getScoreHolderDisplayName(), leaderboardScore0.getScoreHolderIconImageUri(), leaderboardScore0.getScoreHolderHiResImageUri(), leaderboardScore0.getScoreHolder()});
    }

    static String zzb(LeaderboardScore leaderboardScore0) {
        ToStringHelper objects$ToStringHelper0 = Objects.toStringHelper(leaderboardScore0).add("Rank", leaderboardScore0.getRank()).add("DisplayRank", leaderboardScore0.getDisplayRank()).add("Score", leaderboardScore0.getRawScore()).add("DisplayScore", leaderboardScore0.getDisplayScore()).add("Timestamp", leaderboardScore0.getTimestampMillis()).add("DisplayName", leaderboardScore0.getScoreHolderDisplayName()).add("IconImageUri", leaderboardScore0.getScoreHolderIconImageUri()).add("IconImageUrl", leaderboardScore0.getScoreHolderIconImageUrl()).add("HiResImageUri", leaderboardScore0.getScoreHolderHiResImageUri()).add("HiResImageUrl", leaderboardScore0.getScoreHolderHiResImageUrl());
        return leaderboardScore0.getScoreHolder() == null ? objects$ToStringHelper0.add("Player", null).add("ScoreTag", leaderboardScore0.getScoreTag()).toString() : objects$ToStringHelper0.add("Player", leaderboardScore0.getScoreHolder()).add("ScoreTag", leaderboardScore0.getScoreTag()).toString();
    }

    // 去混淆评级： 低(40)
    static boolean zzc(LeaderboardScore leaderboardScore0, Object object0) {
        if(!(object0 instanceof LeaderboardScore)) {
            return false;
        }
        return leaderboardScore0 == object0 ? true : Objects.equal(((LeaderboardScore)object0).getRank(), leaderboardScore0.getRank()) && Objects.equal(((LeaderboardScore)object0).getDisplayRank(), leaderboardScore0.getDisplayRank()) && Objects.equal(((LeaderboardScore)object0).getRawScore(), leaderboardScore0.getRawScore()) && Objects.equal(((LeaderboardScore)object0).getDisplayScore(), leaderboardScore0.getDisplayScore()) && Objects.equal(((LeaderboardScore)object0).getTimestampMillis(), leaderboardScore0.getTimestampMillis()) && Objects.equal(((LeaderboardScore)object0).getScoreHolderDisplayName(), leaderboardScore0.getScoreHolderDisplayName()) && Objects.equal(((LeaderboardScore)object0).getScoreHolderIconImageUri(), leaderboardScore0.getScoreHolderIconImageUri()) && Objects.equal(((LeaderboardScore)object0).getScoreHolderHiResImageUri(), leaderboardScore0.getScoreHolderHiResImageUri()) && Objects.equal(((LeaderboardScore)object0).getScoreHolder(), leaderboardScore0.getScoreHolder()) && Objects.equal(((LeaderboardScore)object0).getScoreTag(), leaderboardScore0.getScoreTag());
    }
}

