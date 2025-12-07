package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.Contents;

public final class zzfh extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    final Contents zzes;
    final boolean zzhv;

    static {
        zzfh.CREATOR = new zzfi();
    }

    public zzfh(Contents contents0, boolean z) {
        this.zzes = contents0;
        this.zzhv = z;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzes, v, false);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzhv);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final Contents zzar() {
        return this.zzes;
    }
}

