package com.google.android.play.core.review.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza implements IInterface {
    private final IBinder zza;
    private final String zzb;

    protected zza(IBinder iBinder0, String s) {
        this.zza = iBinder0;
        this.zzb = "com.google.android.play.core.inappreview.protocol.IInAppReviewService";
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.zza;
    }

    protected final Parcel zza() {
        Parcel parcel0 = Parcel.obtain();
        parcel0.writeInterfaceToken(this.zzb);
        return parcel0;
    }

    protected final void zzb(int v, Parcel parcel0) throws RemoteException {
        try {
            this.zza.transact(2, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }
}

