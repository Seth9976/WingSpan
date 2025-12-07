package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;

final class zzaj extends zzau {
    private final zzel zzbp;

    zzaj(zzai zzai0, zzel zzel0) {
        this.zzbp = zzel0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((ConnectionResponseCallback)object0).onConnectionResponse(this.zzbp.zzg(), zzx.zza(this.zzbp.getStatusCode()), this.zzbp.zzj());
    }
}

