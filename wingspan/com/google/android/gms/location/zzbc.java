package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;

public abstract class zzbc extends zzb implements zzbd {
    public zzbc() {
        super("com.google.android.gms.location.ILocationListener");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        if(v == 1) {
            this.zzd(((Location)zzc.zzb(parcel0, Location.CREATOR)));
            return true;
        }
        return false;
    }

    public static zzbd zzb(IBinder iBinder0) {
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return iInterface0 instanceof zzbd ? ((zzbd)iInterface0) : new zzbb(iBinder0);
    }
}

