package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zza implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        boolean z = false;
        String s = null;
        List list0 = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        long v5 = 0L;
        long v6 = 0L;
        long v7 = 0L;
        float f = 0.0f;
        while(parcel0.dataPosition() < v) {
            int v8 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v8)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v8);
                    break;
                }
                case 2: {
                    v5 = SafeParcelReader.readLong(parcel0, v8);
                    break;
                }
                case 4: {
                    s = SafeParcelReader.createString(parcel0, v8);
                    break;
                }
                case 5: {
                    v3 = SafeParcelReader.readInt(parcel0, v8);
                    break;
                }
                case 6: {
                    list0 = SafeParcelReader.createStringList(parcel0, v8);
                    break;
                }
                case 8: {
                    v6 = SafeParcelReader.readLong(parcel0, v8);
                    break;
                }
                case 10: {
                    s2 = SafeParcelReader.createString(parcel0, v8);
                    break;
                }
                case 11: {
                    v2 = SafeParcelReader.readInt(parcel0, v8);
                    break;
                }
                case 12: {
                    s1 = SafeParcelReader.createString(parcel0, v8);
                    break;
                }
                case 13: {
                    s3 = SafeParcelReader.createString(parcel0, v8);
                    break;
                }
                case 14: {
                    v4 = SafeParcelReader.readInt(parcel0, v8);
                    break;
                }
                case 15: {
                    f = SafeParcelReader.readFloat(parcel0, v8);
                    break;
                }
                case 16: {
                    v7 = SafeParcelReader.readLong(parcel0, v8);
                    break;
                }
                case 17: {
                    s4 = SafeParcelReader.createString(parcel0, v8);
                    break;
                }
                case 18: {
                    z = SafeParcelReader.readBoolean(parcel0, v8);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v8);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new WakeLockEvent(v1, v5, v2, s, v3, list0, s1, v6, v4, s2, s3, f, v7, s4, z);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new WakeLockEvent[v];
    }
}

