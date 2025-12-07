package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzdl extends zza implements zzdj {
    zzdl(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    @Override  // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzef zzef0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzef0);
        this.transactOneway(5, parcel0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzeh zzeh0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzeh0);
        this.transactOneway(2, parcel0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzen zzen0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzen0);
        this.transactOneway(3, parcel0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzep zzep0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzep0);
        this.transactOneway(4, parcel0);
    }
}

