package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class zzs implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public Object createFromParcel(Parcel parcel0) {
        return this.zza(parcel0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new PlayerEntity[v];
    }

    public PlayerEntity zza(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String s1 = null;
        Uri uri0 = null;
        Uri uri1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity0 = null;
        PlayerLevelInfo playerLevelInfo0 = null;
        String s5 = null;
        String s6 = null;
        Uri uri2 = null;
        String s7 = null;
        Uri uri3 = null;
        String s8 = null;
        zzv zzv0 = null;
        zza zza0 = null;
        String s9 = null;
        long v1 = 0L;
        long v2 = 0L;
        int v3 = 0;
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        long v4 = -1L;
        while(parcel0.dataPosition() < v) {
            int v5 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v5)) {
                case 1: {
                    s = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 2: {
                    s1 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 3: {
                    uri0 = (Uri)SafeParcelReader.createParcelable(parcel0, v5, Uri.CREATOR);
                    break;
                }
                case 4: {
                    uri1 = (Uri)SafeParcelReader.createParcelable(parcel0, v5, Uri.CREATOR);
                    break;
                }
                case 5: {
                    v1 = SafeParcelReader.readLong(parcel0, v5);
                    break;
                }
                case 6: {
                    v3 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 7: {
                    v2 = SafeParcelReader.readLong(parcel0, v5);
                    break;
                }
                case 8: {
                    s2 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 9: {
                    s3 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 14: {
                    s4 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 15: {
                    mostRecentGameInfoEntity0 = (MostRecentGameInfoEntity)SafeParcelReader.createParcelable(parcel0, v5, MostRecentGameInfoEntity.CREATOR);
                    break;
                }
                case 16: {
                    playerLevelInfo0 = (PlayerLevelInfo)SafeParcelReader.createParcelable(parcel0, v5, PlayerLevelInfo.CREATOR);
                    break;
                }
                case 18: {
                    z = SafeParcelReader.readBoolean(parcel0, v5);
                    break;
                }
                case 19: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v5);
                    break;
                }
                case 20: {
                    s5 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 21: {
                    s6 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 22: {
                    uri2 = (Uri)SafeParcelReader.createParcelable(parcel0, v5, Uri.CREATOR);
                    break;
                }
                case 23: {
                    s7 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 24: {
                    uri3 = (Uri)SafeParcelReader.createParcelable(parcel0, v5, Uri.CREATOR);
                    break;
                }
                case 25: {
                    s8 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 29: {
                    v4 = SafeParcelReader.readLong(parcel0, v5);
                    break;
                }
                case 33: {
                    zzv0 = (zzv)SafeParcelReader.createParcelable(parcel0, v5, zzv.CREATOR);
                    break;
                }
                case 35: {
                    zza0 = (zza)SafeParcelReader.createParcelable(parcel0, v5, zza.CREATOR);
                    break;
                }
                case 36: {
                    z2 = SafeParcelReader.readBoolean(parcel0, v5);
                    break;
                }
                case 37: {
                    s9 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v5);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new PlayerEntity(s, s1, uri0, uri1, v1, v3, v2, s2, s3, s4, mostRecentGameInfoEntity0, playerLevelInfo0, z, z1, s5, s6, uri2, s7, uri3, s8, v4, zzv0, zza0, z2, s9);
    }
}

