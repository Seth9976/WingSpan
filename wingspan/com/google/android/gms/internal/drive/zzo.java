package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.Contents;

public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final Contents zzdf;
    private final int zzdh;
    private final Boolean zzdj;

    static {
        zzo.CREATOR = new zzp();
    }

    public zzo(int v, boolean z) {
        this(null, Boolean.FALSE, v);
    }

    public zzo(Contents contents0, Boolean boolean0, int v) {
        this.zzdf = contents0;
        this.zzdj = boolean0;
        this.zzdh = v;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzdf, v, false);
        SafeParcelWriter.writeBooleanObject(parcel0, 3, this.zzdj, false);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzdh);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

