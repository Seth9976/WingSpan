package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.Player;
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
        Player player0 = null;
        String s4 = null;
        long v1 = 0L;
        boolean z = false;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 1: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 2: {
                    s1 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 3: {
                    s2 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 4: {
                    uri0 = (Uri)SafeParcelReader.createParcelable(parcel0, v2, Uri.CREATOR);
                    break;
                }
                case 5: {
                    s3 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 6: {
                    player0 = (PlayerEntity)SafeParcelReader.createParcelable(parcel0, v2, PlayerEntity.CREATOR);
                    break;
                }
                case 7: {
                    v1 = SafeParcelReader.readLong(parcel0, v2);
                    break;
                }
                case 8: {
                    s4 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 9: {
                    z = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new EventEntity(s, s1, s2, uri0, s3, player0, v1, s4, z);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new EventEntity[v];
    }
}

