package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.nearby.zza;
import com.google.android.gms.internal.nearby.zzc;

public final class zzr extends zza implements zzp {
    zzr(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzp
    public final void zza(Status status0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, status0);
        this.transactOneway(1, parcel0);
    }
}

