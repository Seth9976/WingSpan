package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcr extends TaskApiCall {
    private final DriveResource zzfq;

    zzcr(zzch zzch0, DriveResource driveResource0) {
        this.zzfq = driveResource0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        if(!((zzaw)api$AnyClient0).zzec) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
        }
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzj(1, this.zzfq.getDriveId()), null, null, new zzhr(taskCompletionSource0));
    }
}

