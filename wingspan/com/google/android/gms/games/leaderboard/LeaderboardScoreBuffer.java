package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public class LeaderboardScoreBuffer extends AbstractDataBuffer {
    private final zza zza;

    public LeaderboardScoreBuffer(DataHolder dataHolder0) {
        super(dataHolder0);
        this.zza = new zza(dataHolder0.getMetadata());
    }

    public LeaderboardScore get(int v) {
        return new LeaderboardScoreRef(this.mDataHolder, v);
    }

    @Override  // com.google.android.gms.common.data.AbstractDataBuffer
    public final Object get(int v) {
        return this.get(v);
    }

    public final zza zza() {
        return this.zza;
    }
}

