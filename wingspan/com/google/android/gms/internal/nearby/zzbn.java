package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbn extends TaskApiCall {
    private final zzbz zzcm;

    zzbn(zzbd zzbd0, zzbz zzbz0) {
        this.zzcm = zzbz0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        this.zzcm.zzb(((zzx)api$AnyClient0));
        taskCompletionSource0.setResult(null);
    }
}

