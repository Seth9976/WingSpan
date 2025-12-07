package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzp extends zzx {
    final Location zza;

    zzp(zzz zzz0, GoogleApiClient googleApiClient0, Location location0) {
        this.zza = location0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzaz)api$AnyClient0).zzJ(this.zza);
        this.setResult(Status.RESULT_SUCCESS);
    }
}

