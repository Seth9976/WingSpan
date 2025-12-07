package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzep extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private String zzat;

    static {
        zzep.CREATOR = new zzeq();
    }

    private zzep() {
    }

    zzep(String s) {
        this.zzat = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzep ? Objects.equal(this.zzat, ((zzep)object0).zzat) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzat});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zzat, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final String zzg() {
        return this.zzat;
    }
}

