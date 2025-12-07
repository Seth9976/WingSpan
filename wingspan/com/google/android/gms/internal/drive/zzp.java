package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.Contents;

public final class zzp implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        Contents contents0 = null;
        int v1 = 0;
        Boolean boolean0 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 2: {
                    contents0 = (Contents)SafeParcelReader.createParcelable(parcel0, v2, Contents.CREATOR);
                    break;
                }
                case 3: {
                    boolean0 = SafeParcelReader.readBooleanObject(parcel0, v2);
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
        return new zzo(contents0, boolean0, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzo[v];
    }
}

