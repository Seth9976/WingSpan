package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Payload;

final class zzas extends zzau {
    private final zzev zzbu;

    zzas(zzar zzar0, zzev zzev0) {
        this.zzbu = zzev0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        Payload payload0 = zzfl.zza(this.zzbu.zzl());
        if(payload0 == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", this.zzbu.zzl().getId()));
            return;
        }
        if(payload0.getType() == 1) {
            ((MessageListener)object0).onMessageReceived(this.zzbu.zzg(), payload0.asBytes(), this.zzbu.zzm());
        }
    }
}

