package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzcc extends zzcg {
    private final zzcb zzfk;

    zzcc(zzcb zzcb0, GoogleApiClient googleApiClient0) {
        this.zzfk = zzcb0;
        super(zzcb0, googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zzb(new zzce(this.zzfk, this, null));
    }
}

