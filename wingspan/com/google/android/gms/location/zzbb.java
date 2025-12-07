package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zza;

public final class zzbb extends zza implements zzbd {
    zzbb(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.location.ILocationListener");
    }

    @Override  // com.google.android.gms.location.zzbd
    public final void zzd(Location location0) throws RemoteException {
        throw null;
    }
}

