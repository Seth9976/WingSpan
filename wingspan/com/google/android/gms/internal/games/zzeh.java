package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

final class zzeh implements OpenSnapshotResult {
    final Status zza;

    zzeh(zzej zzej0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots$OpenSnapshotResult
    public final String getConflictId() {
        return null;
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots$OpenSnapshotResult
    public final Snapshot getConflictingSnapshot() {
        return null;
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots$OpenSnapshotResult
    public final SnapshotContents getResolutionSnapshotContents() {
        return null;
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots$OpenSnapshotResult
    public final Snapshot getSnapshot() {
        return null;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

