package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzeb extends zza implements zzdz {
    zzeb(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.nearby.internal.connection.IResultListener");
    }

    @Override  // com.google.android.gms.internal.nearby.zzdz
    public final void zzc(int v) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        parcel0.writeInt(v);
        this.transactOneway(2, parcel0);
    }
}

