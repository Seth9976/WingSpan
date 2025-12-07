package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Parcelable.Creator CREATOR;
    private String zza;
    private String zzb;
    private final Uri zzc;
    private final Uri zzd;
    private final long zze;
    private final int zzf;
    private final long zzg;
    private final String zzh;
    private final String zzi;
    private final String zzj;
    private final MostRecentGameInfoEntity zzk;
    private final PlayerLevelInfo zzl;
    private final boolean zzm;
    private final boolean zzn;
    private final String zzo;
    private final String zzp;
    private final Uri zzq;
    private final String zzr;
    private final Uri zzs;
    private final String zzt;
    private long zzu;
    private final zzv zzv;
    private final zza zzw;
    private boolean zzx;
    private final String zzy;

    static {
        PlayerEntity.CREATOR = new zzr();
    }

    public PlayerEntity(Player player0) {
        this.zza = player0.getPlayerId();
        this.zzb = player0.getDisplayName();
        this.zzc = player0.getIconImageUri();
        this.zzh = player0.getIconImageUrl();
        this.zzd = player0.getHiResImageUri();
        this.zzi = player0.getHiResImageUrl();
        long v = player0.getRetrievedTimestamp();
        this.zze = v;
        this.zzf = player0.zza();
        this.zzg = player0.getLastPlayedWithTimestamp();
        this.zzj = player0.getTitle();
        this.zzm = player0.zzi();
        com.google.android.gms.games.internal.player.zza zza0 = player0.zzc();
        Object object0 = null;
        this.zzk = zza0 == null ? null : new MostRecentGameInfoEntity(zza0);
        this.zzl = player0.getLevelInfo();
        this.zzn = player0.zzg();
        this.zzo = player0.zze();
        this.zzp = player0.zzf();
        this.zzq = player0.getBannerImageLandscapeUri();
        this.zzr = player0.getBannerImageLandscapeUrl();
        this.zzs = player0.getBannerImagePortraitUri();
        this.zzt = player0.getBannerImagePortraitUrl();
        this.zzu = player0.zzb();
        PlayerRelationshipInfo playerRelationshipInfo0 = player0.getRelationshipInfo();
        this.zzv = playerRelationshipInfo0 == null ? null : new zzv(((PlayerRelationshipInfo)playerRelationshipInfo0.freeze()));
        CurrentPlayerInfo currentPlayerInfo0 = player0.getCurrentPlayerInfo();
        if(currentPlayerInfo0 != null) {
            object0 = currentPlayerInfo0.freeze();
        }
        this.zzw = (zza)object0;
        this.zzx = player0.zzh();
        this.zzy = player0.zzd();
        Asserts.checkNotNull(this.zza);
        Asserts.checkNotNull(this.zzb);
        Asserts.checkState(v > 0L);
    }

    PlayerEntity(String s, String s1, Uri uri0, Uri uri1, long v, int v1, long v2, String s2, String s3, String s4, MostRecentGameInfoEntity mostRecentGameInfoEntity0, PlayerLevelInfo playerLevelInfo0, boolean z, boolean z1, String s5, String s6, Uri uri2, String s7, Uri uri3, String s8, long v3, zzv zzv0, zza zza0, boolean z2, String s9) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = uri0;
        this.zzh = s2;
        this.zzd = uri1;
        this.zzi = s3;
        this.zze = v;
        this.zzf = v1;
        this.zzg = v2;
        this.zzj = s4;
        this.zzm = z;
        this.zzk = mostRecentGameInfoEntity0;
        this.zzl = playerLevelInfo0;
        this.zzn = z1;
        this.zzo = s5;
        this.zzp = s6;
        this.zzq = uri2;
        this.zzr = s7;
        this.zzs = uri3;
        this.zzt = s8;
        this.zzu = v3;
        this.zzv = zzv0;
        this.zzw = zza0;
        this.zzx = z2;
        this.zzy = s9;
    }

    @Override
    public boolean equals(Object object0) {
        return PlayerEntity.zzo(this, object0);
    }

    public Player freeze() {
        return this;
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override  // com.google.android.gms.games.Player
    public Uri getBannerImageLandscapeUri() {
        return this.zzq;
    }

    @Override  // com.google.android.gms.games.Player
    public String getBannerImageLandscapeUrl() {
        return this.zzr;
    }

    @Override  // com.google.android.gms.games.Player
    public Uri getBannerImagePortraitUri() {
        return this.zzs;
    }

    @Override  // com.google.android.gms.games.Player
    public String getBannerImagePortraitUrl() {
        return this.zzt;
    }

    @Override  // com.google.android.gms.games.Player
    public CurrentPlayerInfo getCurrentPlayerInfo() {
        return this.zzw;
    }

    @Override  // com.google.android.gms.games.Player
    public String getDisplayName() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.Player
    public void getDisplayName(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.Player
    public Uri getHiResImageUri() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.games.Player
    public String getHiResImageUrl() {
        return this.zzi;
    }

    @Override  // com.google.android.gms.games.Player
    public Uri getIconImageUri() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.games.Player
    public String getIconImageUrl() {
        return this.zzh;
    }

    @Override  // com.google.android.gms.games.Player
    public long getLastPlayedWithTimestamp() {
        return this.zzg;
    }

    @Override  // com.google.android.gms.games.Player
    public PlayerLevelInfo getLevelInfo() {
        return this.zzl;
    }

    @Override  // com.google.android.gms.games.Player
    public String getPlayerId() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.Player
    public PlayerRelationshipInfo getRelationshipInfo() {
        return this.zzv;
    }

    @Override  // com.google.android.gms.games.Player
    public long getRetrievedTimestamp() {
        return this.zze;
    }

    @Override  // com.google.android.gms.games.Player
    public String getTitle() {
        return this.zzj;
    }

    @Override  // com.google.android.gms.games.Player
    public void getTitle(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zzj, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.Player
    public boolean hasHiResImage() {
        return this.getHiResImageUri() != null;
    }

    @Override  // com.google.android.gms.games.Player
    public boolean hasIconImage() {
        return this.getIconImageUri() != null;
    }

    @Override
    public int hashCode() {
        return PlayerEntity.zzj(this);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override
    public String toString() {
        return PlayerEntity.zzl(this);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        if(this.shouldDowngrade()) {
            parcel0.writeString(this.zza);
            parcel0.writeString(this.zzb);
            String s = null;
            parcel0.writeString((this.zzc == null ? null : this.zzc.toString()));
            Uri uri0 = this.zzd;
            if(uri0 != null) {
                s = uri0.toString();
            }
            parcel0.writeString(s);
            parcel0.writeLong(this.zze);
            return;
        }
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.getPlayerId(), false);
        SafeParcelWriter.writeString(parcel0, 2, this.getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.getIconImageUri(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.getHiResImageUri(), v, false);
        SafeParcelWriter.writeLong(parcel0, 5, this.getRetrievedTimestamp());
        SafeParcelWriter.writeInt(parcel0, 6, this.zzf);
        SafeParcelWriter.writeLong(parcel0, 7, this.getLastPlayedWithTimestamp());
        SafeParcelWriter.writeString(parcel0, 8, this.getIconImageUrl(), false);
        SafeParcelWriter.writeString(parcel0, 9, this.getHiResImageUrl(), false);
        SafeParcelWriter.writeString(parcel0, 14, this.getTitle(), false);
        SafeParcelWriter.writeParcelable(parcel0, 15, this.zzk, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 16, this.getLevelInfo(), v, false);
        SafeParcelWriter.writeBoolean(parcel0, 18, this.zzm);
        SafeParcelWriter.writeBoolean(parcel0, 19, this.zzn);
        SafeParcelWriter.writeString(parcel0, 20, this.zzo, false);
        SafeParcelWriter.writeString(parcel0, 21, this.zzp, false);
        SafeParcelWriter.writeParcelable(parcel0, 22, this.getBannerImageLandscapeUri(), v, false);
        SafeParcelWriter.writeString(parcel0, 23, this.getBannerImageLandscapeUrl(), false);
        SafeParcelWriter.writeParcelable(parcel0, 24, this.getBannerImagePortraitUri(), v, false);
        SafeParcelWriter.writeString(parcel0, 25, this.getBannerImagePortraitUrl(), false);
        SafeParcelWriter.writeLong(parcel0, 29, this.zzu);
        SafeParcelWriter.writeParcelable(parcel0, 33, this.getRelationshipInfo(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 35, this.getCurrentPlayerInfo(), v, false);
        SafeParcelWriter.writeBoolean(parcel0, 36, this.zzx);
        SafeParcelWriter.writeString(parcel0, 37, this.zzy, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.games.Player
    public final int zza() {
        return this.zzf;
    }

    @Override  // com.google.android.gms.games.Player
    public final long zzb() {
        return this.zzu;
    }

    @Override  // com.google.android.gms.games.Player
    public final com.google.android.gms.games.internal.player.zza zzc() {
        return this.zzk;
    }

    @Override  // com.google.android.gms.games.Player
    public final String zzd() {
        return this.zzy;
    }

    @Override  // com.google.android.gms.games.Player
    public final String zze() {
        return this.zzo;
    }

    @Override  // com.google.android.gms.games.Player
    public final String zzf() {
        return this.zzp;
    }

    @Override  // com.google.android.gms.games.Player
    public final boolean zzg() {
        return this.zzn;
    }

    @Override  // com.google.android.gms.games.Player
    public final boolean zzh() {
        return this.zzx;
    }

    @Override  // com.google.android.gms.games.Player
    public final boolean zzi() {
        return this.zzm;
    }

    static int zzj(Player player0) {
        return Objects.hashCode(new Object[]{player0.getPlayerId(), player0.getDisplayName(), Boolean.valueOf(player0.zzg()), player0.getIconImageUri(), player0.getHiResImageUri(), player0.getRetrievedTimestamp(), player0.getTitle(), player0.getLevelInfo(), player0.zze(), player0.zzf(), player0.getBannerImageLandscapeUri(), player0.getBannerImagePortraitUri(), player0.zzb(), player0.getRelationshipInfo(), player0.getCurrentPlayerInfo(), Boolean.valueOf(player0.zzh()), player0.zzd()});
    }

    static String zzl(Player player0) {
        ToStringHelper objects$ToStringHelper0 = Objects.toStringHelper(player0).add("PlayerId", player0.getPlayerId()).add("DisplayName", player0.getDisplayName()).add("HasDebugAccess", Boolean.valueOf(player0.zzg())).add("IconImageUri", player0.getIconImageUri()).add("IconImageUrl", player0.getIconImageUrl()).add("HiResImageUri", player0.getHiResImageUri()).add("HiResImageUrl", player0.getHiResImageUrl()).add("RetrievedTimestamp", player0.getRetrievedTimestamp()).add("Title", player0.getTitle()).add("LevelInfo", player0.getLevelInfo()).add("GamerTag", player0.zze()).add("Name", player0.zzf()).add("BannerImageLandscapeUri", player0.getBannerImageLandscapeUri()).add("BannerImageLandscapeUrl", player0.getBannerImageLandscapeUrl()).add("BannerImagePortraitUri", player0.getBannerImagePortraitUri()).add("BannerImagePortraitUrl", player0.getBannerImagePortraitUrl()).add("CurrentPlayerInfo", player0.getCurrentPlayerInfo()).add("TotalUnlockedAchievement", player0.zzb());
        if(player0.zzh()) {
            objects$ToStringHelper0.add("AlwaysAutoSignIn", Boolean.valueOf(player0.zzh()));
        }
        if(player0.getRelationshipInfo() != null) {
            objects$ToStringHelper0.add("RelationshipInfo", player0.getRelationshipInfo());
        }
        if(player0.zzd() != null) {
            objects$ToStringHelper0.add("GamePlayerId", player0.zzd());
        }
        return objects$ToStringHelper0.toString();
    }

    // 去混淆评级： 中等(63)
    static boolean zzo(Player player0, Object object0) {
        if(!(object0 instanceof Player)) {
            return false;
        }
        return player0 == object0 ? true : Objects.equal(((Player)object0).getPlayerId(), player0.getPlayerId()) && Objects.equal(((Player)object0).getDisplayName(), player0.getDisplayName()) && Objects.equal(Boolean.valueOf(((Player)object0).zzg()), Boolean.valueOf(player0.zzg())) && Objects.equal(((Player)object0).getIconImageUri(), player0.getIconImageUri()) && Objects.equal(((Player)object0).getHiResImageUri(), player0.getHiResImageUri()) && Objects.equal(((Player)object0).getRetrievedTimestamp(), player0.getRetrievedTimestamp()) && Objects.equal(((Player)object0).getTitle(), player0.getTitle()) && Objects.equal(((Player)object0).getLevelInfo(), player0.getLevelInfo()) && Objects.equal(((Player)object0).zze(), player0.zze()) && Objects.equal(((Player)object0).zzf(), player0.zzf()) && Objects.equal(((Player)object0).getBannerImageLandscapeUri(), player0.getBannerImageLandscapeUri()) && Objects.equal(((Player)object0).getBannerImagePortraitUri(), player0.getBannerImagePortraitUri()) && Objects.equal(((Player)object0).zzb(), player0.zzb()) && Objects.equal(((Player)object0).getCurrentPlayerInfo(), player0.getCurrentPlayerInfo()) && Objects.equal(((Player)object0).getRelationshipInfo(), player0.getRelationshipInfo()) && Objects.equal(Boolean.valueOf(((Player)object0).zzh()), Boolean.valueOf(player0.zzh())) && Objects.equal(((Player)object0).zzd(), player0.zzd());
    }
}

