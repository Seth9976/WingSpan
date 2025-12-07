package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

public interface SnapshotMetadataChange {
    public static final class Builder {
        private String zza;
        private Long zzb;
        private Long zzc;
        private BitmapTeleporter zzd;
        private Uri zze;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.zza, this.zzb, this.zzd, this.zze, this.zzc);
        }

        public Builder fromMetadata(SnapshotMetadata snapshotMetadata0) {
            this.zza = snapshotMetadata0.getDescription();
            this.zzb = snapshotMetadata0.getPlayedTime();
            this.zzc = snapshotMetadata0.getProgressValue();
            if(Long.compare(((long)this.zzb), -1L) == 0) {
                this.zzb = null;
            }
            Uri uri0 = snapshotMetadata0.getCoverImageUri();
            this.zze = uri0;
            if(uri0 != null) {
                this.zzd = null;
            }
            return this;
        }

        public Builder setCoverImage(Bitmap bitmap0) {
            this.zzd = new BitmapTeleporter(bitmap0);
            this.zze = null;
            return this;
        }

        public Builder setDescription(String s) {
            this.zza = s;
            return this;
        }

        public Builder setPlayedTimeMillis(long v) {
            this.zzb = v;
            return this;
        }

        public Builder setProgressValue(long v) {
            this.zzc = v;
            return this;
        }
    }

    public static final SnapshotMetadataChange EMPTY_CHANGE;

    static {
        SnapshotMetadataChange.EMPTY_CHANGE = new SnapshotMetadataChangeEntity();
    }

    Bitmap getCoverImage();

    String getDescription();

    Long getPlayedTimeMillis();

    Long getProgressValue();

    BitmapTeleporter zza();
}

