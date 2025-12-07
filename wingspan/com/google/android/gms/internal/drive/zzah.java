package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzah extends zzam {
    private final int zzdv;

    zzah(zzaf zzaf0, GoogleApiClient googleApiClient0, int v) {
        this.zzdv = 0x20000000;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzr(this.zzdv), new zzak(this));
    }
}

