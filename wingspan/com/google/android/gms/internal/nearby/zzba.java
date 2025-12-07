package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.Preconditions;

final class zzba extends zzea {
    private final ResultHolder zzcb;

    zzba(ResultHolder baseImplementation$ResultHolder0) {
        this.zzcb = (ResultHolder)Preconditions.checkNotNull(baseImplementation$ResultHolder0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdz
    public final void zzc(int v) {
        Status status0 = zzx.zza(v);
        if(status0.isSuccess()) {
            this.zzcb.setResult(status0);
            return;
        }
        this.zzcb.setFailedResult(status0);
    }
}

