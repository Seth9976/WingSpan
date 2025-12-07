package com.google.android.play.core.review.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzg extends zzb implements zzh {
    public zzg() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    @Override  // com.google.android.play.core.review.internal.zzb
    protected final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
        if(v == 2) {
            Bundle bundle0 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
            zzc.zzb(parcel0);
            this.zzb(bundle0);
            return true;
        }
        return false;
    }
}

