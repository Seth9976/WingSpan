package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;

final class zzal implements zzbd {
    private final zzak zzho;
    private final Message zzhp;
    private final zzbe zzhq;
    private final PublishOptions zzhr;

    zzal(zzak zzak0, Message message0, zzbe zzbe0, PublishOptions publishOptions0) {
        this.zzho = zzak0;
        this.zzhp = message0;
        this.zzhq = zzbe0;
        this.zzhr = publishOptions0;
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzbd
    public final void zza(zzah zzah0, ListenerHolder listenerHolder0) {
        this.zzho.zza(this.zzhp, this.zzhq, this.zzhr, zzah0, listenerHolder0);
    }
}

