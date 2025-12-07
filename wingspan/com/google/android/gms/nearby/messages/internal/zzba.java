package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzba extends UnregisterListenerMethod {
    private final zzak zzia;
    private final zzbd zzie;

    zzba(zzak zzak0, ListenerKey listenerHolder$ListenerKey0, zzbd zzbd0) {
        this.zzia = zzak0;
        this.zzie = zzbd0;
        super(listenerHolder$ListenerKey0);
    }

    @Override  // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    protected final void unregisterListener(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ListenerHolder listenerHolder0 = this.zzia.zza(taskCompletionSource0);
        this.zzie.zza(((zzah)api$AnyClient0), listenerHolder0);
    }
}

