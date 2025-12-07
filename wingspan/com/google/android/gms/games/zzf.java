package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class zzf implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public Object createFromParcel(Parcel parcel0) {
        return this.zza(parcel0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new GameEntity[v];
    }

    public GameEntity zza(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        Uri uri0 = null;
        Uri uri1 = null;
        Uri uri2 = null;
        String s6 = null;
        String s7 = null;
        String s8 = null;
        String s9 = null;
        String s10 = null;
        boolean z = false;
        boolean z1 = false;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 1: {
                    s = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 2: {
                    s1 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 3: {
                    s2 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 4: {
                    s3 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 5: {
                    s4 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 6: {
                    s5 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 7: {
                    uri0 = (Uri)SafeParcelReader.createParcelable(parcel0, v4, Uri.CREATOR);
                    break;
                }
                case 8: {
                    uri1 = (Uri)SafeParcelReader.createParcelable(parcel0, v4, Uri.CREATOR);
                    break;
                }
                case 9: {
                    uri2 = (Uri)SafeParcelReader.createParcelable(parcel0, v4, Uri.CREATOR);
                    break;
                }
                case 10: {
                    z = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 11: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 12: {
                    s6 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 13: {
                    v1 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 14: {
                    v2 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 15: {
                    v3 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 16: {
                    z2 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 17: {
                    z3 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 18: {
                    s7 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 19: {
                    s8 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 20: {
                    s9 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 21: {
                    z4 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 22: {
                    z5 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 23: {
                    z6 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                case 24: {
                    s10 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 25: {
                    z7 = SafeParcelReader.readBoolean(parcel0, v4);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new GameEntity(s, s1, s2, s3, s4, s5, uri0, uri1, uri2, z, z1, s6, v1, v2, v3, z2, z3, s7, s8, s9, z4, z5, z6, s10, z7);
    }
}

