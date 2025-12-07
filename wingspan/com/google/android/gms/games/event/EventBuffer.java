package com.google.android.gms.games.event;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class EventBuffer extends AbstractDataBuffer {
    public EventBuffer(DataHolder dataHolder0) {
        super(dataHolder0);
    }

    public Event get(int v) {
        return new EventRef(this.mDataHolder, v);
    }

    @Override  // com.google.android.gms.common.data.AbstractDataBuffer
    public final Object get(int v) {
        return this.get(v);
    }
}

