package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;

final class zzba extends zzav {
    private final DriveId zzen;
    private final int zzeo;

    zzba(zzaw zzaw0, GoogleApiClient googleApiClient0, DriveId driveId0, int v) {
        this.zzen = driveId0;
        this.zzeo = 1;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzgs(this.zzen, this.zzeo), null, null, new zzgy(this));
    }
}

