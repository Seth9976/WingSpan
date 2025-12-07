package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzbx extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;

    static {
        zzbx.CREATOR = new zzby();
    }

    public zzbx(int v, int v1, int v2, int v3) {
        boolean z = true;
        Preconditions.checkState(v >= 0 && v <= 23, "Start hour must be in range [0, 23].");
        Preconditions.checkState(v1 >= 0 && v1 <= 59, "Start minute must be in range [0, 59].");
        Preconditions.checkState(v2 >= 0 && v2 <= 23, "End hour must be in range [0, 23].");
        Preconditions.checkState(v3 >= 0 && v3 <= 59, "End minute must be in range [0, 59].");
        if(v + v1 + v2 + v3 <= 0) {
            z = false;
        }
        Preconditions.checkState(z, "Parameters can\'t be all 0.");
        this.zza = v;
        this.zzb = v1;
        this.zzc = v2;
        this.zzd = v3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzbx ? this.zza == ((zzbx)object0).zza && this.zzb == ((zzbx)object0).zzb && this.zzc == ((zzbx)object0).zzc && this.zzd == ((zzbx)object0).zzd : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd});
    }

    @Override
    public final String toString() {
        return "UserPreferredSleepWindow [startHour=" + this.zza + ", startMinute=" + this.zzb + ", endHour=" + this.zzc + ", endMinute=" + this.zzd + ']';
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        Preconditions.checkNotNull(parcel0);
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

