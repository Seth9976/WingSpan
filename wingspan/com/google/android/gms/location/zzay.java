package com.google.android.gms.location;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zza;

public final class zzay extends zza implements zzba {
    zzay(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.location.ILocationCallback");
    }

    @Override  // com.google.android.gms.location.zzba
    public final void zzd(LocationResult locationResult0) throws RemoteException {
        throw null;
    }

    @Override  // com.google.android.gms.location.zzba
    public final void zze(LocationAvailability locationAvailability0) throws RemoteException {
        throw null;
    }
}

