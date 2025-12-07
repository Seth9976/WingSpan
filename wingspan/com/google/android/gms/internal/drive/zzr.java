package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int mode;

    static {
        zzr.CREATOR = new zzs();
    }

    public zzr(int v) {
        Preconditions.checkArgument(v == 0x20000000 || v == 0x30000000, "Cannot create a new read-only contents!");
        this.mode = v;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.mode);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

