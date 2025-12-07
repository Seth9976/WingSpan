package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzdh extends zzb implements zzdg {
    public zzdh() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
    }

    @Override  // com.google.android.gms.internal.nearby.zzb
    protected final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        switch(v) {
            case 2: {
                this.zza(((zzev)zzc.zza(parcel0, zzev.CREATOR)));
                return true;
            }
            case 3: {
                this.zza(((zzep)zzc.zza(parcel0, zzep.CREATOR)));
                return true;
            }
            case 4: {
                this.zza(((zzex)zzc.zza(parcel0, zzex.CREATOR)));
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

