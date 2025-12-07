package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

public final class zzeh extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private String zzat;
    private byte[] zzau;
    private String zzdj;
    private String zzr;
    private boolean zzs;

    static {
        zzeh.CREATOR = new zzei();
    }

    private zzeh() {
    }

    zzeh(String s, String s1, String s2, boolean z, byte[] arr_b) {
        this.zzat = s;
        this.zzdj = s1;
        this.zzr = s2;
        this.zzs = z;
        this.zzau = arr_b;
    }

    // 去混淆评级： 中等(70)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzeh && Objects.equal(this.zzat, ((zzeh)object0).zzat) && Objects.equal(this.zzdj, ((zzeh)object0).zzdj) && Objects.equal(this.zzr, ((zzeh)object0).zzr) && Objects.equal(Boolean.valueOf(this.zzs), Boolean.valueOf(((zzeh)object0).zzs)) && Arrays.equals(this.zzau, ((zzeh)object0).zzau);
    }

    public final String getAuthenticationToken() {
        return this.zzr;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzat, this.zzdj, this.zzr, Boolean.valueOf(this.zzs), Arrays.hashCode(this.zzau)});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zzat, false);
        SafeParcelWriter.writeString(parcel0, 2, this.zzdj, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzr, false);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzs);
        SafeParcelWriter.writeByteArray(parcel0, 5, this.zzau, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final String zzg() {
        return this.zzat;
    }

    public final String zzh() {
        return this.zzdj;
    }

    public final boolean zzi() {
        return this.zzs;
    }
}

