package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.GeofencingRequest;

final class zzac extends zzae {
    final GeofencingRequest zza;
    final PendingIntent zzb;

    zzac(zzaf zzaf0, GoogleApiClient googleApiClient0, GeofencingRequest geofencingRequest0, PendingIntent pendingIntent0) {
        this.zza = geofencingRequest0;
        this.zzb = pendingIntent0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzaz)api$AnyClient0).zzv(this.zza, this.zzb, this);
    }
}

