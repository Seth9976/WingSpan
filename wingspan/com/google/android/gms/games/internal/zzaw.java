package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

class zzaw extends zza {
    private final ListenerHolder zza;

    zzaw(ListenerHolder listenerHolder0) {
        this.zza = (ListenerHolder)Preconditions.checkNotNull(listenerHolder0, "Callback must not be null");
    }

    final void zzw(zzbq zzbq0) {
        zzr zzr0 = new zzr(zzbq0);
        this.zza.notifyListener(zzr0);
    }
}

