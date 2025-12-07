package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzfd extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private int zzdn;

    static {
        zzfd.CREATOR = new zzfe();
    }

    private zzfd() {
    }

    zzfd(int v) {
        this.zzdn = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzfd ? Objects.equal(this.zzdn, ((zzfd)object0).zzdn) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzdn});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zzdn);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

