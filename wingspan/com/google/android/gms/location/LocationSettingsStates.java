package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final boolean zza;
    private final boolean zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final boolean zzf;

    static {
        LocationSettingsStates.CREATOR = new zzbn();
    }

    public LocationSettingsStates(boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.zza = z;
        this.zzb = z1;
        this.zzc = z2;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = z5;
    }

    public static LocationSettingsStates fromIntent(Intent intent0) {
        return (LocationSettingsStates)SafeParcelableSerializer.deserializeFromIntentExtra(intent0, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", LocationSettingsStates.CREATOR);
    }

    public boolean isBlePresent() {
        return this.zzf;
    }

    public boolean isBleUsable() {
        return this.zzc;
    }

    public boolean isGpsPresent() {
        return this.zzd;
    }

    public boolean isGpsUsable() {
        return this.zza;
    }

    // 去混淆评级： 低(20)
    public boolean isLocationPresent() {
        return this.zzd || this.zze;
    }

    // 去混淆评级： 低(20)
    public boolean isLocationUsable() {
        return this.zza || this.zzb;
    }

    public boolean isNetworkLocationPresent() {
        return this.zze;
    }

    public boolean isNetworkLocationUsable() {
        return this.zzb;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 1, this.isGpsUsable());
        SafeParcelWriter.writeBoolean(parcel0, 2, this.isNetworkLocationUsable());
        SafeParcelWriter.writeBoolean(parcel0, 3, this.isBleUsable());
        SafeParcelWriter.writeBoolean(parcel0, 4, this.isGpsPresent());
        SafeParcelWriter.writeBoolean(parcel0, 5, this.isNetworkLocationPresent());
        SafeParcelWriter.writeBoolean(parcel0, 6, this.isBlePresent());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

