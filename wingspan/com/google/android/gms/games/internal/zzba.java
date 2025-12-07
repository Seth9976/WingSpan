package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;

final class zzba extends zzao implements LoadEventsResult {
    private final EventBuffer zza;

    zzba(DataHolder dataHolder0) {
        super(dataHolder0);
        this.zza = new EventBuffer(dataHolder0);
    }

    @Override  // com.google.android.gms.games.event.Events$LoadEventsResult
    public final EventBuffer getEvents() {
        return this.zza;
    }
}

