package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.nearby.zzgs;

public final class zza implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        byte[] arr_b = null;
        String s = null;
        String s1 = null;
        zzgs[] arr_zzgs = null;
        long v2 = 0L;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 1: {
                    arr_b = SafeParcelReader.createByteArray(parcel0, v3);
                    break;
                }
                case 2: {
                    s1 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 3: {
                    s = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 4: {
                    arr_zzgs = (zzgs[])SafeParcelReader.createTypedArray(parcel0, v3, zzgs.CREATOR);
                    break;
                }
                case 5: {
                    v2 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                case 1000: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new Message(v1, arr_b, s, s1, arr_zzgs, v2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new Message[v];
    }
}

