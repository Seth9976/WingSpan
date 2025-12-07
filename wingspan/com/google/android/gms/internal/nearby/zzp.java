package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzp implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        IBinder iBinder0 = null;
        IBinder iBinder1 = null;
        String s = null;
        byte[] arr_b = null;
        IBinder iBinder2 = null;
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
                    s = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 4: {
                    arr_b = SafeParcelReader.createByteArray(parcel0, v1);
                    break;
                }
                case 5: {
                    iBinder2 = SafeParcelReader.readIBinder(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzm(iBinder0, iBinder1, s, arr_b, iBinder2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzm[v];
    }
}

