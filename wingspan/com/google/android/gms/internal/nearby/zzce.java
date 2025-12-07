package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzce extends zzcy {
    private final long zzcx;

    zzce(zzca zzca0, GoogleApiClient googleApiClient0, long v) {
        this.zzcx = v;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzx)api$AnyClient0).zza(this, this.zzcx);
    }
}

