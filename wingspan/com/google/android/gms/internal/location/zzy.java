package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zzy extends zzah {
    private final ResultHolder zza;

    public zzy(ResultHolder baseImplementation$ResultHolder0) {
        this.zza = baseImplementation$ResultHolder0;
    }

    @Override  // com.google.android.gms.internal.location.zzai
    public final void zzb(zzaa zzaa0) {
        Status status0 = zzaa0.getStatus();
        this.zza.setResult(status0);
    }

    @Override  // com.google.android.gms.internal.location.zzai
    public final void zzc() {
    }
}

