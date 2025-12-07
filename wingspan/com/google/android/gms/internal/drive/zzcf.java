package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;

final class zzcf implements FileUploadPreferencesResult {
    private final Status zzdy;
    private final FileUploadPreferences zzfm;

    private zzcf(zzcb zzcb0, Status status0, FileUploadPreferences fileUploadPreferences0) {
        this.zzdy = status0;
        this.zzfm = fileUploadPreferences0;
    }

    zzcf(zzcb zzcb0, Status status0, FileUploadPreferences fileUploadPreferences0, zzcc zzcc0) {
        this(zzcb0, status0, fileUploadPreferences0);
    }

    @Override  // com.google.android.gms.drive.DrivePreferencesApi$FileUploadPreferencesResult
    public final FileUploadPreferences getFileUploadPreferences() {
        return this.zzfm;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdy;
    }
}

