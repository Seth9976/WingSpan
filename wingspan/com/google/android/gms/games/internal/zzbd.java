package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;

final class zzbd extends zzao implements LoadPlayerStatsResult {
    private final PlayerStats zza;

    zzbd(DataHolder dataHolder0) {
        super(dataHolder0);
        PlayerStatsBuffer playerStatsBuffer0 = new PlayerStatsBuffer(dataHolder0);
        try {
            this.zza = playerStatsBuffer0.getCount() > 0 ? new PlayerStatsEntity(playerStatsBuffer0.zza(0)) : null;
        }
        finally {
            playerStatsBuffer0.release();
        }
    }

    @Override  // com.google.android.gms.games.stats.Stats$LoadPlayerStatsResult
    public final PlayerStats getPlayerStats() {
        return this.zza;
    }
}

