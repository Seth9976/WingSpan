package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    boolean zza;
    long zzb;
    float zzc;
    long zzd;
    int zze;

    static {
        zzs.CREATOR = new zzt();
    }

    public zzs() {
        this(true, 50L, 0.0f, 0x7FFFFFFFFFFFFFFFL, 0x7FFFFFFF);
    }

    zzs(boolean z, long v, float f, long v1, int v2) {
        this.zza = z;
        this.zzb = v;
        this.zzc = f;
        this.zzd = v1;
        this.zze = v2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzs ? this.zza == ((zzs)object0).zza && this.zzb == ((zzs)object0).zzb && Float.compare(this.zzc, ((zzs)object0).zzc) == 0 && this.zzd == ((zzs)object0).zzd && this.zze == ((zzs)object0).zze : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.zza), this.zzb, this.zzc, this.zzd, this.zze});
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DeviceOrientationRequest[mShouldUseMag=");
        stringBuilder0.append(this.zza);
        stringBuilder0.append(" mMinimumSamplingPeriodMs=");
        stringBuilder0.append(this.zzb);
        stringBuilder0.append(" mSmallestAngleChangeRadians=");
        stringBuilder0.append(this.zzc);
        long v = this.zzd;
        if(v != 0x7FFFFFFFFFFFFFFFL) {
            long v1 = SystemClock.elapsedRealtime();
            stringBuilder0.append(" expireIn=");
            stringBuilder0.append(v - v1);
            stringBuilder0.append("ms");
        }
        if(this.zze != 0x7FFFFFFF) {
            stringBuilder0.append(" num=");
            stringBuilder0.append(this.zze);
        }
        stringBuilder0.append(']');
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 1, this.zza);
        SafeParcelWriter.writeLong(parcel0, 2, this.zzb);
        SafeParcelWriter.writeFloat(parcel0, 3, this.zzc);
        SafeParcelWriter.writeLong(parcel0, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel0, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

