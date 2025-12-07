package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbv implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        long v1 = 0L;
        long v2 = 0L;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        while(parcel0.dataPosition() < v) {
            int v6 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v6)) {
                case 1: {
                    v1 = SafeParcelReader.readLong(parcel0, v6);
                    break;
                }
                case 2: {
                    v2 = SafeParcelReader.readLong(parcel0, v6);
                    break;
                }
                case 3: {
                    v3 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                case 4: {
                    v4 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                case 5: {
                    v5 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v6);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new SleepSegmentEvent(v1, v2, v3, v4, v5);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SleepSegmentEvent[v];
    }
}

