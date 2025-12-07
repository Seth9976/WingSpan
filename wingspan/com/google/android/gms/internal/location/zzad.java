package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.zzbq;

final class zzad extends zzae {
    final zzbq zza;

    zzad(zzaf zzaf0, GoogleApiClient googleApiClient0, zzbq zzbq0) {
        this.zza = zzbq0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzaz)api$AnyClient0).zzw(this.zza, this);
    }
}

