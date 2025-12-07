package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbn implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    z = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                case 2: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                case 3: {
                    z2 = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                case 4: {
                    z3 = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                case 5: {
                    z4 = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                case 6: {
                    z5 = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new LocationSettingsStates(z, z1, z2, z3, z4, z5);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new LocationSettingsStates[v];
    }
}

