package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzdo extends zza implements zzdm {
    zzdo(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
    }

    @Override  // com.google.android.gms.internal.nearby.zzdm
    public final void zza(zzel zzel0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzel0);
        this.transactOneway(2, parcel0);
    }
}

