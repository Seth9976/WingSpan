package com.unity3d.plugin.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class e extends Binder implements d {
    public static d a(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.android.vending.licensing.ILicensingService");
        return iInterface0 != null && iInterface0 instanceof d ? ((d)iInterface0) : new f(iBinder0);
    }

    @Override  // android.os.Binder
    public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
        a a0;
        switch(v) {
            case 1: {
                parcel0.enforceInterface("com.android.vending.licensing.ILicensingService");
                long v2 = parcel0.readLong();
                String s = parcel0.readString();
                IBinder iBinder0 = parcel0.readStrongBinder();
                if(iBinder0 == null) {
                    a0 = null;
                }
                else {
                    IInterface iInterface0 = iBinder0.queryLocalInterface("com.android.vending.licensing.ILicenseResultListener");
                    a0 = iInterface0 == null || !(iInterface0 instanceof a) ? new c(iBinder0) : ((a)iInterface0);
                }
                this.a(v2, s, a0);
                return true;
            }
            case 0x5F4E5446: {
                parcel1.writeString("com.android.vending.licensing.ILicensingService");
                return true;
            }
            default: {
                return super.onTransact(v, parcel0, parcel1, v1);
            }
        }
    }
}

