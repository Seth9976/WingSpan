package com.google.android.gms.games.achievement;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public class AchievementBuffer extends AbstractDataBuffer {
    public AchievementBuffer(DataHolder dataHolder0) {
        super(dataHolder0);
    }

    public Achievement get(int v) {
        return new AchievementRef(this.mDataHolder, v);
    }

    @Override  // com.google.android.gms.common.data.AbstractDataBuffer
    public final Object get(int v) {
        return this.get(v);
    }
}

