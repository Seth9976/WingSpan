package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;

final class zzaw extends zzbg {
    private final ListenerHolder zzco;
    private final zzak zzia;

    zzaw(zzak zzak0, ListenerHolder listenerHolder0, ListenerHolder listenerHolder1) {
        this.zzia = zzak0;
        this.zzco = listenerHolder1;
        super(listenerHolder0);
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzbg
    public final void onExpired() {
        this.zzia.doUnregisterEventListener(this.zzco.getListenerKey());
        super.onExpired();
    }
}

