package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;

final class zzaw extends zzau {
    private final zzev zzbu;
    private final Payload zzbx;

    zzaw(zzav zzav0, zzev zzev0, Payload payload0) {
        this.zzbu = zzev0;
        this.zzbx = payload0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((PayloadCallback)object0).onPayloadReceived(this.zzbu.zzg(), this.zzbx);
    }
}

