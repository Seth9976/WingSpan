package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zza implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        String s = null;
        String s1 = null;
        String s2 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 3: {
                    s1 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 4: {
                    s2 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new PlaceReport(v1, s, s1, s2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new PlaceReport[v];
    }
}

