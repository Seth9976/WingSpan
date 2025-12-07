package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.connection.Payload;

final class zzcm extends zzcy {
    private final String zzcv;
    private final byte[] zzde;

    zzcm(zzca zzca0, GoogleApiClient googleApiClient0, String s, byte[] arr_b) {
        this.zzcv = s;
        this.zzde = arr_b;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzx)api$AnyClient0).zza(this, new String[]{this.zzcv}, Payload.fromBytes(this.zzde), true);
    }
}

