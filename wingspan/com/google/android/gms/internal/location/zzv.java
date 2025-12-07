package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationListener;

final class zzv extends zzx {
    final LocationListener zza;

    zzv(zzz zzz0, GoogleApiClient googleApiClient0, LocationListener locationListener0) {
        this.zza = locationListener0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzaz)api$AnyClient0).zzF(ListenerHolders.createListenerKey(this.zza, "LocationListener"), new zzy(this));
    }
}

