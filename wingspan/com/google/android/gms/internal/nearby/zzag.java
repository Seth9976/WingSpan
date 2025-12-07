package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

@Deprecated
final class zzag extends zzde {
    private final ListenerHolder zzbe;

    zzag(ListenerHolder listenerHolder0) {
        this.zzbe = (ListenerHolder)Preconditions.checkNotNull(listenerHolder0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdd
    public final void zza(zzej zzej0) {
        zzah zzah0 = new zzah(this, zzej0);
        this.zzbe.notifyListener(zzah0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdd
    public final void zza(zzfb zzfb0) {
    }
}

