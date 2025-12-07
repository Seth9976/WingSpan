package com.google.android.gms.location;

import android.location.Location;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzaj extends LocationCallback {
    final TaskCompletionSource zza;
    final FusedLocationProviderClient zzb;

    zzaj(FusedLocationProviderClient fusedLocationProviderClient0, TaskCompletionSource taskCompletionSource0) {
        this.zzb = fusedLocationProviderClient0;
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.location.LocationCallback
    public final void onLocationAvailability(LocationAvailability locationAvailability0) {
    }

    @Override  // com.google.android.gms.location.LocationCallback
    public final void onLocationResult(LocationResult locationResult0) {
        Location location0 = locationResult0.getLastLocation();
        this.zza.trySetResult(location0);
        this.zzb.removeLocationUpdates(this);
    }
}

