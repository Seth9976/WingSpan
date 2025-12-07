package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

@Deprecated
final class zzar extends zzdh {
    private final ListenerHolder zzbt;

    zzar(ListenerHolder listenerHolder0) {
        this.zzbt = (ListenerHolder)Preconditions.checkNotNull(listenerHolder0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdg
    public final void zza(zzep zzep0) {
        zzat zzat0 = new zzat(this, zzep0);
        this.zzbt.notifyListener(zzat0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdg
    public final void zza(zzev zzev0) {
        zzas zzas0 = new zzas(this, zzev0);
        this.zzbt.notifyListener(zzas0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdg
    public final void zza(zzex zzex0) {
    }
}

