package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.TransferPreferences;

public final class zzga extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final zzgo zzil;

    static {
        zzga.CREATOR = new zzgb();
    }

    zzga(zzgo zzgo0) {
        this.zzil = zzgo0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzil, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final TransferPreferences zzax() {
        return this.zzil;
    }
}

