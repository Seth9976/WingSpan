package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.Distance;
import java.util.Locale;

public final class zze extends AbstractSafeParcelable implements Distance {
    public static final Parcelable.Creator CREATOR;
    private final int accuracy;
    private final int versionCode;
    private final double zzhg;

    static {
        zze.CREATOR = new zzf();
    }

    public zze(int v, double f) {
        this(1, 1, NaN);
    }

    zze(int v, int v1, double f) {
        this.versionCode = v;
        this.accuracy = v1;
        this.zzhg = f;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.nearby.messages.Distance
    public final int compareTo(Distance distance0) {
        return !Double.isNaN(this.getMeters()) || !Double.isNaN(distance0.getMeters()) ? Double.compare(this.getMeters(), distance0.getMeters()) : 0;
    }

    @Override
    public final int compareTo(Object object0) {
        return this.compareTo(((Distance)object0));
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zze ? this.getAccuracy() == ((zze)object0).getAccuracy() && this.compareTo(((zze)object0)) == 0 : false;
    }

    @Override  // com.google.android.gms.nearby.messages.Distance
    public final int getAccuracy() {
        return this.accuracy;
    }

    @Override  // com.google.android.gms.nearby.messages.Distance
    public final double getMeters() {
        return this.zzhg;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.getAccuracy(), this.getMeters()});
    }

    @Override
    public final String toString() {
        return String.format(Locale.US, "(%.1fm, %s)", this.zzhg, (this.accuracy == 1 ? "LOW" : "UNKNOWN"));
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel0, 2, this.accuracy);
        SafeParcelWriter.writeDouble(parcel0, 3, this.zzhg);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

