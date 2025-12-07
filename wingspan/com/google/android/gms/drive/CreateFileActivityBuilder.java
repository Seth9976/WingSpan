package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.drive.zzbi;
import com.google.android.gms.internal.drive.zzt;

@Deprecated
public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final zzt zzn;
    private DriveContents zzo;
    private boolean zzp;

    public CreateFileActivityBuilder() {
        this.zzn = new zzt(0);
    }

    public IntentSender build(GoogleApiClient googleApiClient0) {
        Preconditions.checkState(googleApiClient0.isConnected(), "Client must be connected");
        this.zzg();
        return this.zzn.build(googleApiClient0);
    }

    final int getRequestId() {
        return this.zzn.getRequestId();
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId driveId0) {
        this.zzn.zza(driveId0);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String s) {
        this.zzn.zzc(s);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents driveContents0) {
        if(driveContents0 == null) {
            this.zzn.zzd(1);
        }
        else {
            if(!(driveContents0 instanceof zzbi)) {
                throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
            }
            if(driveContents0.getDriveId() != null) {
                throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
            }
            if(driveContents0.zzk()) {
                throw new IllegalArgumentException("DriveContents are already closed.");
            }
            Contents contents0 = driveContents0.zzi();
            this.zzn.zzd(contents0.zzj);
            this.zzo = driveContents0;
        }
        this.zzp = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet0) {
        this.zzn.zza(metadataChangeSet0);
        return this;
    }

    final MetadataChangeSet zzc() {
        return this.zzn.zzc();
    }

    final DriveId zzd() {
        return this.zzn.zzd();
    }

    final String zze() {
        return this.zzn.zze();
    }

    final int zzf() [...] // Inlined contents

    final void zzg() {
        Preconditions.checkState(this.zzp, "Must call setInitialDriveContents.");
        DriveContents driveContents0 = this.zzo;
        if(driveContents0 != null) {
            driveContents0.zzj();
        }
        this.zzn.zzg();
    }
}

