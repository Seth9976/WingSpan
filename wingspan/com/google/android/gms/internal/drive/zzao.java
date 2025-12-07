package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveId;

final class zzao implements DriveIdResult {
    private final Status zzdy;
    private final DriveId zzk;

    public zzao(Status status0, DriveId driveId0) {
        this.zzdy = status0;
        this.zzk = driveId0;
    }

    @Override  // com.google.android.gms.drive.DriveApi$DriveIdResult
    public final DriveId getDriveId() {
        return this.zzk;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdy;
    }
}

