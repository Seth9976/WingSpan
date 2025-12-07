package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public class zzhh extends zzl {
    private TaskCompletionSource zziv;

    zzhh(TaskCompletionSource taskCompletionSource0) {
        this.zziv = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(Status status0) throws RemoteException {
        this.zziv.setException(new ApiException(status0));
    }

    public final TaskCompletionSource zzay() {
        return this.zziv;
    }
}

