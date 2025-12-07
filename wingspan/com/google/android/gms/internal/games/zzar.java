package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.zzbz;

public final class zzar implements Events {
    @Override  // com.google.android.gms.games.event.Events
    public final void increment(GoogleApiClient googleApiClient0, String s, int v) {
        zzbz zzbz0 = Games.zzc(googleApiClient0, false);
        if(zzbz0 == null) {
            return;
        }
        if(zzbz0.isConnected()) {
            zzbz0.zzab(s, v);
            return;
        }
        googleApiClient0.execute(new zzak(this, googleApiClient0, s, v));
    }

    @Override  // com.google.android.gms.games.event.Events
    public final PendingResult load(GoogleApiClient googleApiClient0, boolean z) {
        return googleApiClient0.enqueue(new zzaj(this, googleApiClient0, z));
    }

    @Override  // com.google.android.gms.games.event.Events
    public final PendingResult loadByIds(GoogleApiClient googleApiClient0, boolean z, String[] arr_s) {
        return googleApiClient0.enqueue(new zzai(this, googleApiClient0, z, arr_s));
    }
}

