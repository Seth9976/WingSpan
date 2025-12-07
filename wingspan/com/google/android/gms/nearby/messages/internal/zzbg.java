package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zzha;

class zzbg extends zzab {
    private static final zzha zzih;
    private final ListenerHolder zzii;

    static {
        zzbg.zzih = new zzbh();
    }

    public zzbg(ListenerHolder listenerHolder0) {
        this.zzii = listenerHolder0;
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzaa
    public void onExpired() {
        ListenerHolder listenerHolder0 = this.zzii;
        if(listenerHolder0 != null) {
            listenerHolder0.notifyListener(zzbg.zzih);
        }
    }
}

