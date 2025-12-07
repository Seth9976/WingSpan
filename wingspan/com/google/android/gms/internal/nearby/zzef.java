package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzef extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private int quality;
    private String zzat;

    static {
        zzef.CREATOR = new zzeg();
    }

    private zzef() {
    }

    zzef(String s, int v) {
        this.zzat = s;
        this.quality = v;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzef && Objects.equal(this.zzat, ((zzef)object0).zzat) && Objects.equal(this.quality, ((zzef)object0).quality);
    }

    public final int getQuality() {
        return this.quality;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzat, this.quality});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zzat, false);
        SafeParcelWriter.writeInt(parcel0, 2, this.quality);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final String zzg() {
        return this.zzat;
    }
}

