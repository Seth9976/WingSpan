package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;

final class zzbf implements zzbw {
    private final String zzce;
    private final ListenerHolder zzch;

    zzbf(String s, ListenerHolder listenerHolder0) {
        this.zzce = s;
        this.zzch = listenerHolder0;
    }

    @Override  // com.google.android.gms.internal.nearby.zzbw
    public final void zza(zzx zzx0, ResultHolder baseImplementation$ResultHolder0) {
        zzbd.zza(this.zzce, this.zzch, zzx0, baseImplementation$ResultHolder0);
    }
}

