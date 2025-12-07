package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.zzs;
import java.util.Collections;
import java.util.List;

public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    static final List zza;
    static final zzs zzb;
    final zzs zzc;
    final List zzd;
    final String zze;

    static {
        zzj.zza = Collections.emptyList();
        zzj.zzb = new zzs();
        zzj.CREATOR = new zzk();
    }

    zzj(zzs zzs0, List list0, String s) {
        this.zzc = zzs0;
        this.zzd = list0;
        this.zze = s;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzj ? Objects.equal(this.zzc, ((zzj)object0).zzc) && Objects.equal(this.zzd, ((zzj)object0).zzd) && Objects.equal(this.zze, ((zzj)object0).zze) : false;
    }

    @Override
    public final int hashCode() {
        return this.zzc.hashCode();
    }

    @Override
    public final String toString() {
        return "DeviceOrientationRequestInternal{deviceOrientationRequest=" + this.zzc + ", clients=" + this.zzd + ", tag=\'" + this.zze + "\'}";
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzc, v, false);
        SafeParcelWriter.writeTypedList(parcel0, 2, this.zzd, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

