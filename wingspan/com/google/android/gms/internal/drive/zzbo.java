package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ICancelToken.Stub;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;

final class zzbo extends zzam {
    private final int zzdv;
    private final DownloadProgressListener zzey;
    private final zzbn zzez;

    zzbo(zzbn zzbn0, GoogleApiClient googleApiClient0, int v, DownloadProgressListener driveFile$DownloadProgressListener0) {
        this.zzez = zzbn0;
        this.zzdv = v;
        this.zzey = driveFile$DownloadProgressListener0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        this.setCancelToken(Stub.asInterface(((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzgj(this.zzez.getDriveId(), this.zzdv, 0), new zzgl(this, this.zzey)).zzgs));
    }
}

