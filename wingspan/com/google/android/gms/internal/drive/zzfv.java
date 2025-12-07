package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.zzu;

public final class zzfv extends zzu {
    public static final Parcelable.Creator CREATOR;
    final DataHolder zzij;

    static {
        zzfv.CREATOR = new zzfw();
    }

    public zzfv(DataHolder dataHolder0) {
        this.zzij = dataHolder0;
    }

    @Override  // com.google.android.gms.drive.zzu
    protected final void zza(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzij, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final DataHolder zzav() {
        return this.zzij;
    }
}

