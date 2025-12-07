package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    final String value;
    final CustomPropertyKey zzje;

    static {
        zzc.CREATOR = new zzd();
    }

    public zzc(CustomPropertyKey customPropertyKey0, String s) {
        Preconditions.checkNotNull(customPropertyKey0, "key");
        this.zzje = customPropertyKey0;
        this.value = s;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && object0.getClass() == this.getClass() && Objects.equal(this.zzje, ((zzc)object0).zzje) && Objects.equal(this.value, ((zzc)object0).value);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzje, this.value});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzje, v, false);
        SafeParcelWriter.writeString(parcel0, 3, this.value, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

