package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.zzs;
import java.util.List;

public final class zzk implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        zzs zzs0 = zzj.zzb;
        List list0 = zzj.zza;
        String s = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    zzs0 = (zzs)SafeParcelReader.createParcelable(parcel0, v1, zzs.CREATOR);
                    break;
                }
                case 2: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v1, ClientIdentity.CREATOR);
                    break;
                }
                case 3: {
                    s = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzj(zzs0, list0, s);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzj[v];
    }
}

