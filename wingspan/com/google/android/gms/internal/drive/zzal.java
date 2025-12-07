package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;

final class zzal implements Releasable, DriveContentsResult {
    private final Status zzdy;
    private final DriveContents zzo;

    public zzal(Status status0, DriveContents driveContents0) {
        this.zzdy = status0;
        this.zzo = driveContents0;
    }

    @Override  // com.google.android.gms.drive.DriveApi$DriveContentsResult
    public final DriveContents getDriveContents() {
        return this.zzo;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdy;
    }

    @Override  // com.google.android.gms.common.api.Releasable
    public final void release() {
        DriveContents driveContents0 = this.zzo;
        if(driveContents0 != null) {
            driveContents0.zzj();
        }
    }
}

