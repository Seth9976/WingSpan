package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzgu extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final zzei zzhw;

    static {
        zzgu.CREATOR = new zzgv();
    }

    public zzgu(zzei zzei0) {
        this.zzhw = zzei0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzhw, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

