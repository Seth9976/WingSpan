package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzds extends zzb implements zzdr {
    public zzds() {
        super("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    @Override  // com.google.android.gms.internal.nearby.zzb
    protected final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        switch(v) {
            case 2: {
                this.zza(((zzer)zzc.zza(parcel0, zzer.CREATOR)));
                return true;
            }
            case 3: {
                this.zza(((zzet)zzc.zza(parcel0, zzet.CREATOR)));
                return true;
            }
            case 4: {
                this.zza(((zzfd)zzc.zza(parcel0, zzfd.CREATOR)));
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

