package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzbr implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = "";
        List list0 = null;
        PendingIntent pendingIntent0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    list0 = SafeParcelReader.createStringList(parcel0, v1);
                    break;
                }
                case 2: {
                    pendingIntent0 = (PendingIntent)SafeParcelReader.createParcelable(parcel0, v1, PendingIntent.CREATOR);
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
        return new zzbq(list0, pendingIntent0, s);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzbq[v];
    }
}

