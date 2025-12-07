package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzet extends zzb implements zzes {
    public zzet() {
        super("com.google.android.gms.drive.internal.IEventCallback");
    }

    @Override  // com.google.android.gms.internal.drive.zzb
    protected final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        if(v == 1) {
            this.zzc(((zzfp)zzc.zza(parcel0, zzfp.CREATOR)));
            parcel1.writeNoException();
            return true;
        }
        return false;
    }
}

