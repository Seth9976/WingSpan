package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzde extends zzb implements zzdd {
    public zzde() {
        super("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
    }

    @Override  // com.google.android.gms.internal.nearby.zzb
    protected final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        switch(v) {
            case 2: {
                this.zza(((zzej)zzc.zza(parcel0, zzej.CREATOR)));
                return true;
            }
            case 3: {
                this.zza(((zzfb)zzc.zza(parcel0, zzfb.CREATOR)));
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

