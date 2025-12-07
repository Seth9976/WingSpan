package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzp implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        DataHolder dataHolder0 = null;
        boolean z = false;
        int v1 = 0;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 2: {
                    dataHolder0 = (DataHolder)SafeParcelReader.createParcelable(parcel0, v2, DataHolder.CREATOR);
                    break;
                }
                case 3: {
                    z = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 4: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzo(dataHolder0, z, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzo[v];
    }
}

