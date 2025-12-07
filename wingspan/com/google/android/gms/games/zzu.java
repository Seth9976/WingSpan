package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzu implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        long v1 = 0L;
        long v2 = 0L;
        PlayerLevel playerLevel0 = null;
        PlayerLevel playerLevel1 = null;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v1 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                case 2: {
                    v2 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                case 3: {
                    playerLevel0 = (PlayerLevel)SafeParcelReader.createParcelable(parcel0, v3, PlayerLevel.CREATOR);
                    break;
                }
                case 4: {
                    playerLevel1 = (PlayerLevel)SafeParcelReader.createParcelable(parcel0, v3, PlayerLevel.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new PlayerLevelInfo(v1, v2, playerLevel0, playerLevel1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new PlayerLevelInfo[v];
    }
}

