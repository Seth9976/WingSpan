package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzl extends zza {
    public static final Parcelable.Creator CREATOR;
    private final String value;

    static {
        zzl.CREATOR = new zzm();
    }

    public zzl(String s) {
        this.value = s;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.value, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.drive.query.Filter
    public final Object zza(zzj zzj0) {
        return zzj0.zzi(this.value);
    }
}

