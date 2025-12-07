package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzax extends zzav {
    private final zzj zzek;
    private final zzee zzel;

    zzax(zzaw zzaw0, GoogleApiClient googleApiClient0, zzj zzj0, zzee zzee0) {
        this.zzek = zzj0;
        this.zzel = zzee0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        zzeo zzeo0 = (zzeo)((zzaw)api$AnyClient0).getService();
        zzgy zzgy0 = new zzgy(this);
        zzeo0.zza(this.zzek, this.zzel, null, zzgy0);
    }
}

