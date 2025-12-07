package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzdi extends zza implements zzdg {
    zzdi(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
    }

    @Override  // com.google.android.gms.internal.nearby.zzdg
    public final void zza(zzep zzep0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzep0);
        this.transactOneway(3, parcel0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdg
    public final void zza(zzev zzev0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzev0);
        this.transactOneway(2, parcel0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdg
    public final void zza(zzex zzex0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzex0);
        this.transactOneway(4, parcel0);
    }
}

