package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzb implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        Strategy strategy0 = null;
        byte[] arr_b = null;
        boolean z = true;
        boolean z1 = true;
        boolean z2 = true;
        boolean z3 = true;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    strategy0 = (Strategy)SafeParcelReader.createParcelable(parcel0, v1, Strategy.CREATOR);
                    break;
                }
                case 2: {
                    z = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                case 3: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                case 4: {
                    z2 = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                case 5: {
                    z3 = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                case 6: {
                    arr_b = SafeParcelReader.createByteArray(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new AdvertisingOptions(strategy0, z, z1, z2, z3, arr_b);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new AdvertisingOptions[v];
    }
}

