package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzbq extends zzbv {
    private final PendingIntent zziq;

    zzbq(zzbi zzbi0, GoogleApiClient googleApiClient0, PendingIntent pendingIntent0) {
        this.zziq = pendingIntent0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzah)api$AnyClient0).zza(this.zzah(), this.zziq);
    }
}

