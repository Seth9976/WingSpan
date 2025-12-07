package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;

final class zzbg extends zzao implements LoadSnapshotsResult {
    zzbg(DataHolder dataHolder0) {
        super(dataHolder0);
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots$LoadSnapshotsResult
    public final SnapshotMetadataBuffer getSnapshots() {
        return new SnapshotMetadataBuffer(this.mDataHolder);
    }
}

