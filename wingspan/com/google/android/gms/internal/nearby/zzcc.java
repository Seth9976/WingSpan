package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.connection.Payload;

final class zzcc extends zzcy {
    private final Payload zzbx;
    private final String zzcv;

    zzcc(zzca zzca0, GoogleApiClient googleApiClient0, String s, Payload payload0) {
        this.zzcv = s;
        this.zzbx = payload0;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzx)api$AnyClient0).zza(this, new String[]{this.zzcv}, this.zzbx, false);
    }
}

