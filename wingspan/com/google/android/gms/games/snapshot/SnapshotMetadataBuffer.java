package com.google.android.gms.games.snapshot;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class SnapshotMetadataBuffer extends AbstractDataBuffer {
    public SnapshotMetadataBuffer(DataHolder dataHolder0) {
        super(dataHolder0);
    }

    public SnapshotMetadata get(int v) {
        return new SnapshotMetadataRef(this.mDataHolder, v);
    }

    @Override  // com.google.android.gms.common.data.AbstractDataBuffer
    public final Object get(int v) {
        return this.get(v);
    }
}

