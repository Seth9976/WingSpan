package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzc implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        zzx zzx0 = null;
        MetadataBundle metadataBundle0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    zzx0 = (zzx)SafeParcelReader.createParcelable(parcel0, v1, zzx.CREATOR);
                    break;
                }
                case 2: {
                    metadataBundle0 = (MetadataBundle)SafeParcelReader.createParcelable(parcel0, v1, MetadataBundle.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzb(zzx0, metadataBundle0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzb[v];
    }
}

