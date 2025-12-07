package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.nearby.zza;
import com.google.android.gms.internal.nearby.zzc;

public final class zzt extends zza implements zzs {
    zzt(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(SubscribeRequest subscribeRequest0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, subscribeRequest0);
        this.transactOneway(3, parcel0);
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzbz zzbz0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzbz0);
        this.transactOneway(1, parcel0);
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzcb zzcb0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzcb0);
        this.transactOneway(8, parcel0);
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzce zzce0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzce0);
        this.transactOneway(2, parcel0);
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzcg zzcg0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzcg0);
        this.transactOneway(4, parcel0);
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzh zzh0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzh0);
        this.transactOneway(7, parcel0);
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzj zzj0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzj0);
        this.transactOneway(9, parcel0);
    }
}

