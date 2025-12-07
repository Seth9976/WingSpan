package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzew extends zza implements zzeu {
    zzew(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.drive.internal.IEventReleaseCallback");
    }

    @Override  // com.google.android.gms.internal.drive.zzeu
    public final void zza(boolean z) throws RemoteException {
        Parcel parcel0 = this.zza();
        zzc.writeBoolean(parcel0, z);
        this.zzc(1, parcel0);
    }
}

