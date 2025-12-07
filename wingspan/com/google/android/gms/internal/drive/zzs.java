package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzs implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0x20000000;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            if(((char)v2) == 2) {
                v1 = SafeParcelReader.readInt(parcel0, v2);
            }
            else {
                SafeParcelReader.skipUnknownField(parcel0, v2);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzr(v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzr[v];
    }
}

