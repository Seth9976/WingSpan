package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzfk implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        long v1 = 0L;
        int v2 = 0;
        byte[] arr_b = null;
        ParcelFileDescriptor parcelFileDescriptor0 = null;
        String s = null;
        ParcelFileDescriptor parcelFileDescriptor1 = null;
        long v3 = -1L;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 1: {
                    v1 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 2: {
                    v2 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 3: {
                    arr_b = SafeParcelReader.createByteArray(parcel0, v4);
                    break;
                }
                case 4: {
                    parcelFileDescriptor0 = (ParcelFileDescriptor)SafeParcelReader.createParcelable(parcel0, v4, ParcelFileDescriptor.CREATOR);
                    break;
                }
                case 5: {
                    s = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 6: {
                    v3 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 7: {
                    parcelFileDescriptor1 = (ParcelFileDescriptor)SafeParcelReader.createParcelable(parcel0, v4, ParcelFileDescriptor.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzfh(v1, v2, arr_b, parcelFileDescriptor0, s, v3, parcelFileDescriptor1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzfh[v];
    }
}

