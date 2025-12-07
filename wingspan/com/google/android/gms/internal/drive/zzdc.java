package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdc extends TaskApiCall {
    private final DriveResource zzfq;
    private final boolean zzga;

    zzdc(zzch zzch0, DriveResource driveResource0, boolean z) {
        this.zzfq = driveResource0;
        this.zzga = false;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzek(this.zzfq.getDriveId(), this.zzga), new zzhp(taskCompletionSource0));
    }
}

