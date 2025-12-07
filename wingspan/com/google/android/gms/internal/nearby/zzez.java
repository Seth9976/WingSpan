package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzez extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private int statusCode;
    private String zzcc;

    static {
        zzez.CREATOR = new zzfa();
    }

    private zzez() {
    }

    zzez(int v, String s) {
        this.statusCode = v;
        this.zzcc = s;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzez && Objects.equal(this.statusCode, ((zzez)object0).statusCode) && Objects.equal(this.zzcc, ((zzez)object0).zzcc);
    }

    public final String getLocalEndpointName() {
        return this.zzcc;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.statusCode, this.zzcc});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.statusCode);
        SafeParcelWriter.writeString(parcel0, 2, this.zzcc, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

