package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationCallback;

final class zzn extends zzx {
    final LocationCallback zza;

    zzn(zzz zzz0, GoogleApiClient googleApiClient0, LocationCallback locationCallback0) {
        this.zza = locationCallback0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzaz)api$AnyClient0).zzH(ListenerHolders.createListenerKey(this.zza, "LocationCallback"), new zzy(this));
    }
}

