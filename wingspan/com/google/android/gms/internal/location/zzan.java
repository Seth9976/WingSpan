package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsResult;

public abstract class zzan extends zzb implements zzao {
    public zzan() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        if(v == 1) {
            this.zzb(((LocationSettingsResult)zzc.zzb(parcel0, LocationSettingsResult.CREATOR)));
            return true;
        }
        return false;
    }
}

