package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zze;
import com.google.android.gms.drive.events.zzt;
import com.google.android.gms.drive.events.zzx;

public final class zzk implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        DriveId driveId0 = null;
        zze zze0 = null;
        zzx zzx0 = null;
        zzt zzt0 = null;
        int v1 = 0;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 2: {
                    driveId0 = (DriveId)SafeParcelReader.createParcelable(parcel0, v2, DriveId.CREATOR);
                    break;
                }
                case 3: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 4: {
                    zze0 = (zze)SafeParcelReader.createParcelable(parcel0, v2, zze.CREATOR);
                    break;
                }
                case 5: {
                    zzx0 = (zzx)SafeParcelReader.createParcelable(parcel0, v2, zzx.CREATOR);
                    break;
                }
                case 6: {
                    zzt0 = (zzt)SafeParcelReader.createParcelable(parcel0, v2, zzt.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzj(driveId0, v1, zze0, zzx0, zzt0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzj[v];
    }
}

