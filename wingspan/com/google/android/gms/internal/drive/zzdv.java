package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzdv extends zzav {
    private final zzdp zzgq;

    zzdv(zzdp zzdp0, GoogleApiClient googleApiClient0) {
        this.zzgq = zzdp0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzhb(this.zzgq.zzk), new zzgy(this));
    }
}

