package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzs implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String s1 = null;
        String s2 = null;
        int v1 = 0;
        int v2 = 0;
        boolean z = false;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 3: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 4: {
                    s1 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 5: {
                    s2 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 6: {
                    v2 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 7: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzr(s, v1, s1, s2, v2, z);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzr[v];
    }
}

