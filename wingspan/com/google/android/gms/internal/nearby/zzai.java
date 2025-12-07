package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

@Deprecated
final class zzai extends zzdn {
    private final ListenerHolder zzbo;

    public zzai(ListenerHolder listenerHolder0) {
        this.zzbo = (ListenerHolder)Preconditions.checkNotNull(listenerHolder0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdm
    public final void zza(zzel zzel0) {
        zzaj zzaj0 = new zzaj(this, zzel0);
        this.zzbo.notifyListener(zzaj0);
    }
}

