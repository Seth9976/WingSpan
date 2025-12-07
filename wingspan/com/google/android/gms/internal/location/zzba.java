package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public final class zzba extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    static final List zza;
    final LocationRequest zzb;
    final List zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final String zzh;
    final boolean zzi;
    boolean zzj;
    String zzk;
    long zzl;

    static {
        zzba.zza = Collections.emptyList();
        zzba.CREATOR = new zzbb();
    }

    zzba(LocationRequest locationRequest0, List list0, String s, boolean z, boolean z1, boolean z2, String s1, boolean z3, boolean z4, String s2, long v) {
        this.zzb = locationRequest0;
        this.zzc = list0;
        this.zzd = s;
        this.zze = z;
        this.zzf = z1;
        this.zzg = z2;
        this.zzh = s1;
        this.zzi = z3;
        this.zzj = z4;
        this.zzk = s2;
        this.zzl = v;
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzba && Objects.equal(this.zzb, ((zzba)object0).zzb) && Objects.equal(this.zzc, ((zzba)object0).zzc) && Objects.equal(this.zzd, ((zzba)object0).zzd) && this.zze == ((zzba)object0).zze && this.zzf == ((zzba)object0).zzf && this.zzg == ((zzba)object0).zzg && Objects.equal(this.zzh, ((zzba)object0).zzh) && this.zzi == ((zzba)object0).zzi && this.zzj == ((zzba)object0).zzj && Objects.equal(this.zzk, ((zzba)object0).zzk);
    }

    @Override
    public final int hashCode() {
        return this.zzb.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.zzb);
        if(this.zzd != null) {
            stringBuilder0.append(" tag=");
            stringBuilder0.append(this.zzd);
        }
        if(this.zzh != null) {
            stringBuilder0.append(" moduleId=");
            stringBuilder0.append(this.zzh);
        }
        if(this.zzk != null) {
            stringBuilder0.append(" contextAttributionTag=");
            stringBuilder0.append(this.zzk);
        }
        stringBuilder0.append(" hideAppOps=");
        stringBuilder0.append(this.zze);
        stringBuilder0.append(" clients=");
        stringBuilder0.append(this.zzc);
        stringBuilder0.append(" forceCoarseLocation=");
        stringBuilder0.append(this.zzf);
        if(this.zzg) {
            stringBuilder0.append(" exemptFromBackgroundThrottle");
        }
        if(this.zzi) {
            stringBuilder0.append(" locationSettingsIgnored");
        }
        if(this.zzj) {
            stringBuilder0.append(" inaccurateLocationsDelayed");
        }
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzb, v, false);
        SafeParcelWriter.writeTypedList(parcel0, 5, this.zzc, false);
        SafeParcelWriter.writeString(parcel0, 6, this.zzd, false);
        SafeParcelWriter.writeBoolean(parcel0, 7, this.zze);
        SafeParcelWriter.writeBoolean(parcel0, 8, this.zzf);
        SafeParcelWriter.writeBoolean(parcel0, 9, this.zzg);
        SafeParcelWriter.writeString(parcel0, 10, this.zzh, false);
        SafeParcelWriter.writeBoolean(parcel0, 11, this.zzi);
        SafeParcelWriter.writeBoolean(parcel0, 12, this.zzj);
        SafeParcelWriter.writeString(parcel0, 13, this.zzk, false);
        SafeParcelWriter.writeLong(parcel0, 14, this.zzl);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static zzba zza(String s, LocationRequest locationRequest0) {
        return new zzba(locationRequest0, zzba.zza, null, false, false, false, null, false, false, null, 0x7FFFFFFFFFFFFFFFL);
    }

    public final zzba zzb(long v) {
        if(this.zzb.getMaxWaitTime() <= this.zzb.getInterval()) {
            this.zzl = 10000L;
            return this;
        }
        long v1 = this.zzb.getMaxWaitTime();
        throw new IllegalArgumentException("could not set max age when location batching is requested, interval=" + this.zzb.getInterval() + "maxWaitTime=" + v1);
    }

    public final zzba zzc(String s) {
        this.zzk = s;
        return this;
    }

    public final zzba zzd(boolean z) {
        this.zzj = true;
        return this;
    }
}

