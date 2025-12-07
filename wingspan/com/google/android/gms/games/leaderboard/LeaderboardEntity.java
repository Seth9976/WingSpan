package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {
    private final String zza;
    private final String zzb;
    private final Uri zzc;
    private final int zzd;
    private final ArrayList zze;
    private final Game zzf;
    private final String zzg;

    public LeaderboardEntity(Leaderboard leaderboard0) {
        this.zza = leaderboard0.getLeaderboardId();
        this.zzb = leaderboard0.getDisplayName();
        this.zzc = leaderboard0.getIconImageUri();
        this.zzg = leaderboard0.getIconImageUrl();
        this.zzd = leaderboard0.getScoreOrder();
        Game game0 = leaderboard0.zza();
        this.zzf = game0 == null ? null : new GameEntity(game0);
        ArrayList arrayList0 = leaderboard0.getVariants();
        int v = arrayList0.size();
        this.zze = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = ((LeaderboardVariant)arrayList0.get(v1)).freeze();
            this.zze.add(object0);
        }
    }

    @Override
    public final boolean equals(Object object0) {
        return LeaderboardEntity.zzd(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getDisplayName() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final void getDisplayName(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final Uri getIconImageUri() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public String getIconImageUrl() {
        return this.zzg;
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getLeaderboardId() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final int getScoreOrder() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final ArrayList getVariants() {
        return new ArrayList(this.zze);
    }

    @Override
    public final int hashCode() {
        return LeaderboardEntity.zzb(this);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override
    public final String toString() {
        return LeaderboardEntity.zzc(this);
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboard
    public final Game zza() {
        throw null;
    }

    static int zzb(Leaderboard leaderboard0) {
        return Objects.hashCode(new Object[]{leaderboard0.getLeaderboardId(), leaderboard0.getDisplayName(), leaderboard0.getIconImageUri(), leaderboard0.getScoreOrder(), leaderboard0.getVariants()});
    }

    static String zzc(Leaderboard leaderboard0) {
        return Objects.toStringHelper(leaderboard0).add("LeaderboardId", leaderboard0.getLeaderboardId()).add("DisplayName", leaderboard0.getDisplayName()).add("IconImageUri", leaderboard0.getIconImageUri()).add("IconImageUrl", leaderboard0.getIconImageUrl()).add("ScoreOrder", leaderboard0.getScoreOrder()).add("Variants", leaderboard0.getVariants()).toString();
    }

    // 去混淆评级： 低(23)
    static boolean zzd(Leaderboard leaderboard0, Object object0) {
        if(!(object0 instanceof Leaderboard)) {
            return false;
        }
        return leaderboard0 == object0 ? true : Objects.equal(((Leaderboard)object0).getLeaderboardId(), leaderboard0.getLeaderboardId()) && Objects.equal(((Leaderboard)object0).getDisplayName(), leaderboard0.getDisplayName()) && Objects.equal(((Leaderboard)object0).getIconImageUri(), leaderboard0.getIconImageUri()) && Objects.equal(((Leaderboard)object0).getScoreOrder(), leaderboard0.getScoreOrder()) && Objects.equal(((Leaderboard)object0).getVariants(), leaderboard0.getVariants());
    }
}

