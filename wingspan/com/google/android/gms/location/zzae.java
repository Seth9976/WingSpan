package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzba;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzae implements RemoteCall {
    private final FusedLocationProviderClient zza;
    private final zzap zzb;
    private final LocationCallback zzc;
    private final zzan zzd;
    private final zzba zze;
    private final ListenerHolder zzf;

    zzae(FusedLocationProviderClient fusedLocationProviderClient0, zzap zzap0, LocationCallback locationCallback0, zzan zzan0, zzba zzba0, ListenerHolder listenerHolder0) {
        this.zza = fusedLocationProviderClient0;
        this.zzb = zzap0;
        this.zzc = locationCallback0;
        this.zzd = zzan0;
        this.zze = zzba0;
        this.zzf = listenerHolder0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        this.zza.zzb(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, ((zzaz)object0), ((TaskCompletionSource)object1));
    }
}

