package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.location.zzaa;
import com.google.android.gms.internal.location.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;

class zzao extends zzah {
    private final TaskCompletionSource zza;

    public zzao(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.internal.location.zzai
    public final void zzb(zzaa zzaa0) {
        TaskUtil.setResultOrApiException(zzaa0.getStatus(), this.zza);
    }

    @Override  // com.google.android.gms.internal.location.zzai
    public void zzc() {
    }
}

