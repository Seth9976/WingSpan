package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzft implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        IBinder iBinder0 = null;
        IBinder iBinder1 = null;
        IBinder iBinder2 = null;
        String s = null;
        String s1 = null;
        byte[] arr_b = null;
        IBinder iBinder3 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    iBinder0 = SafeParcelReader.readIBinder(parcel0, v1);
                    break;
                }
                case 2: {
                    iBinder1 = SafeParcelReader.readIBinder(parcel0, v1);
                    break;
                }
                case 3: {
                    iBinder2 = SafeParcelReader.readIBinder(parcel0, v1);
                    break;
                }
                case 4: {
                    s = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 5: {
                    s1 = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 6: {
                    arr_b = SafeParcelReader.createByteArray(parcel0, v1);
                    break;
                }
                case 7: {
                    iBinder3 = SafeParcelReader.readIBinder(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzfq(iBinder0, iBinder1, iBinder2, s, s1, arr_b, iBinder3);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzfq[v];
    }
}

