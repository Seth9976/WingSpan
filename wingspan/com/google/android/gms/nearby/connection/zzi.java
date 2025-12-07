package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzi implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        long v1 = 0L;
        long v2 = 0L;
        long v3 = 0L;
        int v4 = 0;
        while(parcel0.dataPosition() < v) {
            int v5 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v5)) {
                case 1: {
                    v1 = SafeParcelReader.readLong(parcel0, v5);
                    break;
                }
                case 2: {
                    v4 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 3: {
                    v2 = SafeParcelReader.readLong(parcel0, v5);
                    break;
                }
                case 4: {
                    v3 = SafeParcelReader.readLong(parcel0, v5);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v5);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new PayloadTransferUpdate(v1, v4, v2, v3);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new PayloadTransferUpdate[v];
    }
}

