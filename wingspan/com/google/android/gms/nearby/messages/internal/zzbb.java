package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbb extends TaskApiCall {
    private final zzak zzia;
    private final zzbd zzif;

    zzbb(zzak zzak0, zzbd zzbd0) {
        this.zzia = zzak0;
        this.zzif = zzbd0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ListenerHolder listenerHolder0 = this.zzia.zza(taskCompletionSource0);
        this.zzif.zza(((zzah)api$AnyClient0), listenerHolder0);
    }
}

