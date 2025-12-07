package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class LocationSettingsResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator CREATOR;
    private final Status zza;
    private final LocationSettingsStates zzb;

    static {
        LocationSettingsResult.CREATOR = new zzbm();
    }

    public LocationSettingsResult(Status status0, LocationSettingsStates locationSettingsStates0) {
        this.zza = status0;
        this.zzb = locationSettingsStates0;
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zza;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.getStatus(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.getLocationSettingsStates(), v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

