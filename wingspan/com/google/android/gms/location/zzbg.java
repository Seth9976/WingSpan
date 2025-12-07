package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzbg implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        List list0 = LocationResult.zza;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            if(((char)v1) == 1) {
                list0 = SafeParcelReader.createTypedList(parcel0, v1, Location.CREATOR);
            }
            else {
                SafeParcelReader.skipUnknownField(parcel0, v1);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new LocationResult(list0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new LocationResult[v];
    }
}

