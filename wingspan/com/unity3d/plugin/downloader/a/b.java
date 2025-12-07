package com.unity3d.plugin.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class b extends Binder implements a {
    public b() {
        this.attachInterface(this, "com.android.vending.licensing.ILicenseResultListener");
    }

    @Override  // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override  // android.os.Binder
    public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                parcel0.enforceInterface("com.android.vending.licensing.ILicenseResultListener");
                this.a(parcel0.readInt(), parcel0.readString(), parcel0.readString());
                return true;
            }
            case 0x5F4E5446: {
                parcel1.writeString("com.android.vending.licensing.ILicenseResultListener");
                return true;
            }
            default: {
                return super.onTransact(v, parcel0, parcel1, v1);
            }
        }
    }
}

