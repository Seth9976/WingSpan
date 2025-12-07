package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

@Deprecated
public final class zzbj extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String zza;
    private final String zzb;
    private final String zzc;

    static {
        zzbj.CREATOR = new zzbk();
    }

    zzbj(String s, String s1, String s2) {
        this.zzc = s;
        this.zza = s1;
        this.zzb = s2;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel0, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel0, 5, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

