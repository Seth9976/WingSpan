package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzv implements RemoteCall {
    private final FusedLocationProviderClient zza;

    zzv(FusedLocationProviderClient fusedLocationProviderClient0) {
        this.zza = fusedLocationProviderClient0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        this.zza.zzd(((zzaz)object0), ((TaskCompletionSource)object1));
    }
}

