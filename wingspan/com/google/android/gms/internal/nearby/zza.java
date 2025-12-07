package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza implements IInterface {
    private final IBinder zza;
    private final String zzb;

    protected zza(IBinder iBinder0, String s) {
        this.zza = iBinder0;
        this.zzb = s;
    }

    @Override  // android.os.IInterface
    public IBinder asBinder() {
        return this.zza;
    }

    protected final Parcel obtainAndWriteInterfaceToken() {
        Parcel parcel0 = Parcel.obtain();
        parcel0.writeInterfaceToken(this.zzb);
        return parcel0;
    }

    protected final void transactAndReadExceptionReturnVoid(int v, Parcel parcel0) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        try {
            this.zza.transact(v, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel0.recycle();
            parcel1.recycle();
        }
    }

    protected final void transactOneway(int v, Parcel parcel0) throws RemoteException {
        try {
            this.zza.transact(v, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }
}

