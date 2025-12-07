package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbo extends RegisterListenerMethod {
    private final String val$name;
    private final String zzcn;
    private final ListenerHolder zzco;
    private final AdvertisingOptions zzcp;
    private final zzbd zzcq;

    zzbo(zzbd zzbd0, ListenerHolder listenerHolder0, String s, String s1, ListenerHolder listenerHolder1, AdvertisingOptions advertisingOptions0) {
        this.zzcq = zzbd0;
        this.val$name = s;
        this.zzcn = s1;
        this.zzco = listenerHolder1;
        this.zzcp = advertisingOptions0;
        super(listenerHolder0);
    }

    @Override  // com.google.android.gms.common.api.internal.RegisterListenerMethod
    protected final void registerListener(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ((zzx)api$AnyClient0).zza(new zzby(this.zzcq, taskCompletionSource0), this.val$name, this.zzcn, this.zzco, this.zzcp);
    }
}

