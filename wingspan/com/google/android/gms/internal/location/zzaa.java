package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzaa extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator CREATOR;
    public static final zzaa zza;
    private final Status zzb;

    static {
        zzaa.zza = new zzaa(Status.RESULT_SUCCESS);
        zzaa.CREATOR = new zzab();
    }

    public zzaa(Status status0) {
        this.zzb = status0;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzb;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzb, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

