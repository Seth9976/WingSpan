package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzad implements RemoteCall {
    static final RemoteCall zza;

    static {
        zzad.zza = new zzad();
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((TaskCompletionSource)object1).setResult(((zzaz)object0).zzA());
    }
}

