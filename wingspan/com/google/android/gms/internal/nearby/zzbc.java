package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.Preconditions;

final class zzbc extends zzed {
    private final ResultHolder zzcb;

    zzbc(ResultHolder baseImplementation$ResultHolder0) {
        this.zzcb = (ResultHolder)Preconditions.checkNotNull(baseImplementation$ResultHolder0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzec
    public final void zza(zzez zzez0) {
        Status status0 = zzx.zza(zzez0.getStatusCode());
        if(status0.isSuccess()) {
            zzbb zzbb0 = new zzbb(status0, zzez0.getLocalEndpointName());
            this.zzcb.setResult(zzbb0);
            return;
        }
        this.zzcb.setFailedResult(status0);
    }
}

