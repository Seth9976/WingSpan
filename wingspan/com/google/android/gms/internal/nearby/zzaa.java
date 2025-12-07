package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

final class zzaa extends zzau {
    private final zzeh zzbh;

    zzaa(zzz zzz0, zzeh zzeh0) {
        this.zzbh = zzeh0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((ConnectionLifecycleCallback)object0).onConnectionInitiated(this.zzbh.zzg(), new ConnectionInfo(this.zzbh.zzh(), this.zzbh.getAuthenticationToken(), this.zzbh.zzi()));
    }
}

