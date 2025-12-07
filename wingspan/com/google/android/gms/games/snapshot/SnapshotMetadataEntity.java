package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzc;

public final class SnapshotMetadataEntity extends zzc implements SnapshotMetadata {
    public static final Parcelable.Creator CREATOR;
    private final GameEntity zza;
    private final PlayerEntity zzb;
    private final String zzc;
    private final Uri zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final long zzh;
    private final long zzi;
    private final float zzj;
    private final String zzk;
    private final boolean zzl;
    private final long zzm;
    private final String zzn;

    static {
        SnapshotMetadataEntity.CREATOR = new zzd();
    }

    SnapshotMetadataEntity(GameEntity gameEntity0, PlayerEntity playerEntity0, String s, Uri uri0, String s1, String s2, String s3, long v, long v1, float f, String s4, boolean z, long v2, String s5) {
        this.zza = gameEntity0;
        this.zzb = playerEntity0;
        this.zzc = s;
        this.zzd = uri0;
        this.zze = s1;
        this.zzj = f;
        this.zzf = s2;
        this.zzg = s3;
        this.zzh = v;
        this.zzi = v1;
        this.zzk = s4;
        this.zzl = z;
        this.zzm = v2;
        this.zzn = s5;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata0) {
        PlayerEntity playerEntity0 = new PlayerEntity(snapshotMetadata0.getOwner());
        super();
        this.zza = new GameEntity(snapshotMetadata0.getGame());
        this.zzb = playerEntity0;
        this.zzc = snapshotMetadata0.getSnapshotId();
        this.zzd = snapshotMetadata0.getCoverImageUri();
        this.zze = snapshotMetadata0.getCoverImageUrl();
        this.zzj = snapshotMetadata0.getCoverImageAspectRatio();
        this.zzf = snapshotMetadata0.zza();
        this.zzg = snapshotMetadata0.getDescription();
        this.zzh = snapshotMetadata0.getLastModifiedTimestamp();
        this.zzi = snapshotMetadata0.getPlayedTime();
        this.zzk = snapshotMetadata0.getUniqueName();
        this.zzl = snapshotMetadata0.hasChangePending();
        this.zzm = snapshotMetadata0.getProgressValue();
        this.zzn = snapshotMetadata0.getDeviceName();
    }

    @Override
    public boolean equals(Object object0) {
        return SnapshotMetadataEntity.zzd(this, object0);
    }

    public SnapshotMetadata freeze() {
        return this;
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public float getCoverImageAspectRatio() {
        return this.zzj;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public Uri getCoverImageUri() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String getCoverImageUrl() {
        return this.zze;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String getDescription() {
        return this.zzg;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public void getDescription(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zzg, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String getDeviceName() {
        return this.zzn;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public Game getGame() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long getLastModifiedTimestamp() {
        return this.zzh;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public Player getOwner() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long getPlayedTime() {
        return this.zzi;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long getProgressValue() {
        return this.zzm;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String getSnapshotId() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String getUniqueName() {
        return this.zzk;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public boolean hasChangePending() {
        return this.zzl;
    }

    @Override
    public int hashCode() {
        return SnapshotMetadataEntity.zzb(this);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override
    public String toString() {
        return SnapshotMetadataEntity.zzc(this);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.getGame(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.getOwner(), v, false);
        SafeParcelWriter.writeString(parcel0, 3, this.getSnapshotId(), false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.getCoverImageUri(), v, false);
        SafeParcelWriter.writeString(parcel0, 6, this.getCoverImageUrl(), false);
        SafeParcelWriter.writeString(parcel0, 7, this.zzf, false);
        SafeParcelWriter.writeString(parcel0, 8, this.getDescription(), false);
        SafeParcelWriter.writeLong(parcel0, 9, this.getLastModifiedTimestamp());
        SafeParcelWriter.writeLong(parcel0, 10, this.getPlayedTime());
        SafeParcelWriter.writeFloat(parcel0, 11, this.getCoverImageAspectRatio());
        SafeParcelWriter.writeString(parcel0, 12, this.getUniqueName(), false);
        SafeParcelWriter.writeBoolean(parcel0, 13, this.hasChangePending());
        SafeParcelWriter.writeLong(parcel0, 14, this.getProgressValue());
        SafeParcelWriter.writeString(parcel0, 15, this.getDeviceName(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final String zza() {
        return this.zzf;
    }

    static int zzb(SnapshotMetadata snapshotMetadata0) {
        return Objects.hashCode(new Object[]{snapshotMetadata0.getGame(), snapshotMetadata0.getOwner(), snapshotMetadata0.getSnapshotId(), snapshotMetadata0.getCoverImageUri(), snapshotMetadata0.getCoverImageAspectRatio(), snapshotMetadata0.zza(), snapshotMetadata0.getDescription(), snapshotMetadata0.getLastModifiedTimestamp(), snapshotMetadata0.getPlayedTime(), snapshotMetadata0.getUniqueName(), Boolean.valueOf(snapshotMetadata0.hasChangePending()), snapshotMetadata0.getProgressValue(), snapshotMetadata0.getDeviceName()});
    }

    static String zzc(SnapshotMetadata snapshotMetadata0) {
        return Objects.toStringHelper(snapshotMetadata0).add("Game", snapshotMetadata0.getGame()).add("Owner", snapshotMetadata0.getOwner()).add("SnapshotId", snapshotMetadata0.getSnapshotId()).add("CoverImageUri", snapshotMetadata0.getCoverImageUri()).add("CoverImageUrl", snapshotMetadata0.getCoverImageUrl()).add("CoverImageAspectRatio", snapshotMetadata0.getCoverImageAspectRatio()).add("Description", snapshotMetadata0.getDescription()).add("LastModifiedTimestamp", snapshotMetadata0.getLastModifiedTimestamp()).add("PlayedTime", snapshotMetadata0.getPlayedTime()).add("UniqueName", snapshotMetadata0.getUniqueName()).add("ChangePending", Boolean.valueOf(snapshotMetadata0.hasChangePending())).add("ProgressValue", snapshotMetadata0.getProgressValue()).add("DeviceName", snapshotMetadata0.getDeviceName()).toString();
    }

    // 去混淆评级： 中等(50)
    static boolean zzd(SnapshotMetadata snapshotMetadata0, Object object0) {
        if(!(object0 instanceof SnapshotMetadata)) {
            return false;
        }
        return snapshotMetadata0 == object0 ? true : Objects.equal(((SnapshotMetadata)object0).getGame(), snapshotMetadata0.getGame()) && Objects.equal(((SnapshotMetadata)object0).getOwner(), snapshotMetadata0.getOwner()) && Objects.equal(((SnapshotMetadata)object0).getSnapshotId(), snapshotMetadata0.getSnapshotId()) && Objects.equal(((SnapshotMetadata)object0).getCoverImageUri(), snapshotMetadata0.getCoverImageUri()) && Objects.equal(((SnapshotMetadata)object0).getCoverImageAspectRatio(), snapshotMetadata0.getCoverImageAspectRatio()) && Objects.equal(((SnapshotMetadata)object0).zza(), snapshotMetadata0.zza()) && Objects.equal(((SnapshotMetadata)object0).getDescription(), snapshotMetadata0.getDescription()) && Objects.equal(((SnapshotMetadata)object0).getLastModifiedTimestamp(), snapshotMetadata0.getLastModifiedTimestamp()) && Objects.equal(((SnapshotMetadata)object0).getPlayedTime(), snapshotMetadata0.getPlayedTime()) && Objects.equal(((SnapshotMetadata)object0).getUniqueName(), snapshotMetadata0.getUniqueName()) && Objects.equal(Boolean.valueOf(((SnapshotMetadata)object0).hasChangePending()), Boolean.valueOf(snapshotMetadata0.hasChangePending())) && Objects.equal(((SnapshotMetadata)object0).getProgressValue(), snapshotMetadata0.getProgressValue()) && Objects.equal(((SnapshotMetadata)object0).getDeviceName(), snapshotMetadata0.getDeviceName());
    }
}

