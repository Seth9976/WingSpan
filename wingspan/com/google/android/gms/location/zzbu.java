package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbu implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        boolean z = false;
        int v8 = 0;
        while(parcel0.dataPosition() < v) {
            int v9 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v9)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v9);
                    break;
                }
                case 2: {
                    v2 = SafeParcelReader.readInt(parcel0, v9);
                    break;
                }
                case 3: {
                    v3 = SafeParcelReader.readInt(parcel0, v9);
                    break;
                }
                case 4: {
                    v4 = SafeParcelReader.readInt(parcel0, v9);
                    break;
                }
                case 5: {
                    v5 = SafeParcelReader.readInt(parcel0, v9);
                    break;
                }
                case 6: {
                    v6 = SafeParcelReader.readInt(parcel0, v9);
                    break;
                }
                case 7: {
                    v7 = SafeParcelReader.readInt(parcel0, v9);
                    break;
                }
                case 8: {
                    z = SafeParcelReader.readBoolean(parcel0, v9);
                    break;
                }
                case 9: {
                    v8 = SafeParcelReader.readInt(parcel0, v9);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v9);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new SleepClassifyEvent(v1, v2, v3, v4, v5, v6, v7, z, v8);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SleepClassifyEvent[v];
    }
}

