package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzn implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        DriveId driveId0 = null;
        MetadataBundle metadataBundle0 = null;
        Contents contents0 = null;
        String s = null;
        boolean z = false;
        int v1 = 0;
        int v2 = 0;
        boolean z1 = false;
        boolean z2 = true;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 2: {
                    driveId0 = (DriveId)SafeParcelReader.createParcelable(parcel0, v3, DriveId.CREATOR);
                    break;
                }
                case 3: {
                    metadataBundle0 = (MetadataBundle)SafeParcelReader.createParcelable(parcel0, v3, MetadataBundle.CREATOR);
                    break;
                }
                case 4: {
                    contents0 = (Contents)SafeParcelReader.createParcelable(parcel0, v3, Contents.CREATOR);
                    break;
                }
                case 5: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 6: {
                    s = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 7: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 8: {
                    v2 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 9: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 10: {
                    z2 = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzm(driveId0, metadataBundle0, contents0, z, s, v1, v2, z1, z2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzm[v];
    }
}

