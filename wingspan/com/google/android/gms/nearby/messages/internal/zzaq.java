package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.ListenerHolder;

final class zzaq implements zzbd {
    private final PendingIntent zzhx;

    zzaq(PendingIntent pendingIntent0) {
        this.zzhx = pendingIntent0;
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzbd
    public final void zza(zzah zzah0, ListenerHolder listenerHolder0) {
        zzak.zza(this.zzhx, zzah0, listenerHolder0);
    }
}

