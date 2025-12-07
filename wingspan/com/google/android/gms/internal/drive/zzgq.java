package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.query.Query;

public final class zzgq extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final Query zzir;

    static {
        zzgq.CREATOR = new zzgr();
    }

    public zzgq(Query query0) {
        this.zzir = query0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzir, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

