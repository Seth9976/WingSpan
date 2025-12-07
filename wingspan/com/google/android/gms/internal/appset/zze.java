package com.google.android.gms.internal.appset;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class zze extends zzb implements zzf {
    public zze() {
        super("com.google.android.gms.appset.internal.IAppSetIdCallback");
    }

    @Override  // com.google.android.gms.internal.appset.zzb
    protected final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        if(v == 1) {
            this.zzb(((Status)zzc.zza(parcel0, Status.CREATOR)), ((com.google.android.gms.appset.zzc)zzc.zza(parcel0, com.google.android.gms.appset.zzc.CREATOR)));
            return true;
        }
        return false;
    }
}

