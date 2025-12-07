package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

final class zzco extends zzcw {
    private final String val$name;
    private final String zzcn;
    private final AdvertisingOptions zzcp;
    private final ListenerHolder zzdf;

    zzco(zzca zzca0, GoogleApiClient googleApiClient0, String s, String s1, ListenerHolder listenerHolder0, AdvertisingOptions advertisingOptions0) {
        this.val$name = s;
        this.zzcn = s1;
        this.zzdf = listenerHolder0;
        this.zzcp = advertisingOptions0;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzx)api$AnyClient0).zza(this, this.val$name, this.zzcn, this.zzdf, this.zzcp);
    }
}

