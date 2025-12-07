package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzbe;
import java.util.List;

public final class zzau implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = "";
        List list0 = null;
        int v1 = 0;
        String s1 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 1: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v2, zzbe.CREATOR);
                    break;
                }
                case 2: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 3: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 4: {
                    s1 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new GeofencingRequest(list0, v1, s, s1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new GeofencingRequest[v];
    }
}

