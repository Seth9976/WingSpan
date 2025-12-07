package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;

final class zzah extends zzau {
    private final zzej zzbn;

    zzah(zzag zzag0, zzej zzej0) {
        this.zzbn = zzej0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((ConnectionRequestListener)object0).onConnectionRequest(this.zzbn.zzg(), this.zzbn.zzh(), this.zzbn.zzj());
    }
}

