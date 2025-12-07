package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int versionCode;
    @Deprecated
    private final ClientAppContext zzhi;
    private final int zzhj;

    static {
        zzj.CREATOR = new zzk();
    }

    public zzj(int v) {
        this(1, null, v);
    }

    zzj(int v, ClientAppContext clientAppContext0, int v1) {
        this.versionCode = v;
        this.zzhi = clientAppContext0;
        this.zzhj = v1;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.versionCode);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzhi, v, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzhj);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

