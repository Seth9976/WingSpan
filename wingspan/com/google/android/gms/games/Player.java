package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.internal.player.zza;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Player extends Parcelable, Freezable {
    @Retention(RetentionPolicy.SOURCE)
    public @interface FriendsListVisibilityStatus {
        public static final int FEATURE_UNAVAILABLE = 3;
        public static final int REQUEST_REQUIRED = 2;
        public static final int UNKNOWN = 0;
        public static final int VISIBLE = 1;

    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerFriendStatus {
        public static final int FRIEND = 4;
        public static final int NO_RELATIONSHIP = 0;
        public static final int UNKNOWN = -1;

    }

    public static final long CURRENT_XP_UNKNOWN = -1L;
    public static final long TIMESTAMP_UNKNOWN = -1L;

    Uri getBannerImageLandscapeUri();

    @Deprecated
    String getBannerImageLandscapeUrl();

    Uri getBannerImagePortraitUri();

    @Deprecated
    String getBannerImagePortraitUrl();

    CurrentPlayerInfo getCurrentPlayerInfo();

    String getDisplayName();

    void getDisplayName(CharArrayBuffer arg1);

    Uri getHiResImageUri();

    @Deprecated
    String getHiResImageUrl();

    Uri getIconImageUri();

    @Deprecated
    String getIconImageUrl();

    @Deprecated
    long getLastPlayedWithTimestamp();

    PlayerLevelInfo getLevelInfo();

    String getPlayerId();

    PlayerRelationshipInfo getRelationshipInfo();

    long getRetrievedTimestamp();

    String getTitle();

    void getTitle(CharArrayBuffer arg1);

    boolean hasHiResImage();

    boolean hasIconImage();

    @Deprecated
    int zza();

    long zzb();

    zza zzc();

    String zzd();

    String zze();

    String zzf();

    boolean zzg();

    boolean zzh();

    boolean zzi();
}

