package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;

final class zzal implements LoadEventsResult {
    final Status zza;

    zzal(zzan zzan0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.games.event.Events$LoadEventsResult
    public final EventBuffer getEvents() {
        return new EventBuffer(DataHolder.empty(14));
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override  // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}

