package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzaz extends RegisterListenerMethod {
    private final zzak zzia;
    private final zzbd zzid;

    zzaz(zzak zzak0, ListenerHolder listenerHolder0, zzbd zzbd0) {
        this.zzia = zzak0;
        this.zzid = zzbd0;
        super(listenerHolder0);
    }

    @Override  // com.google.android.gms.common.api.internal.RegisterListenerMethod
    protected final void registerListener(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ListenerHolder listenerHolder0 = this.zzia.zza(taskCompletionSource0);
        this.zzid.zza(((zzah)api$AnyClient0), listenerHolder0);
    }
}

