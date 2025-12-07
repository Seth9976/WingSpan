package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

final class zzcs extends zzcy {
    private final String val$name;
    private final String zzcv;
    private final ListenerHolder zzdf;

    zzcs(zzca zzca0, GoogleApiClient googleApiClient0, String s, String s1, ListenerHolder listenerHolder0) {
        this.val$name = s;
        this.zzcv = s1;
        this.zzdf = listenerHolder0;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzx)api$AnyClient0).zza(this, this.val$name, this.zzcv, this.zzdf);
    }
}

