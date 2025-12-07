package com.google.android.gms.location;

import com.google.android.gms.tasks.OnTokenCanceledListener;

final class zzy implements OnTokenCanceledListener {
    private final FusedLocationProviderClient zza;
    private final LocationCallback zzb;

    zzy(FusedLocationProviderClient fusedLocationProviderClient0, LocationCallback locationCallback0) {
        this.zza = fusedLocationProviderClient0;
        this.zzb = locationCallback0;
    }

    @Override  // com.google.android.gms.tasks.OnTokenCanceledListener
    public final void onCanceled() {
        this.zza.removeLocationUpdates(this.zzb);
    }
}

