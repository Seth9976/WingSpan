package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzee extends zza implements zzec {
    zzee(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
    }

    @Override  // com.google.android.gms.internal.nearby.zzec
    public final void zza(zzez zzez0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzez0);
        this.transactOneway(2, parcel0);
    }
}

