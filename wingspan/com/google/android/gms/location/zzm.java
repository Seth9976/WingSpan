package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzm implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        long v2 = 0L;
        int v3 = 0;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 2: {
                    v3 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 3: {
                    v2 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new ActivityTransitionEvent(v1, v3, v2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new ActivityTransitionEvent[v];
    }
}

