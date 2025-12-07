package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

final class zzae extends zzau {
    private final String zzbm;

    zzae(zzz zzz0, String s) {
        this.zzbm = s;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ConnectionResolution connectionResolution0 = new ConnectionResolution(zzx.zza(13));
        ((ConnectionLifecycleCallback)object0).onConnectionResult(this.zzbm, connectionResolution0);
    }
}

