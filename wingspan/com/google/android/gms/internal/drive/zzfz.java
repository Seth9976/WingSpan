package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzfz implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        MetadataBundle metadataBundle0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            if(((char)v1) == 2) {
                metadataBundle0 = (MetadataBundle)SafeParcelReader.createParcelable(parcel0, v1, MetadataBundle.CREATOR);
            }
            else {
                SafeParcelReader.skipUnknownField(parcel0, v1);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzfy(metadataBundle0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzfy[v];
    }
}

