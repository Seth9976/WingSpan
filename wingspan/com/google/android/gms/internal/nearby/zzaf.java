package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

final class zzaf extends zzau {
    private final String zzbm;

    zzaf(zzz zzz0, String s) {
        this.zzbm = s;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((ConnectionLifecycleCallback)object0).onDisconnected(this.zzbm);
    }
}

