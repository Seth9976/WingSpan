package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzha implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        List list0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            if(((char)v1) == 2) {
                list0 = SafeParcelReader.createStringList(parcel0, v1);
            }
            else {
                SafeParcelReader.skipUnknownField(parcel0, v1);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzgz(list0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzgz[v];
    }
}

