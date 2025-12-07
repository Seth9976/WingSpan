package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;

final class zzah extends zzao implements CommitSnapshotResult {
    private final SnapshotMetadata zza;

    zzah(DataHolder dataHolder0) {
        super(dataHolder0);
        SnapshotMetadataBuffer snapshotMetadataBuffer0 = new SnapshotMetadataBuffer(dataHolder0);
        try {
            this.zza = snapshotMetadataBuffer0.getCount() > 0 ? new SnapshotMetadataEntity(snapshotMetadataBuffer0.get(0)) : null;
        }
        finally {
            snapshotMetadataBuffer0.release();
        }
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots$CommitSnapshotResult
    public final SnapshotMetadata getSnapshotMetadata() {
        return this.zza;
    }
}

