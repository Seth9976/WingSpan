package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

final class zzal extends zzau {
    private final zzer zzbr;

    zzal(zzak zzak0, zzer zzer0) {
        this.zzbr = zzer0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        DiscoveredEndpointInfo discoveredEndpointInfo0;
        String s;
        if("__UNRECOGNIZED_BLUETOOTH_DEVICE__".equals(this.zzbr.zze())) {
            s = this.zzbr.zze();
            discoveredEndpointInfo0 = new DiscoveredEndpointInfo(this.zzbr.getServiceId(), this.zzbr.zzk());
        }
        else {
            s = this.zzbr.zze();
            discoveredEndpointInfo0 = new DiscoveredEndpointInfo(this.zzbr.getServiceId(), this.zzbr.getEndpointName());
        }
        ((EndpointDiscoveryCallback)object0).onEndpointFound(s, discoveredEndpointInfo0);
    }
}

