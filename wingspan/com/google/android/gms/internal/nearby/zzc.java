package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class zzc {
    private static final ClassLoader zzd;

    static {
        zzc.zzd = zzc.class.getClassLoader();
    }

    public static Parcelable zza(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
        return parcel0.readInt() == 0 ? null : ((Parcelable)parcelable$Creator0.createFromParcel(parcel0));
    }

    public static void zza(Parcel parcel0, Parcelable parcelable0) {
        if(parcelable0 == null) {
            parcel0.writeInt(0);
            return;
        }
        parcel0.writeInt(1);
        parcelable0.writeToParcel(parcel0, 0);
    }

    public static void zza(Parcel parcel0, boolean z) {
        parcel0.writeInt(((int)z));
    }

    public static boolean zza(Parcel parcel0) {
        return parcel0.readInt() != 0;
    }
}

