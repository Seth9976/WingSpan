package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;

final class zzap extends zzau {
    private final zzer zzbr;

    zzap(zzao zzao0, zzer zzer0) {
        this.zzbr = zzer0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((EndpointDiscoveryListener)object0).onEndpointFound(this.zzbr.zze(), this.zzbr.getServiceId(), this.zzbr.getEndpointName());
    }
}

