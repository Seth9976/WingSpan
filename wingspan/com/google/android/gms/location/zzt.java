package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzt implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        boolean z = true;
        long v1 = 50L;
        float f = 0.0f;
        long v2 = 0x7FFFFFFFFFFFFFFFL;
        int v3 = 0x7FFFFFFF;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 1: {
                    z = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 2: {
                    v1 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 3: {
                    f = SafeParcelReader.readFloat(parcel0, v4);
                    break;
                }
                case 4: {
                    v2 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 5: {
                    v3 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzs(z, v1, f, v2, v3);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzs[v];
    }
}

