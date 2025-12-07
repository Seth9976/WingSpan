package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzag implements RemoteCall {
    private final PendingIntent zza;

    zzag(PendingIntent pendingIntent0) {
        this.zza = pendingIntent0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzao zzao0 = new zzao(((TaskCompletionSource)object1));
        ((zzaz)object0).zzG(this.zza, zzao0);
    }
}

