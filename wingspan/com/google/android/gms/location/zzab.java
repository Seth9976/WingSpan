package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzba;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzab implements RemoteCall {
    private final FusedLocationProviderClient zza;
    private final CancellationToken zzb;
    private final zzba zzc;

    zzab(FusedLocationProviderClient fusedLocationProviderClient0, CancellationToken cancellationToken0, zzba zzba0) {
        this.zza = fusedLocationProviderClient0;
        this.zzb = cancellationToken0;
        this.zzc = zzba0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        this.zza.zzc(this.zzb, this.zzc, ((zzaz)object0), ((TaskCompletionSource)object1));
    }
}

