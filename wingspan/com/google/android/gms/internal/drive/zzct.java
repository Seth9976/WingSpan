package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzct extends TaskApiCall {
    private final DriveFile zzfs;
    private final int zzft;

    zzct(zzch zzch0, DriveFile driveFile0, int v) {
        this.zzfs = driveFile0;
        this.zzft = v;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzgj(this.zzfs.getDriveId(), this.zzft, 0), new zzhi(taskCompletionSource0));
    }
}

