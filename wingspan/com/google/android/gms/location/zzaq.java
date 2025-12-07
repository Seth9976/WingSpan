package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzaq implements RemoteCall {
    private final GeofencingRequest zza;
    private final PendingIntent zzb;

    zzaq(GeofencingRequest geofencingRequest0, PendingIntent pendingIntent0) {
        this.zza = geofencingRequest0;
        this.zzb = pendingIntent0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzat zzat0 = new zzat(((TaskCompletionSource)object1));
        ((zzaz)object0).zzv(this.zza, this.zzb, zzat0);
    }
}

