package com.google.android.gms.internal.location;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;

final class zzt extends zzx {
    final LocationRequest zza;
    final LocationCallback zzb;
    final Looper zzc;

    zzt(zzz zzz0, GoogleApiClient googleApiClient0, LocationRequest locationRequest0, LocationCallback locationCallback0, Looper looper0) {
        this.zza = locationRequest0;
        this.zzb = locationCallback0;
        this.zzc = looper0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        zzy zzy0 = new zzy(this);
        zzba zzba0 = zzba.zza(null, this.zza);
        Looper looper0 = zzbj.zza(this.zzc);
        ((zzaz)api$AnyClient0).zzB(zzba0, ListenerHolders.createListenerHolder(this.zzb, looper0, "LocationCallback"), zzy0);
    }
}

