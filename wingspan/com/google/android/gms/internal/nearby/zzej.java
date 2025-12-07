package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

public final class zzej extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private String zzat;
    private byte[] zzau;
    private String zzdj;

    static {
        zzej.CREATOR = new zzek();
    }

    private zzej() {
    }

    zzej(String s, String s1, byte[] arr_b) {
        this.zzat = s;
        this.zzdj = s1;
        this.zzau = arr_b;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzej && Objects.equal(this.zzat, ((zzej)object0).zzat) && Objects.equal(this.zzdj, ((zzej)object0).zzdj) && Arrays.equals(this.zzau, ((zzej)object0).zzau);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzat, this.zzdj, Arrays.hashCode(this.zzau)});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zzat, false);
        SafeParcelWriter.writeString(parcel0, 2, this.zzdj, false);
        SafeParcelWriter.writeByteArray(parcel0, 3, this.zzau, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final String zzg() {
        return this.zzat;
    }

    public final String zzh() {
        return this.zzdj;
    }

    public final byte[] zzj() {
        return this.zzau;
    }
}

