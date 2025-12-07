package com.google.android.gms.internal.appset;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzg extends zza implements IInterface {
    zzg(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.appset.internal.IAppSetService");
    }

    public final void zzc(com.google.android.gms.appset.zza zza0, zzf zzf0) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, zza0);
        zzc.zzc(parcel0, zzf0);
        this.zzb(1, parcel0);
    }
}

