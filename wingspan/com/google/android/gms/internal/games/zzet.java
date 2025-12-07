package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzet implements RemoteCall {
    public static final zzet zza;

    static {
        zzet.zza = new zzet();
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzbb();
        ((TaskCompletionSource)object1).setResult(Boolean.TRUE);
    }
}

