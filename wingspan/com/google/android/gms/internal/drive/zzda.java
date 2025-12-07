package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzda extends TaskApiCall {
    private final DriveContents zzfx;

    zzda(zzch zzch0, DriveContents driveContents0) {
        this.zzfx = driveContents0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzo(this.zzfx.zzi().getRequestId(), false), new zzhr(taskCompletionSource0));
    }
}

