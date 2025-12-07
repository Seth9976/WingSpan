package com.google.android.gms.games;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public class PlayerBuffer extends AbstractDataBuffer {
    public PlayerBuffer(DataHolder dataHolder0) {
        super(dataHolder0);
    }

    public Player get(int v) {
        return new PlayerRef(this.mDataHolder, v, null);
    }

    @Override  // com.google.android.gms.common.data.AbstractDataBuffer
    public final Object get(int v) {
        return this.get(v);
    }
}

