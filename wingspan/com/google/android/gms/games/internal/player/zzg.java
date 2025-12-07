package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzg implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        Status status0 = null;
        String s = null;
        StockProfileImageEntity stockProfileImageEntity0 = null;
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int v1 = 0;
        boolean z5 = false;
        boolean z6 = false;
        int v2 = 0;
        int v3 = 0;
        boolean z7 = false;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 1: {
                    status0 = (Status)SafeParcelReader.createParcelable(parcel0, v4, Status.CREATOR);
                    break;
                }
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 3: {
                    z = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 4: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 5: {
                    z2 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 6: {
                    stockProfileImageEntity0 = (StockProfileImageEntity)SafeParcelReader.createParcelable(parcel0, v4, StockProfileImageEntity.CREATOR);
                    break;
                }
                case 7: {
                    z3 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 8: {
                    z4 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 9: {
                    v1 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 10: {
                    z5 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 11: {
                    z6 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 12: {
                    v2 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 13: {
                    v3 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 14: {
                    z7 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new ProfileSettingsEntity(status0, s, z, z1, z2, stockProfileImageEntity0, z3, z4, v1, z5, z6, v2, v3, z7);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new ProfileSettingsEntity[v];
    }
}

