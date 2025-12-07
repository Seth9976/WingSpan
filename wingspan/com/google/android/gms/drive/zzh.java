package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final long zzab;
    private final long zzac;

    static {
        zzh.CREATOR = new zzi();
    }

    public zzh(long v, long v1) {
        this.zzab = v;
        this.zzac = v1;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 2, this.zzab);
        SafeParcelWriter.writeLong(parcel0, 3, this.zzac);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

