package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbf implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 102;
        long v2 = 3600000L;
        long v3 = 600000L;
        boolean z = false;
        boolean z1 = false;
        long v4 = 0x7FFFFFFFFFFFFFFFL;
        int v5 = 0x7FFFFFFF;
        float f = 0.0f;
        long v6 = 0L;
        while(parcel0.dataPosition() < v) {
            int v7 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v7)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v7);
                    break;
                }
                case 2: {
                    v2 = SafeParcelReader.readLong(parcel0, v7);
                    break;
                }
                case 3: {
                    v3 = SafeParcelReader.readLong(parcel0, v7);
                    break;
                }
                case 4: {
                    z = SafeParcelReader.readBoolean(parcel0, v7);
                    break;
                }
                case 5: {
                    v4 = SafeParcelReader.readLong(parcel0, v7);
                    break;
                }
                case 6: {
                    v5 = SafeParcelReader.readInt(parcel0, v7);
                    break;
                }
                case 7: {
                    f = SafeParcelReader.readFloat(parcel0, v7);
                    break;
                }
                case 8: {
                    v6 = SafeParcelReader.readLong(parcel0, v7);
                    break;
                }
                case 9: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v7);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v7);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new LocationRequest(v1, v2, v3, z, v4, v5, f, v6, z1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new LocationRequest[v];
    }
}

