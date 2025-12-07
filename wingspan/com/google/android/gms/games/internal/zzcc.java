package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.games.zzb;
import com.google.android.gms.internal.games.zzc;
import com.google.android.gms.internal.games.zzfr;

public abstract class zzcc extends zzb implements zzcd {
    public zzcc() {
        super("com.google.android.gms.games.internal.IGamesClient");
    }

    @Override  // com.google.android.gms.internal.games.zzb
    protected final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        if(v == 1001) {
            zzfr zzfr0 = this.zzb();
            parcel1.writeNoException();
            zzc.zze(parcel1, zzfr0);
            return true;
        }
        return false;
    }
}

