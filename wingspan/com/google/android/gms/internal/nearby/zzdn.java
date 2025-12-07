package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzdn extends zzb implements zzdm {
    public zzdn() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
    }

    @Override  // com.google.android.gms.internal.nearby.zzb
    protected final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        if(v == 2) {
            this.zza(((zzel)zzc.zza(parcel0, zzel.CREATOR)));
            return true;
        }
        return false;
    }
}

