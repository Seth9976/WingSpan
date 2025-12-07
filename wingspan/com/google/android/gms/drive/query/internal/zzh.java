package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzh implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        zzb zzb0 = null;
        zzd zzd0 = null;
        zzr zzr0 = null;
        zzv zzv0 = null;
        zzp zzp0 = null;
        zzt zzt0 = null;
        zzn zzn0 = null;
        zzl zzl0 = null;
        zzz zzz0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    zzb0 = (zzb)SafeParcelReader.createParcelable(parcel0, v1, zzb.CREATOR);
                    break;
                }
                case 2: {
                    zzd0 = (zzd)SafeParcelReader.createParcelable(parcel0, v1, zzd.CREATOR);
                    break;
                }
                case 3: {
                    zzr0 = (zzr)SafeParcelReader.createParcelable(parcel0, v1, zzr.CREATOR);
                    break;
                }
                case 4: {
                    zzv0 = (zzv)SafeParcelReader.createParcelable(parcel0, v1, zzv.CREATOR);
                    break;
                }
                case 5: {
                    zzp0 = (zzp)SafeParcelReader.createParcelable(parcel0, v1, zzp.CREATOR);
                    break;
                }
                case 6: {
                    zzt0 = (zzt)SafeParcelReader.createParcelable(parcel0, v1, zzt.CREATOR);
                    break;
                }
                case 7: {
                    zzn0 = (zzn)SafeParcelReader.createParcelable(parcel0, v1, zzn.CREATOR);
                    break;
                }
                case 8: {
                    zzl0 = (zzl)SafeParcelReader.createParcelable(parcel0, v1, zzl.CREATOR);
                    break;
                }
                case 9: {
                    zzz0 = (zzz)SafeParcelReader.createParcelable(parcel0, v1, zzz.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new FilterHolder(zzb0, zzd0, zzr0, zzv0, zzp0, zzt0, zzn0, zzl0, zzz0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new FilterHolder[v];
    }
}

