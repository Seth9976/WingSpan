package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzc extends zzw implements zzd {
    public zzc() {
        super("com.android.vending.billing.IInAppBillingCreateAlternativeBillingOnlyTokenCallback");
    }

    @Override  // com.google.android.gms.internal.play_billing.zzw
    protected final boolean zzb(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        if(v == 1) {
            Bundle bundle0 = (Bundle)zzx.zza(parcel0, Bundle.CREATOR);
            zzx.zzb(parcel0);
            this.zza(bundle0);
            return true;
        }
        return false;
    }
}

