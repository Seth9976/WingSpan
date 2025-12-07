package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzdk extends zzb implements zzdj {
    public zzdk() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    @Override  // com.google.android.gms.internal.nearby.zzb
    protected final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        switch(v) {
            case 2: {
                this.zza(((zzeh)zzc.zza(parcel0, zzeh.CREATOR)));
                return true;
            }
            case 3: {
                this.zza(((zzen)zzc.zza(parcel0, zzen.CREATOR)));
                return true;
            }
            case 4: {
                this.zza(((zzep)zzc.zza(parcel0, zzep.CREATOR)));
                return true;
            }
            case 5: {
                this.zza(((zzef)zzc.zza(parcel0, zzef.CREATOR)));
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

