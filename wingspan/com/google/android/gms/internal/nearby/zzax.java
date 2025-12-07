package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.PayloadCallback;

final class zzax extends zzau {
    private final zzex zzby;

    zzax(zzav zzav0, zzex zzex0) {
        this.zzby = zzex0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((PayloadCallback)object0).onPayloadTransferUpdate(this.zzby.zzg(), this.zzby.zzn());
    }
}

