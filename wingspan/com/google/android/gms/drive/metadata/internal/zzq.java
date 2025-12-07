package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    final String zzad;
    final long zzae;
    final int zzaf;

    static {
        zzq.CREATOR = new zzr();
    }

    public zzq(String s, long v, int v1) {
        this.zzad = s;
        this.zzae = v;
        this.zzaf = v1;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.zzad, false);
        SafeParcelWriter.writeLong(parcel0, 3, this.zzae);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzaf);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

