package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzc implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        zze zze0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            if(((char)v1) == 3) {
                zze0 = (zze)SafeParcelReader.createParcelable(parcel0, v1, zze.CREATOR);
            }
            else {
                SafeParcelReader.skipUnknownField(parcel0, v1);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzb(zze0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzb[v];
    }
}

