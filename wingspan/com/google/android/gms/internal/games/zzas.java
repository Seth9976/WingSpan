package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzas implements RemoteCall {
    public final int zza;

    public zzas(int v) {
        this.zza = v;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzaS(this.zza);
        ((TaskCompletionSource)object1).setResult(null);
    }
}

