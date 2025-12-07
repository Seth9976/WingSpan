package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

public final class zzgp extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zzex;
    private final ParcelUuid zzge;
    private final ParcelUuid zzgf;
    private final ParcelUuid zzgg;
    private final byte[] zzgh;
    private final byte[] zzgi;
    private final int zzgj;
    private final byte[] zzgk;
    private final byte[] zzgl;

    static {
        zzgp.CREATOR = new zzgq();
    }

    zzgp(int v, ParcelUuid parcelUuid0, ParcelUuid parcelUuid1, ParcelUuid parcelUuid2, byte[] arr_b, byte[] arr_b1, int v1, byte[] arr_b2, byte[] arr_b3) {
        this.zzex = v;
        this.zzge = parcelUuid0;
        this.zzgf = parcelUuid1;
        this.zzgg = parcelUuid2;
        this.zzgh = arr_b;
        this.zzgi = arr_b1;
        this.zzgj = v1;
        this.zzgk = arr_b2;
        this.zzgl = arr_b3;
    }

    // 去混淆评级： 中等(80)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && this.getClass() == object0.getClass() && this.zzgj == ((zzgp)object0).zzgj && Arrays.equals(this.zzgk, ((zzgp)object0).zzgk) && Arrays.equals(this.zzgl, ((zzgp)object0).zzgl) && Objects.equal(this.zzgg, ((zzgp)object0).zzgg) && Arrays.equals(this.zzgh, ((zzgp)object0).zzgh) && Arrays.equals(this.zzgi, ((zzgp)object0).zzgi) && Objects.equal(this.zzge, ((zzgp)object0).zzge) && Objects.equal(this.zzgf, ((zzgp)object0).zzgf);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzgj, Arrays.hashCode(this.zzgk), Arrays.hashCode(this.zzgl), this.zzgg, Arrays.hashCode(this.zzgh), Arrays.hashCode(this.zzgi), this.zzge, this.zzgf});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zzex);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzge, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzgf, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.zzgg, v, false);
        SafeParcelWriter.writeByteArray(parcel0, 7, this.zzgh, false);
        SafeParcelWriter.writeByteArray(parcel0, 8, this.zzgi, false);
        SafeParcelWriter.writeInt(parcel0, 9, this.zzgj);
        SafeParcelWriter.writeByteArray(parcel0, 10, this.zzgk, false);
        SafeParcelWriter.writeByteArray(parcel0, 11, this.zzgl, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

