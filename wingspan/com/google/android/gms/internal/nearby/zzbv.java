package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbv extends TaskApiCall {
    private final zzbd zzcq;
    private final zzbw zzcs;

    zzbv(zzbd zzbd0, zzbw zzbw0) {
        this.zzcq = zzbd0;
        this.zzcs = zzbw0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        zzby zzby0 = new zzby(this.zzcq, taskCompletionSource0);
        this.zzcs.zza(((zzx)api$AnyClient0), zzby0);
    }
}

