package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

final class zzdf extends TaskApiCall {
    private final DriveResource zzfq;
    private final List zzgb;

    zzdf(zzch zzch0, DriveResource driveResource0, List list0) {
        this.zzfq = driveResource0;
        this.zzgb = list0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzgw(this.zzfq.getDriveId(), this.zzgb), new zzhr(taskCompletionSource0));
    }
}

