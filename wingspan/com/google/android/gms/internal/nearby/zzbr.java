package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbr extends UnregisterListenerMethod {
    zzbr(zzbd zzbd0, ListenerKey listenerHolder$ListenerKey0) {
        super(listenerHolder$ListenerKey0);
    }

    @Override  // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    protected final void unregisterListener(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ((zzx)api$AnyClient0).stopDiscovery();
        taskCompletionSource0.setResult(Boolean.TRUE);
    }
}

