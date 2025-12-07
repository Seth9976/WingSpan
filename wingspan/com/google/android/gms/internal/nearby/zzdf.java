package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzdf extends zza implements zzdd {
    zzdf(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
    }

    @Override  // com.google.android.gms.internal.nearby.zzdd
    public final void zza(zzej zzej0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzej0);
        this.transactOneway(2, parcel0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdd
    public final void zza(zzfb zzfb0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzfb0);
        this.transactOneway(3, parcel0);
    }
}

