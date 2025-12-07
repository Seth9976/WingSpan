package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzcd extends zzav {
    private final zzei zzfl;

    zzcd(zzcb zzcb0, GoogleApiClient googleApiClient0, zzei zzei0) {
        this.zzfl = zzei0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzgu(this.zzfl), new zzgy(this));
    }
}

