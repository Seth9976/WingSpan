package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zzha;

final class zzbt extends zzv {
    private static final zzha zzih;
    private final ListenerHolder zzii;

    static {
        zzbt.zzih = new zzbu();
    }

    public zzbt(ListenerHolder listenerHolder0) {
        this.zzii = listenerHolder0;
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzu
    public final void onExpired() {
        this.zzii.notifyListener(zzbt.zzih);
    }
}

