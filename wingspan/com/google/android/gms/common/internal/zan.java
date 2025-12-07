package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zan implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = -1;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        String s = null;
        String s1 = null;
        long v6 = 0L;
        long v7 = 0L;
        while(parcel0.dataPosition() < v) {
            int v8 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v8)) {
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
                    v6 = SafeParcelReader.readLong(parcel0, v8);
                    break;
                }
                case 5: {
                    v7 = SafeParcelReader.readLong(parcel0, v8);
                    break;
                }
                case 6: {
                    s = SafeParcelReader.createString(parcel0, v8);
                    break;
                }
                case 7: {
                    s1 = SafeParcelReader.createString(parcel0, v8);
                    break;
                }
                case 8: {
                    v5 = SafeParcelReader.readInt(parcel0, v8);
                    break;
                }
                case 9: {
                    v1 = SafeParcelReader.readInt(parcel0, v8);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v8);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new MethodInvocation(v2, v3, v4, v6, v7, s, s1, v5, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new MethodInvocation[v];
    }
}

