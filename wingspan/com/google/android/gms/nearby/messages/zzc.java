package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.nearby.zzgp;
import com.google.android.gms.internal.nearby.zzgu;
import com.google.android.gms.nearby.messages.internal.zzad;
import java.util.List;

public final class zzc implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        boolean z = false;
        int v2 = 0;
        List list0 = null;
        List list1 = null;
        List list2 = null;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 1: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v3, zzad.CREATOR);
                    break;
                }
                case 2: {
                    list1 = SafeParcelReader.createTypedList(parcel0, v3, zzgu.CREATOR);
                    break;
                }
                case 3: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 4: {
                    list2 = SafeParcelReader.createTypedList(parcel0, v3, zzgp.CREATOR);
                    break;
                }
                case 5: {
                    v2 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 1000: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new MessageFilter(v1, list0, list1, z, list2, v2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new MessageFilter[v];
    }
}

