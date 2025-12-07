package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.query.Filter;

public final class zzv extends zza {
    public static final Parcelable.Creator CREATOR;
    private final FilterHolder zzmp;

    static {
        zzv.CREATOR = new zzw();
    }

    public zzv(Filter filter0) {
        this(new FilterHolder(filter0));
    }

    zzv(FilterHolder filterHolder0) {
        this.zzmp = filterHolder0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzmp, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.drive.query.Filter
    public final Object zza(zzj zzj0) {
        return zzj0.zza(this.zzmp.getFilter().zza(zzj0));
    }
}

