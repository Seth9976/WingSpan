package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.messages.MessageListener;
import java.util.List;

final class zzgx extends zzha {
    private final List zzjk;

    zzgx(zzgw zzgw0, List list0) {
        this.zzjk = list0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        zzgw.zza(this.zzjk, ((MessageListener)object0));
    }
}

