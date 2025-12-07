package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

final class zzan extends zzau {
    private final String zzbm;

    zzan(zzak zzak0, String s) {
        this.zzbm = s;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((EndpointDiscoveryCallback)object0).onEndpointLost(this.zzbm);
    }
}

