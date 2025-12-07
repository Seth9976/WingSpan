package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

final class zzao extends zzds {
    private final ListenerHolder zzbe;

    zzao(ListenerHolder listenerHolder0) {
        this.zzbe = (ListenerHolder)Preconditions.checkNotNull(listenerHolder0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzer zzer0) {
        zzap zzap0 = new zzap(this, zzer0);
        this.zzbe.notifyListener(zzap0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzet zzet0) {
        zzaq zzaq0 = new zzaq(this, zzet0);
        this.zzbe.notifyListener(zzaq0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzfd zzfd0) {
    }
}

