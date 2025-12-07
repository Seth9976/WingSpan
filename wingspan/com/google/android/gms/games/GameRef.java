package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

public final class GameRef extends DataBufferRef implements Game {
    public GameRef(DataHolder dataHolder0, int v) {
        super(dataHolder0, v);
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean areSnapshotsEnabled() {
        return this.getInteger("snapshots_enabled") > 0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object object0) {
        return GameEntity.zzm(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return new GameEntity(this);
    }

    @Override  // com.google.android.gms.games.Game
    public final int getAchievementTotalCount() {
        return this.getInteger("achievement_total_count");
    }

    @Override  // com.google.android.gms.games.Game
    public final String getApplicationId() {
        return this.getString("external_game_id");
    }

    @Override  // com.google.android.gms.games.Game
    public final String getDescription() {
        return this.getString("game_description");
    }

    @Override  // com.google.android.gms.games.Game
    public final void getDescription(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer("game_description", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.Game
    public final String getDeveloperName() {
        return this.getString("developer_name");
    }

    @Override  // com.google.android.gms.games.Game
    public final void getDeveloperName(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer("developer_name", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.Game
    public final String getDisplayName() {
        return this.getString("display_name");
    }

    @Override  // com.google.android.gms.games.Game
    public final void getDisplayName(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer("display_name", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.Game
    public final Uri getFeaturedImageUri() {
        return this.parseUri("featured_image_uri");
    }

    @Override  // com.google.android.gms.games.Game
    public String getFeaturedImageUrl() {
        return this.getString("featured_image_url");
    }

    @Override  // com.google.android.gms.games.Game
    public final Uri getHiResImageUri() {
        return this.parseUri("game_hi_res_image_uri");
    }

    @Override  // com.google.android.gms.games.Game
    public String getHiResImageUrl() {
        return this.getString("game_hi_res_image_url");
    }

    @Override  // com.google.android.gms.games.Game
    public final Uri getIconImageUri() {
        return this.parseUri("game_icon_image_uri");
    }

    @Override  // com.google.android.gms.games.Game
    public String getIconImageUrl() {
        return this.getString("game_icon_image_url");
    }

    @Override  // com.google.android.gms.games.Game
    public final int getLeaderboardCount() {
        return this.getInteger("leaderboard_count");
    }

    @Override  // com.google.android.gms.games.Game
    public final String getPrimaryCategory() {
        return this.getString("primary_category");
    }

    @Override  // com.google.android.gms.games.Game
    public final String getSecondaryCategory() {
        return this.getString("secondary_category");
    }

    @Override  // com.google.android.gms.games.Game
    public final String getThemeColor() {
        return this.getString("theme_color");
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean hasGamepadSupport() {
        return this.getInteger("gamepad_support") > 0;
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return GameEntity.zzh(this);
    }

    @Override
    public final String toString() {
        return GameEntity.zzj(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        new GameEntity(this).writeToParcel(parcel0, v);
    }

    @Override  // com.google.android.gms.games.Game
    public final String zza() {
        return this.getString("package_name");
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean zzb() {
        return this.getBoolean("identity_sharing_confirmed");
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean zzc() {
        return this.getInteger("installed") > 0;
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean zzd() {
        return this.getBoolean("muted");
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean zze() {
        return this.getBoolean("play_enabled_game");
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean zzf() {
        return this.getInteger("real_time_support") > 0;
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean zzg() {
        return this.getInteger("turn_based_support") > 0;
    }
}

