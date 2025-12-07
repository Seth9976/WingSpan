package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.nearby.zzgs;
import com.google.android.gms.nearby.messages.Message;

public final class zzci implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        int v2 = 0;
        Message message0 = null;
        zze zze0 = null;
        zza zza0 = null;
        zzgs zzgs0 = null;
        byte[] arr_b = null;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 2: {
                    v2 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 3: {
                    message0 = (Message)SafeParcelReader.createParcelable(parcel0, v3, Message.CREATOR);
                    break;
                }
                case 4: {
                    zze0 = (zze)SafeParcelReader.createParcelable(parcel0, v3, zze.CREATOR);
                    break;
                }
                case 5: {
                    zza0 = (zza)SafeParcelReader.createParcelable(parcel0, v3, zza.CREATOR);
                    break;
                }
                case 6: {
                    zzgs0 = (zzgs)SafeParcelReader.createParcelable(parcel0, v3, zzgs.CREATOR);
                    break;
                }
                case 7: {
                    arr_b = SafeParcelReader.createByteArray(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new Update(v1, v2, message0, zze0, zza0, zzgs0, arr_b);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new Update[v];
    }
}

