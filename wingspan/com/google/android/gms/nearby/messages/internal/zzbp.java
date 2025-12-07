package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

final class zzbp extends zzbv {
    private final ListenerHolder zzco;

    zzbp(zzbi zzbi0, GoogleApiClient googleApiClient0, ListenerHolder listenerHolder0) {
        this.zzco = listenerHolder0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzah)api$AnyClient0).zza(this.zzah(), this.zzco);
    }
}

