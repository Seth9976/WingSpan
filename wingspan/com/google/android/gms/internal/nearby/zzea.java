package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzea extends zzb implements zzdz {
    public zzea() {
        super("com.google.android.gms.nearby.internal.connection.IResultListener");
    }

    @Override  // com.google.android.gms.internal.nearby.zzb
    protected final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        if(v == 2) {
            this.zzc(parcel0.readInt());
            return true;
        }
        return false;
    }
}

