package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.stats.Stats;

public final class zzep implements Stats {
    @Override  // com.google.android.gms.games.stats.Stats
    public final PendingResult loadPlayerStats(GoogleApiClient googleApiClient0, boolean z) {
        return googleApiClient0.enqueue(new zzel(this, googleApiClient0, z));
    }
}

