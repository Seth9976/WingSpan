package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzah extends zzb implements zzai {
    public zzah() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        switch(v) {
            case 1: {
                this.zzb(((zzaa)zzc.zzb(parcel0, zzaa.CREATOR)));
                return true;
            }
            case 2: {
                this.zzc();
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

