package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzm implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        zzj zzj0 = null;
        int v1 = 1;
        IBinder iBinder0 = null;
        IBinder iBinder1 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 2: {
                    zzj0 = (zzj)SafeParcelReader.createParcelable(parcel0, v2, zzj.CREATOR);
                    break;
                }
                case 3: {
                    iBinder0 = SafeParcelReader.readIBinder(parcel0, v2);
                    break;
                }
                case 4: {
                    iBinder1 = SafeParcelReader.readIBinder(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzl(v1, zzj0, iBinder0, iBinder1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzl[v];
    }
}

