package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveFolder;

final class zzbz implements DriveFolderResult {
    private final Status zzdy;
    private final DriveFolder zzfj;

    public zzbz(Status status0, DriveFolder driveFolder0) {
        this.zzdy = status0;
        this.zzfj = driveFolder0;
    }

    @Override  // com.google.android.gms.drive.DriveFolder$DriveFolderResult
    public final DriveFolder getDriveFolder() {
        return this.zzfj;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdy;
    }
}

