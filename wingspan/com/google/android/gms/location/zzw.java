package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzw implements RemoteCall {
    static final RemoteCall zza;

    static {
        zzw.zza = new zzw();
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzaz)object0).zzK(new zzao(((TaskCompletionSource)object1)));
    }
}

