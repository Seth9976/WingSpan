package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzd implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        boolean z = false;
        int v2 = 0;
        String s = null;
        String s1 = null;
        String s2 = null;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 3: {
                    s1 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 4: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 5: {
                    v2 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 6: {
                    s2 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new ClientAppContext(v1, s, s1, z, v2, s2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new ClientAppContext[v];
    }
}

