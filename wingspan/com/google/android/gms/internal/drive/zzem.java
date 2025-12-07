package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

public final class zzem extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int responseCode;
    private final List zzhb;

    static {
        zzem.CREATOR = new zzen();
    }

    public zzem(List list0, int v) {
        this.zzhb = list0;
        this.responseCode = v;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 2, this.zzhb, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.responseCode);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

