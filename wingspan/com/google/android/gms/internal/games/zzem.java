package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;

final class zzem implements LoadPlayerStatsResult {
    final Status zza;

    zzem(zzeo zzeo0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.games.stats.Stats$LoadPlayerStatsResult
    public final PlayerStats getPlayerStats() {
        return null;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override  // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}

