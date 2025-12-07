package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.nearby.zzb;
import com.google.android.gms.internal.nearby.zzc;

public abstract class zzq extends zzb implements zzp {
    public zzq() {
        super("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
    }

    @Override  // com.google.android.gms.internal.nearby.zzb
    protected final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        if(v == 1) {
            this.zza(((Status)zzc.zza(parcel0, Status.CREATOR)));
            return true;
        }
        return false;
    }
}

