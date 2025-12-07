package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcn extends TaskApiCall {
    private final DriveResource zzfq;

    zzcn(zzch zzch0, DriveResource driveResource0) {
        this.zzfq = driveResource0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzhd(this.zzfq.getDriveId()), new zzhr(taskCompletionSource0));
    }
}

