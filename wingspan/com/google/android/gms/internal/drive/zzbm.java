package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzbm extends zzav {
    private final zzbi zzev;

    zzbm(zzbi zzbi0, GoogleApiClient googleApiClient0) {
        this.zzev = zzbi0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzo(this.zzev.zzes.getRequestId(), false), new zzgy(this));
    }
}

