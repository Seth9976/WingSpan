package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.nearby.connection.Payload;

final class zzbh implements zzbw {
    private final String zzce;
    private final Payload zzci;

    zzbh(String s, Payload payload0) {
        this.zzce = s;
        this.zzci = payload0;
    }

    @Override  // com.google.android.gms.internal.nearby.zzbw
    public final void zza(zzx zzx0, ResultHolder baseImplementation$ResultHolder0) {
        zzbd.zza(this.zzce, this.zzci, zzx0, baseImplementation$ResultHolder0);
    }
}

