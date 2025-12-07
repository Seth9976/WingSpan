package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveId;

public final class zzgk implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        DriveId driveId0 = null;
        int v1 = 0;
        int v2 = 0;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 2: {
                    driveId0 = (DriveId)SafeParcelReader.createParcelable(parcel0, v3, DriveId.CREATOR);
                    break;
                }
                case 3: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 4: {
                    v2 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzgj(driveId0, v1, v2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzgj[v];
    }
}

