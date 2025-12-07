package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.SubscribeOptions;

final class zzbo extends zzbv {
    private final zzbw zzio;
    private final SubscribeOptions zzip;
    private final PendingIntent zziq;

    zzbo(zzbi zzbi0, GoogleApiClient googleApiClient0, PendingIntent pendingIntent0, zzbw zzbw0, SubscribeOptions subscribeOptions0) {
        this.zziq = pendingIntent0;
        this.zzio = zzbw0;
        this.zzip = subscribeOptions0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzah)api$AnyClient0).zza(this.zzah(), this.zziq, this.zzio, this.zzip);
    }
}

