package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzgq implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        int v2 = 0;
        ParcelUuid parcelUuid0 = null;
        ParcelUuid parcelUuid1 = null;
        ParcelUuid parcelUuid2 = null;
        byte[] arr_b = null;
        byte[] arr_b1 = null;
        byte[] arr_b2 = null;
        byte[] arr_b3 = null;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            int v4 = (char)v3;
            if(v4 == 1) {
                v1 = SafeParcelReader.readInt(parcel0, v3);
            }
            else {
                switch(v4) {
                    case 4: {
                        parcelUuid0 = (ParcelUuid)SafeParcelReader.createParcelable(parcel0, v3, ParcelUuid.CREATOR);
                        break;
                    }
                    case 5: {
                        parcelUuid1 = (ParcelUuid)SafeParcelReader.createParcelable(parcel0, v3, ParcelUuid.CREATOR);
                        break;
                    }
                    case 6: {
                        parcelUuid2 = (ParcelUuid)SafeParcelReader.createParcelable(parcel0, v3, ParcelUuid.CREATOR);
                        break;
                    }
                    case 7: {
                        arr_b = SafeParcelReader.createByteArray(parcel0, v3);
                        break;
                    }
                    case 8: {
                        arr_b1 = SafeParcelReader.createByteArray(parcel0, v3);
                        break;
                    }
                    case 9: {
                        v2 = SafeParcelReader.readInt(parcel0, v3);
                        break;
                    }
                    case 10: {
                        arr_b2 = SafeParcelReader.createByteArray(parcel0, v3);
                        break;
                    }
                    case 11: {
                        arr_b3 = SafeParcelReader.createByteArray(parcel0, v3);
                        break;
                    }
                    default: {
                        SafeParcelReader.skipUnknownField(parcel0, v3);
                    }
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzgp(v1, parcelUuid0, parcelUuid1, parcelUuid2, arr_b, arr_b1, v2, arr_b2, arr_b3);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzgp[v];
    }
}

