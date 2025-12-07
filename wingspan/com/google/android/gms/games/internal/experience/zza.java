package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.GameEntity;

public final class zza implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        GameEntity gameEntity0 = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        Uri uri0 = null;
        long v1 = 0L;
        long v2 = 0L;
        long v3 = 0L;
        int v4 = 0;
        int v5 = 0;
        while(parcel0.dataPosition() < v) {
            int v6 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v6)) {
                case 1: {
                    s = SafeParcelReader.createString(parcel0, v6);
                    break;
                }
                case 2: {
                    gameEntity0 = (GameEntity)SafeParcelReader.createParcelable(parcel0, v6, GameEntity.CREATOR);
                    break;
                }
                case 3: {
                    s1 = SafeParcelReader.createString(parcel0, v6);
                    break;
                }
                case 4: {
                    s2 = SafeParcelReader.createString(parcel0, v6);
                    break;
                }
                case 5: {
                    s3 = SafeParcelReader.createString(parcel0, v6);
                    break;
                }
                case 6: {
                    uri0 = (Uri)SafeParcelReader.createParcelable(parcel0, v6, Uri.CREATOR);
                    break;
                }
                case 7: {
                    v1 = SafeParcelReader.readLong(parcel0, v6);
                    break;
                }
                case 8: {
                    v2 = SafeParcelReader.readLong(parcel0, v6);
                    break;
                }
                case 9: {
                    v3 = SafeParcelReader.readLong(parcel0, v6);
                    break;
                }
                case 10: {
                    v4 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                case 11: {
                    v5 = SafeParcelReader.readInt(parcel0, v6);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v6);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new ExperienceEventEntity(s, gameEntity0, s1, s2, s3, uri0, v1, v2, v3, v4, v5);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new ExperienceEventEntity[v];
    }
}

