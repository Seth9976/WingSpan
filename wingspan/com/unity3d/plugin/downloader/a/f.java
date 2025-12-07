package com.unity3d.plugin.downloader.a;

import android.os.IBinder;
import android.os.Parcel;

final class f implements d {
    private IBinder a;

    f(IBinder iBinder0) {
        this.a = iBinder0;
    }

    @Override  // com.unity3d.plugin.downloader.a.d
    public final void a(long v, String s, a a0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("com.android.vending.licensing.ILicensingService");
            parcel0.writeLong(v);
            parcel0.writeString(s);
            parcel0.writeStrongBinder((a0 == null ? null : a0.asBinder()));
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

