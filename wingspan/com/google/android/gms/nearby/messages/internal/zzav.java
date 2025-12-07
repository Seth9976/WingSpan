package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;

final class zzav extends zzbe {
    private final ListenerHolder zzhz;
    private final zzak zzia;

    zzav(zzak zzak0, ListenerHolder listenerHolder0, ListenerHolder listenerHolder1) {
        this.zzia = zzak0;
        this.zzhz = listenerHolder1;
        super(listenerHolder0);
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzbe
    public final void onExpired() {
        this.zzia.doUnregisterEventListener(this.zzhz.getListenerKey());
        super.onExpired();
    }
}

