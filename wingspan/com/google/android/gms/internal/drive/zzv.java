package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzv implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        MetadataBundle metadataBundle0 = null;
        String s = null;
        DriveId driveId0 = null;
        Integer integer0 = null;
        int v1 = 0;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 2: {
                    metadataBundle0 = (MetadataBundle)SafeParcelReader.createParcelable(parcel0, v2, MetadataBundle.CREATOR);
                    break;
                }
                case 3: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 4: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 5: {
                    driveId0 = (DriveId)SafeParcelReader.createParcelable(parcel0, v2, DriveId.CREATOR);
                    break;
                }
                case 6: {
                    integer0 = SafeParcelReader.readIntegerObject(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzu(metadataBundle0, v1, s, driveId0, integer0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzu[v];
    }
}

