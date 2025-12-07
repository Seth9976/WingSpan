package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Parcelable.Creator CREATOR;
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final Uri zzg;
    private final Uri zzh;
    private final Uri zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final String zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final boolean zzq;
    private final String zzr;
    private final String zzs;
    private final String zzt;
    private final boolean zzu;
    private final boolean zzv;
    private final boolean zzw;
    private final String zzx;
    private final boolean zzy;

    static {
        GameEntity.CREATOR = new zze();
    }

    public GameEntity(Game game0) {
        this.zza = game0.getApplicationId();
        this.zzc = game0.getPrimaryCategory();
        this.zzd = game0.getSecondaryCategory();
        this.zze = game0.getDescription();
        this.zzf = game0.getDeveloperName();
        this.zzb = game0.getDisplayName();
        this.zzg = game0.getIconImageUri();
        this.zzr = game0.getIconImageUrl();
        this.zzh = game0.getHiResImageUri();
        this.zzs = game0.getHiResImageUrl();
        this.zzi = game0.getFeaturedImageUri();
        this.zzt = game0.getFeaturedImageUrl();
        this.zzj = game0.zze();
        this.zzk = game0.zzc();
        this.zzl = game0.zza();
        this.zzm = 1;
        this.zzn = game0.getAchievementTotalCount();
        this.zzo = game0.getLeaderboardCount();
        this.zzp = game0.zzf();
        this.zzq = game0.zzg();
        this.zzu = game0.zzd();
        this.zzv = game0.zzb();
        this.zzw = game0.areSnapshotsEnabled();
        this.zzx = game0.getThemeColor();
        this.zzy = game0.hasGamepadSupport();
    }

    GameEntity(String s, String s1, String s2, String s3, String s4, String s5, Uri uri0, Uri uri1, Uri uri2, boolean z, boolean z1, String s6, int v, int v1, int v2, boolean z2, boolean z3, String s7, String s8, String s9, boolean z4, boolean z5, boolean z6, String s10, boolean z7) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = s2;
        this.zzd = s3;
        this.zze = s4;
        this.zzf = s5;
        this.zzg = uri0;
        this.zzr = s7;
        this.zzh = uri1;
        this.zzs = s8;
        this.zzi = uri2;
        this.zzt = s9;
        this.zzj = z;
        this.zzk = z1;
        this.zzl = s6;
        this.zzm = v;
        this.zzn = v1;
        this.zzo = v2;
        this.zzp = z2;
        this.zzq = z3;
        this.zzu = z4;
        this.zzv = z5;
        this.zzw = z6;
        this.zzx = s10;
        this.zzy = z7;
    }

    @Override  // com.google.android.gms.games.Game
    public boolean areSnapshotsEnabled() {
        return this.zzw;
    }

    @Override
    public boolean equals(Object object0) {
        return GameEntity.zzm(this, object0);
    }

    public Game freeze() {
        return this;
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override  // com.google.android.gms.games.Game
    public int getAchievementTotalCount() {
        return this.zzn;
    }

    @Override  // com.google.android.gms.games.Game
    public String getApplicationId() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.Game
    public String getDescription() {
        return this.zze;
    }

    @Override  // com.google.android.gms.games.Game
    public void getDescription(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zze, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.Game
    public String getDeveloperName() {
        return this.zzf;
    }

    @Override  // com.google.android.gms.games.Game
    public void getDeveloperName(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zzf, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.Game
    public String getDisplayName() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.Game
    public void getDisplayName(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.Game
    public Uri getFeaturedImageUri() {
        return this.zzi;
    }

    @Override  // com.google.android.gms.games.Game
    public String getFeaturedImageUrl() {
        return this.zzt;
    }

    @Override  // com.google.android.gms.games.Game
    public Uri getHiResImageUri() {
        return this.zzh;
    }

    @Override  // com.google.android.gms.games.Game
    public String getHiResImageUrl() {
        return this.zzs;
    }

    @Override  // com.google.android.gms.games.Game
    public Uri getIconImageUri() {
        return this.zzg;
    }

    @Override  // com.google.android.gms.games.Game
    public String getIconImageUrl() {
        return this.zzr;
    }

    @Override  // com.google.android.gms.games.Game
    public int getLeaderboardCount() {
        return this.zzo;
    }

    @Override  // com.google.android.gms.games.Game
    public String getPrimaryCategory() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.games.Game
    public String getSecondaryCategory() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.games.Game
    public String getThemeColor() {
        return this.zzx;
    }

    @Override  // com.google.android.gms.games.Game
    public boolean hasGamepadSupport() {
        return this.zzy;
    }

    @Override
    public int hashCode() {
        return GameEntity.zzh(this);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override
    public String toString() {
        return GameEntity.zzj(this);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        if(this.shouldDowngrade()) {
            parcel0.writeString(this.zza);
            parcel0.writeString(this.zzb);
            parcel0.writeString(this.zzc);
            parcel0.writeString(this.zzd);
            parcel0.writeString(this.zze);
            parcel0.writeString(this.zzf);
            String s = null;
            parcel0.writeString((this.zzg == null ? null : this.zzg.toString()));
            parcel0.writeString((this.zzh == null ? null : this.zzh.toString()));
            Uri uri0 = this.zzi;
            if(uri0 != null) {
                s = uri0.toString();
            }
            parcel0.writeString(s);
            parcel0.writeInt(((int)this.zzj));
            parcel0.writeInt(((int)this.zzk));
            parcel0.writeString(this.zzl);
            parcel0.writeInt(this.zzm);
            parcel0.writeInt(this.zzn);
            parcel0.writeInt(this.zzo);
            return;
        }
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.getApplicationId(), false);
        SafeParcelWriter.writeString(parcel0, 2, this.getDisplayName(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getPrimaryCategory(), false);
        SafeParcelWriter.writeString(parcel0, 4, this.getSecondaryCategory(), false);
        SafeParcelWriter.writeString(parcel0, 5, this.getDescription(), false);
        SafeParcelWriter.writeString(parcel0, 6, this.getDeveloperName(), false);
        SafeParcelWriter.writeParcelable(parcel0, 7, this.getIconImageUri(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 8, this.getHiResImageUri(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 9, this.getFeaturedImageUri(), v, false);
        SafeParcelWriter.writeBoolean(parcel0, 10, this.zzj);
        SafeParcelWriter.writeBoolean(parcel0, 11, this.zzk);
        SafeParcelWriter.writeString(parcel0, 12, this.zzl, false);
        SafeParcelWriter.writeInt(parcel0, 13, this.zzm);
        SafeParcelWriter.writeInt(parcel0, 14, this.getAchievementTotalCount());
        SafeParcelWriter.writeInt(parcel0, 15, this.getLeaderboardCount());
        SafeParcelWriter.writeBoolean(parcel0, 16, this.zzp);
        SafeParcelWriter.writeBoolean(parcel0, 17, this.zzq);
        SafeParcelWriter.writeString(parcel0, 18, this.getIconImageUrl(), false);
        SafeParcelWriter.writeString(parcel0, 19, this.getHiResImageUrl(), false);
        SafeParcelWriter.writeString(parcel0, 20, this.getFeaturedImageUrl(), false);
        SafeParcelWriter.writeBoolean(parcel0, 21, this.zzu);
        SafeParcelWriter.writeBoolean(parcel0, 22, this.zzv);
        SafeParcelWriter.writeBoolean(parcel0, 23, this.areSnapshotsEnabled());
        SafeParcelWriter.writeString(parcel0, 24, this.getThemeColor(), false);
        SafeParcelWriter.writeBoolean(parcel0, 25, this.hasGamepadSupport());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.games.Game
    public final String zza() {
        return this.zzl;
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean zzb() {
        return this.zzv;
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean zzc() {
        return this.zzk;
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean zzd() {
        return this.zzu;
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean zze() {
        return this.zzj;
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean zzf() {
        return this.zzp;
    }

    @Override  // com.google.android.gms.games.Game
    public final boolean zzg() {
        return this.zzq;
    }

    static int zzh(Game game0) {
        return Objects.hashCode(new Object[]{game0.getApplicationId(), game0.getDisplayName(), game0.getPrimaryCategory(), game0.getSecondaryCategory(), game0.getDescription(), game0.getDeveloperName(), game0.getIconImageUri(), game0.getHiResImageUri(), game0.getFeaturedImageUri(), Boolean.valueOf(game0.zze()), Boolean.valueOf(game0.zzc()), game0.zza(), game0.getAchievementTotalCount(), game0.getLeaderboardCount(), Boolean.valueOf(game0.zzf()), Boolean.valueOf(game0.zzg()), Boolean.valueOf(game0.zzd()), Boolean.valueOf(game0.zzb()), Boolean.valueOf(game0.areSnapshotsEnabled()), game0.getThemeColor(), Boolean.valueOf(game0.hasGamepadSupport())});
    }

    static String zzj(Game game0) {
        return Objects.toStringHelper(game0).add("ApplicationId", game0.getApplicationId()).add("DisplayName", game0.getDisplayName()).add("PrimaryCategory", game0.getPrimaryCategory()).add("SecondaryCategory", game0.getSecondaryCategory()).add("Description", game0.getDescription()).add("DeveloperName", game0.getDeveloperName()).add("IconImageUri", game0.getIconImageUri()).add("IconImageUrl", game0.getIconImageUrl()).add("HiResImageUri", game0.getHiResImageUri()).add("HiResImageUrl", game0.getHiResImageUrl()).add("FeaturedImageUri", game0.getFeaturedImageUri()).add("FeaturedImageUrl", game0.getFeaturedImageUrl()).add("PlayEnabledGame", Boolean.valueOf(game0.zze())).add("InstanceInstalled", Boolean.valueOf(game0.zzc())).add("InstancePackageName", game0.zza()).add("AchievementTotalCount", game0.getAchievementTotalCount()).add("LeaderboardCount", game0.getLeaderboardCount()).add("AreSnapshotsEnabled", Boolean.valueOf(game0.areSnapshotsEnabled())).add("ThemeColor", game0.getThemeColor()).add("HasGamepadSupport", Boolean.valueOf(game0.hasGamepadSupport())).toString();
    }

    // 去混淆评级： 低(36)
    static boolean zzm(Game game0, Object object0) {
        if(!(object0 instanceof Game)) {
            return false;
        }
        if(game0 == object0) {
            return true;
        }
        Game game1 = (Game)object0;
        return Objects.equal(game1.getApplicationId(), game0.getApplicationId()) && Objects.equal(game1.getDisplayName(), game0.getDisplayName()) && Objects.equal(game1.getPrimaryCategory(), game0.getPrimaryCategory()) && Objects.equal(game1.getSecondaryCategory(), game0.getSecondaryCategory()) && Objects.equal(game1.getDescription(), game0.getDescription()) && Objects.equal(game1.getDeveloperName(), game0.getDeveloperName()) && Objects.equal(game1.getIconImageUri(), game0.getIconImageUri()) && Objects.equal(game1.getHiResImageUri(), game0.getHiResImageUri()) && Objects.equal(game1.getFeaturedImageUri(), game0.getFeaturedImageUri()) && Objects.equal(Boolean.valueOf(game1.zze()), Boolean.valueOf(game0.zze())) && Objects.equal(Boolean.valueOf(game1.zzc()), Boolean.valueOf(game0.zzc())) && Objects.equal(game1.zza(), game0.zza()) && Objects.equal(game1.getAchievementTotalCount(), game0.getAchievementTotalCount()) && Objects.equal(game1.getLeaderboardCount(), game0.getLeaderboardCount()) && Objects.equal(Boolean.valueOf(game1.zzf()), Boolean.valueOf(game0.zzf())) && Objects.equal(Boolean.valueOf(game1.zzg()), Boolean.valueOf(game0.zzg())) && Objects.equal(Boolean.valueOf(game1.zzd()), Boolean.valueOf(game0.zzd())) && Objects.equal(Boolean.valueOf(game1.zzb()), Boolean.valueOf(game0.zzb())) && Objects.equal(Boolean.valueOf(game1.areSnapshotsEnabled()), Boolean.valueOf(game0.areSnapshotsEnabled())) && Objects.equal(game1.getThemeColor(), game0.getThemeColor()) && Objects.equal(Boolean.valueOf(game1.hasGamepadSupport()), Boolean.valueOf(game0.hasGamepadSupport()));
    }
}

