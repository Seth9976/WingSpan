package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.PlayerEntity;

public final class zza implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String s1 = null;
        String s2 = null;
        Uri uri0 = null;
        String s3 = null;
        Uri uri1 = null;
        String s4 = null;
        String s5 = null;
        PlayerEntity playerEntity0 = null;
        String s6 = null;
        String s7 = null;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        long v5 = 0L;
        long v6 = 0L;
        float f = -1.0f;
        while(parcel0.dataPosition() < v) {
            int v7 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v7)) {
                case 1: {
                    s = SafeParcelReader.createString(parcel0, v7);
                    break;
                }
                case 2: {
                    v1 = SafeParcelReader.readInt(parcel0, v7);
                    break;
                }
                case 3: {
                    s1 = SafeParcelReader.createString(parcel0, v7);
                    break;
                }
                case 4: {
                    s2 = SafeParcelReader.createString(parcel0, v7);
                    break;
                }
                case 5: {
                    uri0 = (Uri)SafeParcelReader.createParcelable(parcel0, v7, Uri.CREATOR);
                    break;
                }
                case 6: {
                    s3 = SafeParcelReader.createString(parcel0, v7);
                    break;
                }
                case 7: {
                    uri1 = (Uri)SafeParcelReader.createParcelable(parcel0, v7, Uri.CREATOR);
                    break;
                }
                case 8: {
                    s4 = SafeParcelReader.createString(parcel0, v7);
                    break;
                }
                case 9: {
                    v2 = SafeParcelReader.readInt(parcel0, v7);
                    break;
                }
                case 10: {
                    s5 = SafeParcelReader.createString(parcel0, v7);
                    break;
                }
                case 11: {
                    playerEntity0 = (PlayerEntity)SafeParcelReader.createParcelable(parcel0, v7, PlayerEntity.CREATOR);
                    break;
                }
                case 12: {
                    v3 = SafeParcelReader.readInt(parcel0, v7);
                    break;
                }
                case 13: {
                    v4 = SafeParcelReader.readInt(parcel0, v7);
                    break;
                }
                case 14: {
                    s6 = SafeParcelReader.createString(parcel0, v7);
                    break;
                }
                case 15: {
                    v5 = SafeParcelReader.readLong(parcel0, v7);
                    break;
                }
                case 16: {
                    v6 = SafeParcelReader.readLong(parcel0, v7);
                    break;
                }
                case 17: {
                    f = SafeParcelReader.readFloat(parcel0, v7);
                    break;
                }
                case 18: {
                    s7 = SafeParcelReader.createString(parcel0, v7);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v7);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new AchievementEntity(s, v1, s1, s2, uri0, s3, uri1, s4, v2, s5, playerEntity0, v3, v4, s6, v5, v6, f, s7);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new AchievementEntity[v];
    }
}

