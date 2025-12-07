package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;

public class LeaderboardBuffer extends EntityBuffer {
    public LeaderboardBuffer(DataHolder dataHolder0) {
        super(dataHolder0);
    }

    @Override  // com.google.android.gms.common.data.EntityBuffer
    protected final Object getEntry(int v, int v1) {
        return new LeaderboardRef(this.mDataHolder, v, v1);
    }

    @Override  // com.google.android.gms.common.data.EntityBuffer
    protected final String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}

