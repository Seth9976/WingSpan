package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

public final class zzex extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private String zzat;
    private PayloadTransferUpdate zzdm;

    static {
        zzex.CREATOR = new zzey();
    }

    private zzex() {
    }

    zzex(String s, PayloadTransferUpdate payloadTransferUpdate0) {
        this.zzat = s;
        this.zzdm = payloadTransferUpdate0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzex && Objects.equal(this.zzat, ((zzex)object0).zzat) && Objects.equal(this.zzdm, ((zzex)object0).zzdm);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzat, this.zzdm});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zzat, false);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzdm, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final String zzg() {
        return this.zzat;
    }

    public final PayloadTransferUpdate zzn() {
        return this.zzdm;
    }
}

