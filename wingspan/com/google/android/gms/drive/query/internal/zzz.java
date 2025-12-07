package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzz extends zza {
    public static final Parcelable.Creator CREATOR;

    static {
        zzz.CREATOR = new zzaa();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        SafeParcelWriter.finishObjectHeader(parcel0, SafeParcelWriter.beginObjectHeader(parcel0));
    }

    @Override  // com.google.android.gms.drive.query.Filter
    public final Object zza(zzj zzj0) {
        return zzj0.zzbj();
    }
}

