package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;

public final class zzbn extends zzdp implements DriveFile {
    public zzbn(DriveId driveId0) {
        super(driveId0);
    }

    @Override  // com.google.android.gms.drive.DriveFile
    public final PendingResult open(GoogleApiClient googleApiClient0, int v, DownloadProgressListener driveFile$DownloadProgressListener0) {
        if(v != 0x10000000 && v != 0x20000000 && v != 0x30000000) {
            throw new IllegalArgumentException("Invalid mode provided.");
        }
        return driveFile$DownloadProgressListener0 == null ? googleApiClient0.enqueue(new zzbo(this, googleApiClient0, v, null)) : googleApiClient0.enqueue(new zzbo(this, googleApiClient0, v, new zzbp(googleApiClient0.registerListener(driveFile$DownloadProgressListener0))));
    }
}

