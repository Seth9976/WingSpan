package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzc implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        ParcelFileDescriptor parcelFileDescriptor0 = null;
        DriveId driveId0 = null;
        String s = null;
        int v1 = 0;
        int v2 = 0;
        boolean z = false;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 2: {
                    parcelFileDescriptor0 = (ParcelFileDescriptor)SafeParcelReader.createParcelable(parcel0, v3, ParcelFileDescriptor.CREATOR);
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
                case 5: {
                    driveId0 = (DriveId)SafeParcelReader.createParcelable(parcel0, v3, DriveId.CREATOR);
                    break;
                }
                case 7: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 8: {
                    s = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new Contents(parcelFileDescriptor0, v1, v2, driveId0, z, s);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new Contents[v];
    }
}

