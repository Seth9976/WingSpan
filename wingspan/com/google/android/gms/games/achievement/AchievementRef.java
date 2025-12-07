package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class AchievementRef extends DataBufferRef implements Achievement {
    AchievementRef(DataHolder dataHolder0, int v) {
        super(dataHolder0, v);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object object0) {
        return AchievementEntity.zzf(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return new AchievementEntity(this);
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final String getAchievementId() {
        return this.getString("external_achievement_id");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final int getCurrentSteps() {
        Asserts.checkState(this.getInteger("type") == 1);
        return this.getInteger("current_steps");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final String getDescription() {
        return this.getString("description");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final void getDescription(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer("description", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final String getFormattedCurrentSteps() {
        Asserts.checkState(this.getInteger("type") == 1);
        return this.getString("formatted_current_steps");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer0) {
        Asserts.checkState(this.getInteger("type") == 1);
        this.copyToBuffer("formatted_current_steps", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final String getFormattedTotalSteps() {
        Asserts.checkState(this.getInteger("type") == 1);
        return this.getString("formatted_total_steps");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer0) {
        Asserts.checkState(this.getInteger("type") == 1);
        this.copyToBuffer("formatted_total_steps", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final long getLastUpdatedTimestamp() {
        return this.getLong("last_updated_timestamp");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final String getName() {
        return this.getString("name");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final void getName(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer("name", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final Player getPlayer() {
        return (Player)Preconditions.checkNotNull(this.zzb());
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final Uri getRevealedImageUri() {
        return this.parseUri("revealed_icon_image_uri");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public String getRevealedImageUrl() {
        return this.getString("revealed_icon_image_url");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final int getState() {
        return this.getInteger("state");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final int getTotalSteps() {
        Asserts.checkState(this.getInteger("type") == 1);
        return this.getInteger("total_steps");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final int getType() {
        return this.getInteger("type");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final Uri getUnlockedImageUri() {
        return this.parseUri("unlocked_icon_image_uri");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public String getUnlockedImageUrl() {
        return this.getString("unlocked_icon_image_url");
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.achievement.Achievement
    public final long getXpValue() {
        return !this.hasColumn("instance_xp_value") || this.hasNull("instance_xp_value") ? this.getLong("definition_xp_value") : this.getLong("instance_xp_value");
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return AchievementEntity.zzd(this);
    }

    @Override
    public final String toString() {
        return AchievementEntity.zze(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        new AchievementEntity(this).writeToParcel(parcel0, v);
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.achievement.Achievement
    public final float zza() {
        return !this.hasColumn("rarity_percent") || this.hasNull("rarity_percent") ? -1.0f : this.getFloat("rarity_percent");
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final Player zzb() {
        return this.hasNull("external_player_id") ? null : new PlayerRef(this.mDataHolder, this.mDataRow, null);
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final String zzc() {
        return this.getString("external_game_id");
    }
}

