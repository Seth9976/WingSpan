package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;

final class zzbx implements DriveFileResult {
    private final Status zzdy;
    private final DriveFile zzfi;

    public zzbx(Status status0, DriveFile driveFile0) {
        this.zzdy = status0;
        this.zzfi = driveFile0;
    }

    @Override  // com.google.android.gms.drive.DriveFolder$DriveFileResult
    public final DriveFile getDriveFile() {
        return this.zzfi;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdy;
    }
}

