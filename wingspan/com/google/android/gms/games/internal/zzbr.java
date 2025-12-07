package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.Preconditions;

class zzbr extends zza {
    private final ResultHolder zza;

    zzbr(ResultHolder baseImplementation$ResultHolder0) {
        this.zza = (ResultHolder)Preconditions.checkNotNull(baseImplementation$ResultHolder0, "Holder must not be null");
    }

    final void zzw(Object object0) {
        this.zza.setResult(object0);
    }
}

