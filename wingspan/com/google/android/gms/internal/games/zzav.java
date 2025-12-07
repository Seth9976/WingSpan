package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzav implements RemoteCall {
    public static final zzav zza;

    static {
        zzav.zza = new zzav();
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzbz zzbz0 = (zzbz)object0;
        ((TaskCompletionSource)object1).setResult(null);
    }
}

