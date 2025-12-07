package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzah implements RemoteCall {
    private final boolean zza;

    zzah(boolean z) {
        this.zza = z;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzaz)object0).zzI(this.zza);
        ((TaskCompletionSource)object1).setResult(null);
    }
}

