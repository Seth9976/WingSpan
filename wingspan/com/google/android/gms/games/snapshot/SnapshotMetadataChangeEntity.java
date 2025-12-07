package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzc;

public final class SnapshotMetadataChangeEntity extends zzc implements SnapshotMetadataChange {
    public static final Parcelable.Creator CREATOR;
    private final String zza;
    private final Long zzb;
    private final Uri zzc;
    private BitmapTeleporter zzd;
    private final Long zze;

    static {
        SnapshotMetadataChangeEntity.CREATOR = new com.google.android.gms.games.snapshot.zzc();
    }

    SnapshotMetadataChangeEntity() {
        this(null, null, null, null, null);
    }

    SnapshotMetadataChangeEntity(String s, Long long0, BitmapTeleporter bitmapTeleporter0, Uri uri0, Long long1) {
        this.zza = s;
        this.zzb = long0;
        this.zzd = bitmapTeleporter0;
        this.zzc = uri0;
        this.zze = long1;
        Preconditions.checkState(bitmapTeleporter0 == null || uri0 == null, "Cannot set both a URI and an image");
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public final Bitmap getCoverImage() {
        return this.zzd == null ? null : this.zzd.get();
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public final String getDescription() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public final Long getPlayedTimeMillis() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public final Long getProgressValue() {
        return this.zze;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeLongObject(parcel0, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzc, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzd, v, false);
        SafeParcelWriter.writeLongObject(parcel0, 6, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public final BitmapTeleporter zza() {
        return this.zzd;
    }
}

