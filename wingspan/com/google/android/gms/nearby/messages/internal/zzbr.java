package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.nearby.zzgy;

final class zzbr extends zzbv {
    zzbr(zzbi zzbi0, GoogleApiClient googleApiClient0) {
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        zzh zzh0 = new zzh(new zzgy(this.zzah()));
        ((zzs)((zzah)api$AnyClient0).getService()).zza(zzh0);
    }
}

