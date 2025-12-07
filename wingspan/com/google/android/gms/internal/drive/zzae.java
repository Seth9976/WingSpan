package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzae implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        while(parcel0.dataPosition() < v) {
            SafeParcelReader.skipUnknownField(parcel0, SafeParcelReader.readHeader(parcel0));
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzad();
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzad[v];
    }
}

