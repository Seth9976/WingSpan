package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzfx extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final boolean zzik;

    static {
        zzfx.CREATOR = new zzgc();
    }

    public zzfx(boolean z) {
        this.zzik = z;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zzik);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

