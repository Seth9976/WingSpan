package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.SubscribeOptions;

final class zzan implements zzbd {
    private final ListenerHolder zzch;
    private final zzak zzho;
    private final zzbg zzht;
    private final SubscribeOptions zzhu;

    zzan(zzak zzak0, ListenerHolder listenerHolder0, zzbg zzbg0, SubscribeOptions subscribeOptions0) {
        this.zzho = zzak0;
        this.zzch = listenerHolder0;
        this.zzht = zzbg0;
        this.zzhu = subscribeOptions0;
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzbd
    public final void zza(zzah zzah0, ListenerHolder listenerHolder0) {
        this.zzho.zza(this.zzch, this.zzht, this.zzhu, zzah0, listenerHolder0);
    }
}

