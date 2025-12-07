package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcx extends TaskApiCall {
    private final DriveContents zzfx;

    zzcx(zzch zzch0, DriveContents driveContents0) {
        this.zzfx = driveContents0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzgj(this.zzfx.getDriveId(), 0x20000000, this.zzfx.zzi().getRequestId()), new zzhi(taskCompletionSource0));
    }
}

