package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzfr extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final ParcelFileDescriptor zzih;

    static {
        zzfr.CREATOR = new zzfs();
    }

    public zzfr(ParcelFileDescriptor parcelFileDescriptor0) {
        this.zzih = parcelFileDescriptor0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzih, v | 1, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

