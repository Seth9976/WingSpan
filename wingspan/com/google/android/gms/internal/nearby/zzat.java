package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections.MessageListener;

final class zzat extends zzau {
    private final zzep zzbk;

    zzat(zzar zzar0, zzep zzep0) {
        this.zzbk = zzep0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((MessageListener)object0).onDisconnected(this.zzbk.zzg());
    }
}

