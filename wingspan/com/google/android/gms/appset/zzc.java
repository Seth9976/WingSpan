package com.google.android.gms.appset;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String zza;
    private final int zzb;

    static {
        zzc.CREATOR = new zzd();
    }

    public zzc(String s, int v) {
        this.zza = s;
        this.zzb = v;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final int zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}

