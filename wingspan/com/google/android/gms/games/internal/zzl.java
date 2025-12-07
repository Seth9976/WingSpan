package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zzl extends zzbr {
    zzl(ResultHolder baseImplementation$ResultHolder0) {
        super(baseImplementation$ResultHolder0);
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzu(int v, boolean z) {
        this.zzw(new zzad(new Status(v), z));
    }
}

