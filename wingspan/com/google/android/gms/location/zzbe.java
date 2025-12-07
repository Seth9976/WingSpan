package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbe implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 1000;
        int v2 = 1;
        int v3 = 1;
        long v4 = 0L;
        zzbo[] arr_zzbo = null;
        while(parcel0.dataPosition() < v) {
            int v5 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v5)) {
                case 1: {
                    v2 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 2: {
                    v3 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 3: {
                    v4 = SafeParcelReader.readLong(parcel0, v5);
                    break;
                }
                case 4: {
                    v1 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 5: {
                    arr_zzbo = (zzbo[])SafeParcelReader.createTypedArray(parcel0, v5, zzbo.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v5);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new LocationAvailability(v1, v2, v3, v4, arr_zzbo);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new LocationAvailability[v];
    }
}

