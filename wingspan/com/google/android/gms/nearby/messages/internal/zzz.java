package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.nearby.zza;
import com.google.android.gms.internal.nearby.zzc;

public final class zzz extends zza implements zzx {
    zzz(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.nearby.messages.internal.IStatusCallback");
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzx
    public final void onPermissionChanged(boolean z) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, z);
        this.transactOneway(1, parcel0);
    }
}

