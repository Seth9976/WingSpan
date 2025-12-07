package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzw extends zzx {
    final PendingIntent zza;

    zzw(zzz zzz0, GoogleApiClient googleApiClient0, PendingIntent pendingIntent0) {
        this.zza = pendingIntent0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        zzy zzy0 = new zzy(this);
        ((zzaz)api$AnyClient0).zzG(this.zza, zzy0);
    }
}

