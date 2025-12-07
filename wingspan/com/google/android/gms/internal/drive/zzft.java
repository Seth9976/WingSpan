package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.zzu;

public final class zzft extends zzu {
    public static final Parcelable.Creator CREATOR;
    final boolean zzea;
    final DataHolder zzii;

    static {
        zzft.CREATOR = new zzfu();
    }

    public zzft(DataHolder dataHolder0, boolean z) {
        this.zzii = dataHolder0;
        this.zzea = z;
    }

    @Override  // com.google.android.gms.drive.zzu
    protected final void zza(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzii, v, false);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzea);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final DataHolder zzau() {
        return this.zzii;
    }
}

