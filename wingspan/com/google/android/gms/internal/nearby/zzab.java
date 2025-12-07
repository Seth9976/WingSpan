package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

final class zzab extends zzau {
    private final zzen zzbi;
    private final Status zzbj;

    zzab(zzz zzz0, zzen zzen0, Status status0) {
        this.zzbi = zzen0;
        this.zzbj = status0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((ConnectionLifecycleCallback)object0).onConnectionResult(this.zzbi.zzg(), new ConnectionResolution(this.zzbj));
    }
}

