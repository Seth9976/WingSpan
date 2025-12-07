package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzq;

public final class CreateFileActivityOptions extends zzq {
    public static class Builder {
        protected final CreateFileActivityBuilder builder;

        public Builder() {
            this.builder = new CreateFileActivityBuilder();
        }

        public CreateFileActivityOptions build() {
            this.builder.zzg();
            return new CreateFileActivityOptions(this.builder.zzc().zzq(), this.builder.getRequestId(), this.builder.zze(), this.builder.zzd(), 0, null);
        }

        public Builder setActivityStartFolder(DriveId driveId0) {
            this.builder.setActivityStartFolder(driveId0);
            return this;
        }

        public Builder setActivityTitle(String s) {
            this.builder.setActivityTitle(s);
            return this;
        }

        public Builder setInitialDriveContents(DriveContents driveContents0) {
            this.builder.setInitialDriveContents(driveContents0);
            return this;
        }

        public Builder setInitialMetadata(MetadataChangeSet metadataChangeSet0) {
            this.builder.setInitialMetadata(metadataChangeSet0);
            return this;
        }
    }

    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";

    private CreateFileActivityOptions(MetadataBundle metadataBundle0, Integer integer0, String s, DriveId driveId0, int v) {
        super(metadataBundle0, integer0, s, driveId0, v);
    }

    CreateFileActivityOptions(MetadataBundle metadataBundle0, Integer integer0, String s, DriveId driveId0, int v, zzd zzd0) {
        this(metadataBundle0, integer0, s, driveId0, v);
    }
}

