package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;

final class zzbe implements zzbw {
    private final String zzce;
    private final String zzcf;
    private final ListenerHolder zzcg;

    zzbe(String s, String s1, ListenerHolder listenerHolder0) {
        this.zzce = s;
        this.zzcf = s1;
        this.zzcg = listenerHolder0;
    }

    @Override  // com.google.android.gms.internal.nearby.zzbw
    public final void zza(zzx zzx0, ResultHolder baseImplementation$ResultHolder0) {
        zzbd.zza(this.zzce, this.zzcf, this.zzcg, zzx0, baseImplementation$ResultHolder0);
    }
}

