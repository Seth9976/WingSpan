package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;

final class zzgl extends zzl {
    private final ResultHolder zzdx;
    private final DownloadProgressListener zziq;

    zzgl(ResultHolder baseImplementation$ResultHolder0, DownloadProgressListener driveFile$DownloadProgressListener0) {
        this.zzdx = baseImplementation$ResultHolder0;
        this.zziq = driveFile$DownloadProgressListener0;
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(Status status0) throws RemoteException {
        zzal zzal0 = new zzal(status0, null);
        this.zzdx.setResult(zzal0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfh zzfh0) throws RemoteException {
        zzal zzal0 = new zzal((zzfh0.zzhv ? new Status(-1) : Status.RESULT_SUCCESS), new zzbi(zzfh0.zzes));
        this.zzdx.setResult(zzal0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfl zzfl0) throws RemoteException {
        DownloadProgressListener driveFile$DownloadProgressListener0 = this.zziq;
        if(driveFile$DownloadProgressListener0 != null) {
            driveFile$DownloadProgressListener0.onProgress(zzfl0.zzhy, zzfl0.zzhz);
        }
    }
}

