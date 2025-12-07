package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.SubscribeOptions;

final class zzap implements zzbd {
    private final zzak zzho;
    private final zzbg zzht;
    private final SubscribeOptions zzhu;
    private final PendingIntent zzhw;

    zzap(zzak zzak0, PendingIntent pendingIntent0, zzbg zzbg0, SubscribeOptions subscribeOptions0) {
        this.zzho = zzak0;
        this.zzhw = pendingIntent0;
        this.zzht = zzbg0;
        this.zzhu = subscribeOptions0;
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzbd
    public final void zza(zzah zzah0, ListenerHolder listenerHolder0) {
        this.zzho.zza(this.zzhw, this.zzht, this.zzhu, zzah0, listenerHolder0);
    }
}

