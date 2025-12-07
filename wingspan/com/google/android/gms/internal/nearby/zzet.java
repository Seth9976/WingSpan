package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzet extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private String zzca;

    static {
        zzet.CREATOR = new zzeu();
    }

    private zzet() {
    }

    zzet(String s) {
        this.zzca = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzet ? Objects.equal(this.zzca, ((zzet)object0).zzca) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzca});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zzca, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final String zze() {
        return this.zzca;
    }
}

