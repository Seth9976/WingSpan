package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;

public class zzaw extends zzb implements zzax {
    @Override  // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        throw null;
    }

    public static zzax zzb(IBinder iBinder0) {
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
        return iInterface0 instanceof zzax ? ((zzax)iInterface0) : new zzav(iBinder0);
    }
}

