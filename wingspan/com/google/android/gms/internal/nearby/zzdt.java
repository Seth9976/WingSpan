package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzdt extends zza implements zzdr {
    zzdt(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    @Override  // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzer zzer0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzer0);
        this.transactOneway(2, parcel0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzet zzet0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzet0);
        this.transactOneway(3, parcel0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzfd zzfd0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzfd0);
        this.transactOneway(4, parcel0);
    }
}

