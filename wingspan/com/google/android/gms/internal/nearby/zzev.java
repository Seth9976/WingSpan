package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzev extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private String zzat;
    private zzfh zzdk;
    private boolean zzdl;

    static {
        zzev.CREATOR = new zzew();
    }

    private zzev() {
    }

    zzev(String s, zzfh zzfh0, boolean z) {
        this.zzat = s;
        this.zzdk = zzfh0;
        this.zzdl = z;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzev && Objects.equal(this.zzat, ((zzev)object0).zzat) && Objects.equal(this.zzdk, ((zzev)object0).zzdk) && Objects.equal(Boolean.valueOf(this.zzdl), Boolean.valueOf(((zzev)object0).zzdl));
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzat, this.zzdk, Boolean.valueOf(this.zzdl)});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zzat, false);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzdk, v, false);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzdl);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final String zzg() {
        return this.zzat;
    }

    public final zzfh zzl() {
        return this.zzdk;
    }

    public final boolean zzm() {
        return this.zzdl;
    }
}

