package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zzha;

final class zzbw extends zzab {
    private static final zzha zzih;
    private final ListenerHolder zzii;

    static {
        zzbw.zzih = new zzbx();
    }

    public zzbw(ListenerHolder listenerHolder0) {
        this.zzii = listenerHolder0;
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzaa
    public final void onExpired() {
        this.zzii.notifyListener(zzbw.zzih);
    }
}

