package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzam;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzd implements RemoteCall {
    private final ActivityRecognitionClient zza;
    private final PendingIntent zzb;
    private final SleepSegmentRequest zzc;

    zzd(ActivityRecognitionClient activityRecognitionClient0, PendingIntent pendingIntent0, SleepSegmentRequest sleepSegmentRequest0) {
        this.zza = activityRecognitionClient0;
        this.zzb = pendingIntent0;
        this.zzc = sleepSegmentRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzi zzi0 = new zzi(this.zza, ((TaskCompletionSource)object1));
        ((zzam)((zzaz)object0).getService()).zzv(this.zzb, this.zzc, zzi0);
    }
}

