package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

public final class zzgz extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final List zziu;

    static {
        zzgz.CREATOR = new zzha();
    }

    public zzgz(List list0) {
        this.zziu = list0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeStringList(parcel0, 2, this.zziu, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

