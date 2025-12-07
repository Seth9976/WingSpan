package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzaz extends zzav {
    private final zzj zzek;

    zzaz(zzaw zzaw0, GoogleApiClient googleApiClient0, zzj zzj0) {
        this.zzek = zzj0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        zzeo zzeo0 = (zzeo)((zzaw)api$AnyClient0).getService();
        zzgy zzgy0 = new zzgy(this);
        zzeo0.zza(this.zzek, null, null, zzgy0);
    }
}

