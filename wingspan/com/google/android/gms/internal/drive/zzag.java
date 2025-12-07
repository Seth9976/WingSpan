package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.query.Query;

final class zzag extends zzar {
    private final Query zzdu;

    zzag(zzaf zzaf0, GoogleApiClient googleApiClient0, Query query0) {
        this.zzdu = query0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzgq(this.zzdu), new zzas(this));
    }
}

