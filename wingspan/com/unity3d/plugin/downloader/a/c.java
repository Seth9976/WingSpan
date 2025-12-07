package com.unity3d.plugin.downloader.a;

import android.os.IBinder;
import android.os.Parcel;

final class c implements a {
    private IBinder a;

    c(IBinder iBinder0) {
        this.a = iBinder0;
    }

    @Override  // com.unity3d.plugin.downloader.a.a
    public final void a(int v, String s, String s1) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("com.android.vending.licensing.ILicenseResultListener");
            parcel0.writeInt(v);
            parcel0.writeString(s);
            parcel0.writeString(s1);
            this.a.transact(1, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}

