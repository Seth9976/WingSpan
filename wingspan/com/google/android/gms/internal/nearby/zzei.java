package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzei implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String s1 = null;
        String s2 = null;
        byte[] arr_b = null;
        boolean z = false;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    s = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 2: {
                    s1 = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 3: {
                    s2 = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 4: {
                    z = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                case 5: {
                    arr_b = SafeParcelReader.createByteArray(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzeh(s, s1, s2, z, arr_b);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzeh[v];
    }
}

