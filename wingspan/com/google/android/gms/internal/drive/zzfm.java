package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.zzh;
import java.util.List;

public final class zzfm implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        long v1 = 0L;
        long v2 = 0L;
        int v3 = 0;
        List list0 = null;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 2: {
                    v1 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 3: {
                    v2 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 4: {
                    v3 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 5: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v4, zzh.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzfl(v1, v2, v3, list0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzfl[v];
    }
}

