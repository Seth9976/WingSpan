package com.google.android.gms.games.stats;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class PlayerStatsBuffer extends AbstractDataBuffer {
    public PlayerStatsBuffer(DataHolder dataHolder0) {
        super(dataHolder0);
    }

    @Override  // com.google.android.gms.common.data.AbstractDataBuffer
    public final Object get(int v) {
        return this.zza(v);
    }

    public final PlayerStats zza(int v) {
        return new zzb(this.mDataHolder, v);
    }
}

