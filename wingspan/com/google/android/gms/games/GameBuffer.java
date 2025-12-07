package com.google.android.gms.games;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameBuffer extends AbstractDataBuffer {
    public GameBuffer(DataHolder dataHolder0) {
        super(dataHolder0);
    }

    public Game get(int v) {
        return new GameRef(this.mDataHolder, v);
    }

    @Override  // com.google.android.gms.common.data.AbstractDataBuffer
    public final Object get(int v) {
        return this.get(v);
    }
}

