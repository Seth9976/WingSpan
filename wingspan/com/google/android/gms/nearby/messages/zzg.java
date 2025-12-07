package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzg implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        boolean z = false;
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        while(parcel0.dataPosition() < v) {
            int v8 = SafeParcelReader.readHeader(parcel0);
            int v9 = (char)v8;
            if(v9 == 1000) {
                v1 = SafeParcelReader.readInt(parcel0, v8);
            }
            else {
                switch(v9) {
                    case 1: {
                        v2 = SafeParcelReader.readInt(parcel0, v8);
                        break;
                    }
                    case 2: {
                        v3 = SafeParcelReader.readInt(parcel0, v8);
                        break;
                    }
                    case 3: {
                        v4 = SafeParcelReader.readInt(parcel0, v8);
                        break;
                    }
                    case 4: {
                        z = SafeParcelReader.readBoolean(parcel0, v8);
                        break;
                    }
                    case 5: {
                        v5 = SafeParcelReader.readInt(parcel0, v8);
                        break;
                    }
                    case 6: {
                        v6 = SafeParcelReader.readInt(parcel0, v8);
                        break;
                    }
                    case 7: {
                        v7 = SafeParcelReader.readInt(parcel0, v8);
                        break;
                    }
                    default: {
                        SafeParcelReader.skipUnknownField(parcel0, v8);
                    }
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new Strategy(v1, v2, v3, v4, z, v5, v6, v7);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new Strategy[v];
    }
}

