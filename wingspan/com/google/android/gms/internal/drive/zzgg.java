package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzgg implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        ParcelFileDescriptor parcelFileDescriptor0 = null;
        IBinder iBinder0 = null;
        String s = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 2: {
                    parcelFileDescriptor0 = (ParcelFileDescriptor)SafeParcelReader.createParcelable(parcel0, v1, ParcelFileDescriptor.CREATOR);
                    break;
                }
                case 3: {
                    iBinder0 = SafeParcelReader.readIBinder(parcel0, v1);
                    break;
                }
                case 4: {
                    s = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzgf(parcelFileDescriptor0, iBinder0, s);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzgf[v];
    }
}

