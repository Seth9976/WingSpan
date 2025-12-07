package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzo extends zzx {
    final boolean zza;

    zzo(zzz zzz0, GoogleApiClient googleApiClient0, boolean z) {
        this.zza = z;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzaz)api$AnyClient0).zzI(this.zza);
        this.setResult(Status.RESULT_SUCCESS);
    }
}

