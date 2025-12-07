package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;

final class zzee implements LoadSnapshotsResult {
    final Status zza;

    zzee(zzeg zzeg0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots$LoadSnapshotsResult
    public final SnapshotMetadataBuffer getSnapshots() {
        return new SnapshotMetadataBuffer(DataHolder.empty(14));
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override  // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}

