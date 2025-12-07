package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzfx implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        IBinder iBinder0 = null;
        zzfh zzfh0 = null;
        boolean z = false;
        String[] arr_s = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    iBinder0 = SafeParcelReader.readIBinder(parcel0, v1);
                    break;
                }
                case 2: {
                    arr_s = SafeParcelReader.createStringArray(parcel0, v1);
                    break;
                }
                case 3: {
                    zzfh0 = (zzfh)SafeParcelReader.createParcelable(parcel0, v1, zzfh.CREATOR);
                    break;
                }
                case 4: {
                    z = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzfu(iBinder0, arr_s, zzfh0, z);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzfu[v];
    }
}

