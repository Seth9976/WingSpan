package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzf implements RemoteCall {
    private final ActivityTransitionRequest zza;
    private final PendingIntent zzb;

    zzf(ActivityTransitionRequest activityTransitionRequest0, PendingIntent pendingIntent0) {
        this.zza = activityTransitionRequest0;
        this.zzb = pendingIntent0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzj zzj0 = new zzj(((TaskCompletionSource)object1));
        ((zzaz)object0).zzr(this.zza, this.zzb, zzj0);
    }
}

