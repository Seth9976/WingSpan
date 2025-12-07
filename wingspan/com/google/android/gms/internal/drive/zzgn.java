package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public final class zzgn implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String[] arr_s = null;
        DriveId driveId0 = null;
        FilterHolder filterHolder0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 3: {
                    arr_s = SafeParcelReader.createStringArray(parcel0, v1);
                    break;
                }
                case 4: {
                    driveId0 = (DriveId)SafeParcelReader.createParcelable(parcel0, v1, DriveId.CREATOR);
                    break;
                }
                case 5: {
                    filterHolder0 = (FilterHolder)SafeParcelReader.createParcelable(parcel0, v1, FilterHolder.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzgm(s, arr_s, driveId0, filterHolder0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzgm[v];
    }
}

