package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

final class zzu extends zzx {
    final LocationRequest zza;
    final PendingIntent zzb;

    zzu(zzz zzz0, GoogleApiClient googleApiClient0, LocationRequest locationRequest0, PendingIntent pendingIntent0) {
        this.zza = locationRequest0;
        this.zzb = pendingIntent0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        zzy zzy0 = new zzy(this);
        ((zzaz)api$AnyClient0).zzE(this.zza, this.zzb, zzy0);
    }
}

