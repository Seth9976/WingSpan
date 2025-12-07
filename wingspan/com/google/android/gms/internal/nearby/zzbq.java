package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbq extends RegisterListenerMethod {
    private final String zzcn;
    private final ListenerHolder zzco;
    private final zzbd zzcq;
    private final DiscoveryOptions zzcr;

    zzbq(zzbd zzbd0, ListenerHolder listenerHolder0, String s, ListenerHolder listenerHolder1, DiscoveryOptions discoveryOptions0) {
        this.zzcq = zzbd0;
        this.zzcn = s;
        this.zzco = listenerHolder1;
        this.zzcr = discoveryOptions0;
        super(listenerHolder0);
    }

    @Override  // com.google.android.gms.common.api.internal.RegisterListenerMethod
    protected final void registerListener(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ((zzx)api$AnyClient0).zza(new zzby(this.zzcq, taskCompletionSource0), this.zzcn, this.zzco, this.zzcr);
    }
}

