package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

final class zzcq extends zzcy {
    private final String zzcn;
    private final DiscoveryOptions zzcr;
    private final ListenerHolder zzdg;

    zzcq(zzca zzca0, GoogleApiClient googleApiClient0, String s, ListenerHolder listenerHolder0, DiscoveryOptions discoveryOptions0) {
        this.zzcn = s;
        this.zzdg = listenerHolder0;
        this.zzcr = discoveryOptions0;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzx)api$AnyClient0).zza(this, this.zzcn, this.zzdg, this.zzcr);
    }
}

