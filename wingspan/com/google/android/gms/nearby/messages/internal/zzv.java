package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.nearby.zzb;

public abstract class zzv extends zzb implements zzu {
    public zzv() {
        super("com.google.android.gms.nearby.messages.internal.IPublishCallback");
    }

    @Override  // com.google.android.gms.internal.nearby.zzb
    protected final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        if(v == 1) {
            this.onExpired();
            return true;
        }
        return false;
    }
}

