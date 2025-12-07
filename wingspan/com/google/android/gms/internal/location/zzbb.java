package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public final class zzbb implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        List list0 = zzba.zza;
        LocationRequest locationRequest0 = null;
        String s = null;
        String s1 = null;
        String s2 = null;
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            int v3 = (char)v2;
            if(v3 == 1) {
                locationRequest0 = (LocationRequest)SafeParcelReader.createParcelable(parcel0, v2, LocationRequest.CREATOR);
            }
            else {
                switch(v3) {
                    case 5: {
                        list0 = SafeParcelReader.createTypedList(parcel0, v2, ClientIdentity.CREATOR);
                        break;
                    }
                    case 6: {
                        s = SafeParcelReader.createString(parcel0, v2);
                        break;
                    }
                    case 7: {
                        z = SafeParcelReader.readBoolean(parcel0, v2);
                        break;
                    }
                    case 8: {
                        z1 = SafeParcelReader.readBoolean(parcel0, v2);
                        break;
                    }
                    case 9: {
                        z2 = SafeParcelReader.readBoolean(parcel0, v2);
                        break;
                    }
                    case 10: {
                        s1 = SafeParcelReader.createString(parcel0, v2);
                        break;
                    }
                    case 11: {
                        z3 = SafeParcelReader.readBoolean(parcel0, v2);
                        break;
                    }
                    case 12: {
                        z4 = SafeParcelReader.readBoolean(parcel0, v2);
                        break;
                    }
                    case 13: {
                        s2 = SafeParcelReader.createString(parcel0, v2);
                        break;
                    }
                    case 14: {
                        v1 = SafeParcelReader.readLong(parcel0, v2);
                        break;
                    }
                    default: {
                        SafeParcelReader.skipUnknownField(parcel0, v2);
                    }
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzba(locationRequest0, list0, s, z, z1, z2, s1, z3, z4, s2, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzba[v];
    }
}

