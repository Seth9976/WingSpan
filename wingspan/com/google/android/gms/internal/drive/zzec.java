package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzec extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    final IBinder zzgs;

    static {
        zzec.CREATOR = new zzed();
    }

    zzec(IBinder iBinder0) {
        this.zzgs = iBinder0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeIBinder(parcel0, 2, this.zzgs, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

