package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;

public final class zzd implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        GameEntity gameEntity0 = null;
        PlayerEntity playerEntity0 = null;
        String s = null;
        Uri uri0 = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        long v1 = 0L;
        long v2 = 0L;
        long v3 = 0L;
        float f = 0.0f;
        boolean z = false;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 1: {
                    gameEntity0 = (GameEntity)SafeParcelReader.createParcelable(parcel0, v4, GameEntity.CREATOR);
                    break;
                }
                case 2: {
                    playerEntity0 = (PlayerEntity)SafeParcelReader.createParcelable(parcel0, v4, PlayerEntity.CREATOR);
                    break;
                }
                case 3: {
                    s = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 5: {
                    uri0 = (Uri)SafeParcelReader.createParcelable(parcel0, v4, Uri.CREATOR);
                    break;
                }
                case 6: {
                    s1 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 7: {
                    s2 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 8: {
                    s3 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 9: {
                    v1 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 10: {
                    v2 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 11: {
                    f = SafeParcelReader.readFloat(parcel0, v4);
                    break;
                }
                case 12: {
                    s4 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 13: {
                    z = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 14: {
                    v3 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 15: {
                    s5 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new SnapshotMetadataEntity(gameEntity0, playerEntity0, s, uri0, s1, s2, s3, v1, v2, f, s4, z, v3, s5);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SnapshotMetadataEntity[v];
    }
}

