package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zza;
import com.google.android.gms.games.internal.player.zzc;
import com.google.android.gms.games.internal.player.zzd;

public final class PlayerRef extends zzq implements Player {
    private final zzd zza;
    private final PlayerLevelInfo zzb;
    private final zzc zzc;
    private final zzx zzd;
    private final com.google.android.gms.games.zzc zze;

    public PlayerRef(DataHolder dataHolder0, int v, String s) {
        super(dataHolder0, v);
        zzd zzd0 = new zzd(null);
        this.zza = zzd0;
        this.zzc = new zzc(dataHolder0, v, zzd0);
        this.zzd = new zzx(dataHolder0, v, zzd0);
        this.zze = new com.google.android.gms.games.zzc(dataHolder0, v, zzd0);
        if(!this.hasNull(zzd0.zzk) && this.getLong(zzd0.zzk) != -1L) {
            int v1 = this.getInteger(zzd0.zzl);
            int v2 = this.getInteger(zzd0.zzo);
            PlayerLevel playerLevel0 = new PlayerLevel(v1, this.getLong(zzd0.zzm), this.getLong(zzd0.zzn));
            PlayerLevel playerLevel1 = v1 == v2 ? playerLevel0 : new PlayerLevel(v2, this.getLong(zzd0.zzn), this.getLong(zzd0.zzp));
            this.zzb = new PlayerLevelInfo(this.getLong(zzd0.zzk), this.getLong(zzd0.zzq), playerLevel0, playerLevel1);
            return;
        }
        this.zzb = null;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object object0) {
        return PlayerEntity.zzo(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return new PlayerEntity(this);
    }

    @Override  // com.google.android.gms.games.Player
    public final Uri getBannerImageLandscapeUri() {
        return this.parseUri(this.zza.zzC);
    }

    @Override  // com.google.android.gms.games.Player
    public String getBannerImageLandscapeUrl() {
        return this.getString(this.zza.zzD);
    }

    @Override  // com.google.android.gms.games.Player
    public final Uri getBannerImagePortraitUri() {
        return this.parseUri(this.zza.zzE);
    }

    @Override  // com.google.android.gms.games.Player
    public String getBannerImagePortraitUrl() {
        return this.getString(this.zza.zzF);
    }

    @Override  // com.google.android.gms.games.Player
    public final CurrentPlayerInfo getCurrentPlayerInfo() {
        return this.zze.zza() ? this.zze : null;
    }

    @Override  // com.google.android.gms.games.Player
    public final String getDisplayName() {
        return this.getString(this.zza.zzc);
    }

    @Override  // com.google.android.gms.games.Player
    public final void getDisplayName(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer(this.zza.zzc, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.Player
    public final Uri getHiResImageUri() {
        return this.parseUri(this.zza.zzf);
    }

    @Override  // com.google.android.gms.games.Player
    public String getHiResImageUrl() {
        return this.getString(this.zza.zzg);
    }

    @Override  // com.google.android.gms.games.Player
    public final Uri getIconImageUri() {
        return this.parseUri(this.zza.zzd);
    }

    @Override  // com.google.android.gms.games.Player
    public String getIconImageUrl() {
        return this.getString(this.zza.zze);
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.Player
    public final long getLastPlayedWithTimestamp() {
        return !this.hasColumn(this.zza.zzj) || this.hasNull(this.zza.zzj) ? -1L : this.getLong(this.zza.zzj);
    }

    @Override  // com.google.android.gms.games.Player
    public final PlayerLevelInfo getLevelInfo() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.Player
    public final String getPlayerId() {
        return this.getString(this.zza.zza);
    }

    @Override  // com.google.android.gms.games.Player
    public final PlayerRelationshipInfo getRelationshipInfo() {
        return this.zzd.getFriendStatus() == -1 && this.zzd.zzb() == null && this.zzd.zza() == null ? null : this.zzd;
    }

    @Override  // com.google.android.gms.games.Player
    public final long getRetrievedTimestamp() {
        return this.getLong(this.zza.zzh);
    }

    @Override  // com.google.android.gms.games.Player
    public final String getTitle() {
        return this.getString(this.zza.zzr);
    }

    @Override  // com.google.android.gms.games.Player
    public final void getTitle(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer(this.zza.zzr, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.Player
    public final boolean hasHiResImage() {
        return this.getHiResImageUri() != null;
    }

    @Override  // com.google.android.gms.games.Player
    public final boolean hasIconImage() {
        return this.getIconImageUri() != null;
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return PlayerEntity.zzj(this);
    }

    @Override
    public final String toString() {
        return PlayerEntity.zzl(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        new PlayerEntity(this).writeToParcel(parcel0, v);
    }

    @Override  // com.google.android.gms.games.Player
    public final int zza() {
        return this.getInteger(this.zza.zzi);
    }

    @Override  // com.google.android.gms.games.Player
    public final long zzb() {
        String s = this.zza.zzG;
        return !this.hasColumn(s) || this.hasNull(s) ? -1L : this.getLong(s);
    }

    @Override  // com.google.android.gms.games.Player
    public final zza zzc() {
        return this.hasNull(this.zza.zzt) ? null : this.zzc;
    }

    @Override  // com.google.android.gms.games.Player
    public final String zzd() {
        return this.zzr(this.zza.zzb, null);
    }

    @Override  // com.google.android.gms.games.Player
    public final String zze() {
        return this.getString(this.zza.zzA);
    }

    @Override  // com.google.android.gms.games.Player
    public final String zzf() {
        return this.getString(this.zza.zzB);
    }

    @Override  // com.google.android.gms.games.Player
    public final boolean zzg() {
        return this.getBoolean(this.zza.zzz);
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.Player
    public final boolean zzh() {
        return this.hasColumn(this.zza.zzM) && this.getBoolean(this.zza.zzM);
    }

    @Override  // com.google.android.gms.games.Player
    public final boolean zzi() {
        return this.getBoolean(this.zza.zzs);
    }
}

