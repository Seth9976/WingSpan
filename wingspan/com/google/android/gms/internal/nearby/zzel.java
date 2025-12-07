package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

public final class zzel extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private int statusCode;
    private String zzat;
    private byte[] zzau;

    static {
        zzel.CREATOR = new zzem();
    }

    private zzel() {
    }

    zzel(String s, int v, byte[] arr_b) {
        this.zzat = s;
        this.statusCode = v;
        this.zzau = arr_b;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzel && Objects.equal(this.zzat, ((zzel)object0).zzat) && Objects.equal(this.statusCode, ((zzel)object0).statusCode) && Arrays.equals(this.zzau, ((zzel)object0).zzau);
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzat, this.statusCode, Arrays.hashCode(this.zzau)});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zzat, false);
        SafeParcelWriter.writeInt(parcel0, 2, this.statusCode);
        SafeParcelWriter.writeByteArray(parcel0, 3, this.zzau, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final String zzg() {
        return this.zzat;
    }

    public final byte[] zzj() {
        return this.zzau;
    }
}

