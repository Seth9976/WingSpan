package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface Game extends Parcelable, Freezable {
    boolean areSnapshotsEnabled();

    int getAchievementTotalCount();

    String getApplicationId();

    String getDescription();

    void getDescription(CharArrayBuffer arg1);

    String getDeveloperName();

    void getDeveloperName(CharArrayBuffer arg1);

    String getDisplayName();

    void getDisplayName(CharArrayBuffer arg1);

    Uri getFeaturedImageUri();

    @Deprecated
    String getFeaturedImageUrl();

    Uri getHiResImageUri();

    @Deprecated
    String getHiResImageUrl();

    Uri getIconImageUri();

    @Deprecated
    String getIconImageUrl();

    int getLeaderboardCount();

    String getPrimaryCategory();

    String getSecondaryCategory();

    String getThemeColor();

    boolean hasGamepadSupport();

    String zza();

    boolean zzb();

    boolean zzc();

    boolean zzd();

    boolean zze();

    @Deprecated
    boolean zzf();

    @Deprecated
    boolean zzg();
}

