package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.nearby.zzb;
import com.google.android.gms.internal.nearby.zzc;

public abstract class zzy extends zzb implements zzx {
    public zzy() {
        super("com.google.android.gms.nearby.messages.internal.IStatusCallback");
    }

    @Override  // com.google.android.gms.internal.nearby.zzb
    protected final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        if(v == 1) {
            this.onPermissionChanged(zzc.zza(parcel0));
            return true;
        }
        return false;
    }
}

