package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.nearby.zzb;
import com.google.android.gms.internal.nearby.zzc;

public abstract class zzn extends zzb implements zzm {
    public zzn() {
        super("com.google.android.gms.nearby.messages.internal.IMessageListener");
    }

    @Override  // com.google.android.gms.internal.nearby.zzb
    protected final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        switch(v) {
            case 1: {
                this.zza(((zzaf)zzc.zza(parcel0, zzaf.CREATOR)));
                return true;
            }
            case 2: {
                this.zzb(((zzaf)zzc.zza(parcel0, zzaf.CREATOR)));
                return true;
            }
            case 4: {
                this.zza(parcel0.createTypedArrayList(Update.CREATOR));
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

