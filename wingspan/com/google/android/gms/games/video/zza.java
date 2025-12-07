package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zza implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        boolean[] arr_z = null;
        boolean[] arr_z1 = null;
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
                    arr_z = SafeParcelReader.createBooleanArray(parcel0, v1);
                    break;
                }
                case 5: {
                    arr_z1 = SafeParcelReader.createBooleanArray(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new VideoCapabilities(z, z1, z2, arr_z, arr_z1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new VideoCapabilities[v];
    }
}

