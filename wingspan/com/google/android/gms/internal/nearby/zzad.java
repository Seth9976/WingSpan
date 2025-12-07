package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.zze;

final class zzad extends zzau {
    private final zzef zzbl;

    zzad(zzz zzz0, zzef zzef0) {
        this.zzbl = zzef0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        new zze(this.zzbl.getQuality());
    }
}

