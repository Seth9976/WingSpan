package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbm implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        Status status0 = null;
        LocationSettingsStates locationSettingsStates0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    status0 = (Status)SafeParcelReader.createParcelable(parcel0, v1, Status.CREATOR);
                    break;
                }
                case 2: {
                    locationSettingsStates0 = (LocationSettingsStates)SafeParcelReader.createParcelable(parcel0, v1, LocationSettingsStates.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new LocationSettingsResult(status0, locationSettingsStates0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new LocationSettingsResult[v];
    }
}

