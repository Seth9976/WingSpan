package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

final class zzam extends zzau {
    private final zzet zzbs;

    zzam(zzak zzak0, zzet zzet0) {
        this.zzbs = zzet0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((EndpointDiscoveryCallback)object0).onEndpointLost(this.zzbs.zze());
    }
}

