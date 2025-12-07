package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzc implements RemoteCall {
    private final long zza;
    private final PendingIntent zzb;

    zzc(long v, PendingIntent pendingIntent0) {
        this.zza = v;
        this.zzb = pendingIntent0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzaz)object0).zzq(this.zza, this.zzb);
        ((TaskCompletionSource)object1).setResult(null);
    }
}

