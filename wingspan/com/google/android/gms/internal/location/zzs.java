package com.google.android.gms.internal.location;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

final class zzs extends zzx {
    final LocationRequest zza;
    final LocationListener zzb;
    final Looper zzc;

    zzs(zzz zzz0, GoogleApiClient googleApiClient0, LocationRequest locationRequest0, LocationListener locationListener0, Looper looper0) {
        this.zza = locationRequest0;
        this.zzb = locationListener0;
        this.zzc = looper0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        zzy zzy0 = new zzy(this);
        Looper looper0 = zzbj.zza(this.zzc);
        ListenerHolder listenerHolder0 = ListenerHolders.createListenerHolder(this.zzb, looper0, "LocationListener");
        ((zzaz)api$AnyClient0).zzC(this.zza, listenerHolder0, zzy0);
    }
}

