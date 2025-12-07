package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.internal.zzy;

public final class zzhb extends zzy {
    private final ListenerHolder zzjj;

    public zzhb(ListenerHolder listenerHolder0) {
        this.zzjj = listenerHolder0;
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzx
    public final void onPermissionChanged(boolean z) {
        zzhc zzhc0 = new zzhc(this, z);
        this.zzjj.notifyListener(zzhc0);
    }
}

