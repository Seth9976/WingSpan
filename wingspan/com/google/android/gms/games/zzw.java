package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzw implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        String s = null;
        String s1 = null;
        String s2 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 3: {
                    s1 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 4: {
                    s2 = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzv(v1, s, s1, s2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzv[v];
    }

    static void zza(zzv zzv0, Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, zzv0.getFriendStatus());
        SafeParcelWriter.writeString(parcel0, 2, zzv0.zzb(), false);
        SafeParcelWriter.writeString(parcel0, 3, zzv0.zza(), false);
        SafeParcelWriter.writeString(parcel0, 4, zzv0.zzc(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

