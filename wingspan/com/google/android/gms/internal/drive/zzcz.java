package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcz extends TaskApiCall {
    private final Query zzdu;

    zzcz(zzch zzch0, Query query0) {
        this.zzdu = query0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzgq(this.zzdu), new zzhn(taskCompletionSource0));
    }
}

