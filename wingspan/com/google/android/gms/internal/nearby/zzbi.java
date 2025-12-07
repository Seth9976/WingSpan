package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.nearby.connection.Payload;
import java.util.List;

final class zzbi implements zzbw {
    private final Payload zzci;
    private final List zzcj;

    zzbi(List list0, Payload payload0) {
        this.zzcj = list0;
        this.zzci = payload0;
    }

    @Override  // com.google.android.gms.internal.nearby.zzbw
    public final void zza(zzx zzx0, ResultHolder baseImplementation$ResultHolder0) {
        zzbd.zza(this.zzcj, this.zzci, zzx0, baseImplementation$ResultHolder0);
    }
}

