package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzh implements RemoteCall {
    private final PendingIntent zza;

    zzh(PendingIntent pendingIntent0) {
        this.zza = pendingIntent0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzj zzj0 = new zzj(((TaskCompletionSource)object1));
        ((zzaz)object0).zzu(this.zza, zzj0);
    }
}

