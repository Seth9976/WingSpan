package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.connection.Payload;
import java.util.List;

final class zzcn extends zzcy {
    private final List zzcw;
    private final byte[] zzde;

    zzcn(zzca zzca0, GoogleApiClient googleApiClient0, List list0, byte[] arr_b) {
        this.zzcw = list0;
        this.zzde = arr_b;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzx)api$AnyClient0).zza(this, ((String[])this.zzcw.toArray(new String[0])), Payload.fromBytes(this.zzde), true);
    }
}

