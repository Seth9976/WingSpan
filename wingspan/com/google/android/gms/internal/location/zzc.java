package com.google.android.gms.internal.location;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public final class zzc {
    private static final ClassLoader zza;

    static {
        zzc.zza = zzc.class.getClassLoader();
    }

    public static void zza(Parcel parcel0, boolean z) {
        parcel0.writeInt(((int)z));
    }

    public static Parcelable zzb(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
        return parcel0.readInt() == 0 ? null : ((Parcelable)parcelable$Creator0.createFromParcel(parcel0));
    }

    public static void zzc(Parcel parcel0, Parcelable parcelable0) {
        if(parcelable0 == null) {
            parcel0.writeInt(0);
            return;
        }
        parcel0.writeInt(1);
        parcelable0.writeToParcel(parcel0, 0);
    }

    public static void zzd(Parcel parcel0, IInterface iInterface0) {
        if(iInterface0 == null) {
            parcel0.writeStrongBinder(null);
            return;
        }
        parcel0.writeStrongBinder(iInterface0.asBinder());
    }
}

