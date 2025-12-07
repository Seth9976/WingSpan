package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzb implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String s1 = null;
        Uri uri0 = null;
        Uri uri1 = null;
        Uri uri2 = null;
        long v1 = 0L;
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
                    v1 = SafeParcelReader.readLong(parcel0, v2);
                    break;
                }
                case 4: {
                    uri0 = (Uri)SafeParcelReader.createParcelable(parcel0, v2, Uri.CREATOR);
                    break;
                }
                case 5: {
                    uri1 = (Uri)SafeParcelReader.createParcelable(parcel0, v2, Uri.CREATOR);
                    break;
                }
                case 6: {
                    uri2 = (Uri)SafeParcelReader.createParcelable(parcel0, v2, Uri.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new MostRecentGameInfoEntity(s, s1, v1, uri0, uri1, uri2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new MostRecentGameInfoEntity[v];
    }

    static void zza(MostRecentGameInfoEntity mostRecentGameInfoEntity0, Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, mostRecentGameInfoEntity0.zze(), false);
        SafeParcelWriter.writeString(parcel0, 2, mostRecentGameInfoEntity0.zzf(), false);
        SafeParcelWriter.writeLong(parcel0, 3, mostRecentGameInfoEntity0.zza());
        SafeParcelWriter.writeParcelable(parcel0, 4, mostRecentGameInfoEntity0.zzd(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 5, mostRecentGameInfoEntity0.zzc(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 6, mostRecentGameInfoEntity0.zzb(), v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

