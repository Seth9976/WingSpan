package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcv extends UnregisterListenerMethod {
    private final zzg zzfu;

    zzcv(zzch zzch0, ListenerKey listenerHolder$ListenerKey0, zzg zzg0) {
        this.zzfu = zzg0;
        super(listenerHolder$ListenerKey0);
    }

    @Override  // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    protected final void unregisterListener(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        taskCompletionSource0.setResult(Boolean.valueOf(this.zzfu.cancel()));
    }
}

