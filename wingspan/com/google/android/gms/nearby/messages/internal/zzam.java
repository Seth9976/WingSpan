package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.Message;

final class zzam implements zzbd {
    private final Message zzhs;

    zzam(Message message0) {
        this.zzhs = message0;
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzbd
    public final void zza(zzah zzah0, ListenerHolder listenerHolder0) {
        zzak.zza(this.zzhs, zzah0, listenerHolder0);
    }
}

