package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzed extends zzb implements zzec {
    public zzed() {
        super("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
    }

    @Override  // com.google.android.gms.internal.nearby.zzb
    protected final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        if(v == 2) {
            this.zza(((zzez)zzc.zza(parcel0, zzez.CREATOR)));
            return true;
        }
        return false;
    }
}

