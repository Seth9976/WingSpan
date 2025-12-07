package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;

public abstract class zzaz extends zzb implements zzba {
    public zzaz() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        switch(v) {
            case 1: {
                this.zzd(((LocationResult)zzc.zzb(parcel0, LocationResult.CREATOR)));
                return true;
            }
            case 2: {
                this.zze(((LocationAvailability)zzc.zzb(parcel0, LocationAvailability.CREATOR)));
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static zzba zzb(IBinder iBinder0) {
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return iInterface0 instanceof zzba ? ((zzba)iInterface0) : new zzay(iBinder0);
    }
}

