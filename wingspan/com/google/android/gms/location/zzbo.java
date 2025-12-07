package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzbo extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final int zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;

    static {
        zzbo.CREATOR = new zzbp();
    }

    zzbo(int v, int v1, long v2, long v3) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = v2;
        this.zzd = v3;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzbo && this.zza == ((zzbo)object0).zza && this.zzb == ((zzbo)object0).zzb && this.zzc == ((zzbo)object0).zzc && this.zzd == ((zzbo)object0).zzd;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, this.zza, this.zzd, this.zzc});
    }

    @Override
    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.zza + " Cell status: " + this.zzb + " elapsed time NS: " + this.zzd + " system time ms: " + this.zzc;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel0, 3, this.zzc);
        SafeParcelWriter.writeLong(parcel0, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

