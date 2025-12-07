package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveId;

public final class zzel implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        DriveId driveId0 = null;
        boolean z = false;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 2: {
                    driveId0 = (DriveId)SafeParcelReader.createParcelable(parcel0, v1, DriveId.CREATOR);
                    break;
                }
                case 3: {
                    z = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzek(driveId0, z);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzek[v];
    }
}

