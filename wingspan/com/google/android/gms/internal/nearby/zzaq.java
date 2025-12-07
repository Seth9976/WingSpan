package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;

final class zzaq extends zzau {
    private final zzet zzbs;

    zzaq(zzao zzao0, zzet zzet0) {
        this.zzbs = zzet0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((EndpointDiscoveryListener)object0).onEndpointLost(this.zzbs.zze());
    }
}

