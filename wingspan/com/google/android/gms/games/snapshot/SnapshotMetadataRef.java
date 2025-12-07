package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class SnapshotMetadataRef extends DataBufferRef implements SnapshotMetadata {
    private final Game zza;
    private final Player zzb;

    public SnapshotMetadataRef(DataHolder dataHolder0, int v) {
        super(dataHolder0, v);
        this.zza = new GameRef(dataHolder0, v);
        this.zzb = new PlayerRef(dataHolder0, v, null);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object object0) {
        return SnapshotMetadataEntity.zzd(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return new SnapshotMetadataEntity(this);
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final float getCoverImageAspectRatio() {
        float f = this.getFloat("cover_icon_image_height");
        return f == 0.0f ? 0.0f : this.getFloat("cover_icon_image_width") / f;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final Uri getCoverImageUri() {
        return this.parseUri("cover_icon_image_uri");
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String getCoverImageUrl() {
        return this.getString("cover_icon_image_url");
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final String getDescription() {
        return this.getString("description");
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final void getDescription(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer("description", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final String getDeviceName() {
        return this.getString("device_name");
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final Game getGame() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final long getLastModifiedTimestamp() {
        return this.getLong("last_modified_timestamp");
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final Player getOwner() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final long getPlayedTime() {
        return this.getLong("duration");
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final long getProgressValue() {
        return this.getLong("progress_value");
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final String getSnapshotId() {
        return this.getString("external_snapshot_id");
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final String getUniqueName() {
        return this.getString("unique_name");
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final boolean hasChangePending() {
        return this.getInteger("pending_change_count") > 0;
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return SnapshotMetadataEntity.zzb(this);
    }

    @Override
    public final String toString() {
        return SnapshotMetadataEntity.zzc(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        new SnapshotMetadataEntity(this).writeToParcel(parcel0, v);
    }

    @Override  // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final String zza() {
        return this.getString("title");
    }
}

