package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.nearby.zza;

public final class zzac extends zza implements zzaa {
    zzac(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzaa
    public final void onExpired() throws RemoteException {
        this.transactOneway(1, this.obtainAndWriteInterfaceToken());
    }
}

