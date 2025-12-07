package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzgh extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final boolean zzea;

    static {
        zzgh.CREATOR = new zzgi();
    }

    public zzgh(boolean z) {
        this.zzea = z;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zzea);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

