package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.List;

final class zzds extends zzav {
    private final List zzgb;
    private final zzdp zzgq;

    zzds(zzdp zzdp0, GoogleApiClient googleApiClient0, List list0) {
        this.zzgq = zzdp0;
        this.zzgb = list0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzgw(this.zzgq.zzk, this.zzgb), new zzgy(this));
    }
}

