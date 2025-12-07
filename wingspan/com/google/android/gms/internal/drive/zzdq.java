package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzdq extends zzea {
    private final boolean zzga;
    private final zzdp zzgq;

    zzdq(zzdp zzdp0, GoogleApiClient googleApiClient0, boolean z) {
        this.zzgq = zzdp0;
        this.zzga = false;
        super(zzdp0, googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzek(this.zzgq.zzk, this.zzga), new zzdy(this));
    }
}

