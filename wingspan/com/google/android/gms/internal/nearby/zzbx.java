package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

final class zzbx extends ConnectionLifecycleCallback {
    private final zzbd zzcq;
    private final ConnectionLifecycleCallback zzct;

    zzbx(zzbd zzbd0, ConnectionLifecycleCallback connectionLifecycleCallback0) {
        this.zzcq = zzbd0;
        super();
        this.zzct = connectionLifecycleCallback0;
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionInitiated(String s, ConnectionInfo connectionInfo0) {
        if(connectionInfo0.isIncomingConnection()) {
            this.zzcq.zzb(s);
        }
        this.zzct.onConnectionInitiated(s, connectionInfo0);
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionResult(String s, ConnectionResolution connectionResolution0) {
        if(!connectionResolution0.getStatus().isSuccess()) {
            this.zzcq.zzc(s);
        }
        this.zzct.onConnectionResult(s, connectionResolution0);
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onDisconnected(String s) {
        this.zzcq.zzc(s);
        this.zzct.onDisconnected(s);
    }
}

