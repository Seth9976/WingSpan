package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzfk implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        zzei zzei0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            if(((char)v1) == 2) {
                zzei0 = (zzei)SafeParcelReader.createParcelable(parcel0, v1, zzei.CREATOR);
            }
            else {
                SafeParcelReader.skipUnknownField(parcel0, v1);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzfj(zzei0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzfj[v];
    }
}

