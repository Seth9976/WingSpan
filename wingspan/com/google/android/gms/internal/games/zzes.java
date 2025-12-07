package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzes implements RemoteCall {
    public final ListenerHolder zza;

    public zzes(ListenerHolder listenerHolder0) {
        this.zza = listenerHolder0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzaL(this.zza);
        ((TaskCompletionSource)object1).setResult(null);
    }
}

