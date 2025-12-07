package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzba;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzaf implements RemoteCall {
    private final FusedLocationProviderClient zza;
    private final zzba zzb;
    private final PendingIntent zzc;

    zzaf(FusedLocationProviderClient fusedLocationProviderClient0, zzba zzba0, PendingIntent pendingIntent0) {
        this.zza = fusedLocationProviderClient0;
        this.zzb = zzba0;
        this.zzc = pendingIntent0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        this.zza.zza(this.zzb, this.zzc, ((zzaz)object0), ((TaskCompletionSource)object1));
    }
}

