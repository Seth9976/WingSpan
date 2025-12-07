package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzb implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        int v2 = 0;
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 2: {
                    v2 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 7: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 8: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 9: {
                    z2 = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new VideoConfiguration(v1, v2, z, z1, z2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new VideoConfiguration[v];
    }
}

