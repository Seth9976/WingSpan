package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

final class zzbl extends zzao implements OpenSnapshotResult {
    private final Snapshot zza;
    private final String zzb;
    private final Snapshot zzc;
    private final SnapshotContents zzd;

    zzbl(DataHolder dataHolder0, String s, Contents contents0, Contents contents1, Contents contents2) {
        boolean z = true;
        super(dataHolder0);
        SnapshotMetadataBuffer snapshotMetadataBuffer0 = new SnapshotMetadataBuffer(dataHolder0);
        try {
            switch(snapshotMetadataBuffer0.getCount()) {
                case 0: {
                    this.zza = null;
                    this.zzc = null;
                    break;
                }
                case 1: {
                    if(dataHolder0.getStatusCode() == 4004) {
                        z = false;
                    }
                    Asserts.checkState(z);
                    this.zza = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer0.get(0)), new SnapshotContentsEntity(contents0));
                    this.zzc = null;
                    break;
                }
                default: {
                    this.zza = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer0.get(0)), new SnapshotContentsEntity(contents0));
                    this.zzc = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer0.get(1)), new SnapshotContentsEntity(contents1));
                }
            }
        }
        finally {
            snapshotMetadataBuffer0.release();
        }
        this.zzb = s;
        this.zzd = new SnapshotContentsEntity(contents2);
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots$OpenSnapshotResult
    public final String getConflictId() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots$OpenSnapshotResult
    public final Snapshot getConflictingSnapshot() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots$OpenSnapshotResult
    public final SnapshotContents getResolutionSnapshotContents() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots$OpenSnapshotResult
    public final Snapshot getSnapshot() {
        return this.zza;
    }
}

