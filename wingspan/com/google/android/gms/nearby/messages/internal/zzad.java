package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String namespace;
    private final String type;
    private final int versionCode;

    static {
        zzad.CREATOR = new zzae();
    }

    zzad(int v, String s, String s1) {
        this.versionCode = v;
        this.namespace = s;
        this.type = s1;
    }

    public zzad(String s, String s1) {
        this(1, s, s1);
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzad && this.hashCode() == object0.hashCode() && Objects.equal(this.namespace, ((zzad)object0).namespace) && Objects.equal(this.type, ((zzad)object0).type);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.namespace, this.type});
    }

    @Override
    public final String toString() {
        return "namespace=" + this.namespace + ", type=" + this.type;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.namespace, false);
        SafeParcelWriter.writeString(parcel0, 2, this.type, false);
        SafeParcelWriter.writeInt(parcel0, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

