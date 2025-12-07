package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.connection.Payload;
import java.util.List;

final class zzcd extends zzcy {
    private final Payload zzbx;
    private final List zzcw;

    zzcd(zzca zzca0, GoogleApiClient googleApiClient0, List list0, Payload payload0) {
        this.zzcw = list0;
        this.zzbx = payload0;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzx)api$AnyClient0).zza(this, ((String[])this.zzcw.toArray(new String[0])), this.zzbx, false);
    }
}

