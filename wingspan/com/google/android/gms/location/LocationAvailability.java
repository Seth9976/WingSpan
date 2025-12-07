package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    @Deprecated
    int zza;
    @Deprecated
    int zzb;
    long zzc;
    int zzd;
    zzbo[] zze;

    static {
        LocationAvailability.CREATOR = new zzbe();
    }

    LocationAvailability(int v, int v1, int v2, long v3, zzbo[] arr_zzbo) {
        this.zzd = v;
        this.zza = v1;
        this.zzb = v2;
        this.zzc = v3;
        this.zze = arr_zzbo;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof LocationAvailability && this.zza == ((LocationAvailability)object0).zza && this.zzb == ((LocationAvailability)object0).zzb && this.zzc == ((LocationAvailability)object0).zzc && this.zzd == ((LocationAvailability)object0).zzd && Arrays.equals(this.zze, ((LocationAvailability)object0).zze);
    }

    public static LocationAvailability extractLocationAvailability(Intent intent0) {
        if(!LocationAvailability.hasLocationAvailability(intent0)) {
            return null;
        }
        try {
            Bundle bundle0 = intent0.getExtras();
            return bundle0 == null ? null : ((LocationAvailability)bundle0.getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY"));
        }
        catch(ClassCastException unused_ex) {
        }
        return null;
    }

    public static boolean hasLocationAvailability(Intent intent0) {
        return intent0 == null ? false : intent0.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzd, this.zza, this.zzb, this.zzc, this.zze});
    }

    public boolean isLocationAvailable() {
        return this.zzd < 1000;
    }

    @Override
    public String toString() {
        return "LocationAvailability[isLocationAvailable: " + this.isLocationAvailable() + "]";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel0, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzd);
        SafeParcelWriter.writeTypedArray(parcel0, 5, this.zze, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

