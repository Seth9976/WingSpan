package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zzct;

    static {
        zzt.CREATOR = new zzu();
    }

    public zzt(int v) {
        this.zzct = v;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzct);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

