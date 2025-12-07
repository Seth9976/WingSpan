package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;

public final class zzf implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        List list0 = null;
        boolean z = false;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 2: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 3: {
                    z = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 4: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v2, DriveSpace.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zze(v1, z, list0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zze[v];
    }
}

