package com.google.android.gms.internal.games;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;

public final class zzek implements Snapshots {
    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult commitAndClose(GoogleApiClient googleApiClient0, Snapshot snapshot0, SnapshotMetadataChange snapshotMetadataChange0) {
        return googleApiClient0.execute(new zzdv(this, googleApiClient0, snapshot0, snapshotMetadataChange0));
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult delete(GoogleApiClient googleApiClient0, SnapshotMetadata snapshotMetadata0) {
        return googleApiClient0.execute(new zzdw(this, googleApiClient0, snapshotMetadata0));
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final void discardAndClose(GoogleApiClient googleApiClient0, Snapshot snapshot0) {
        Games.zzd(googleApiClient0, true).zzT(snapshot0);
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final int getMaxCoverImageSize(GoogleApiClient googleApiClient0) {
        return Games.zzd(googleApiClient0, true).zzq();
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final int getMaxDataSize(GoogleApiClient googleApiClient0) {
        return Games.zzd(googleApiClient0, true).zzs();
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final Intent getSelectSnapshotIntent(GoogleApiClient googleApiClient0, String s, boolean z, boolean z1, int v) {
        return Games.zzd(googleApiClient0, true).zzC(s, z, z1, v);
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final SnapshotMetadata getSnapshotFromBundle(Bundle bundle0) {
        return bundle0 == null || !bundle0.containsKey("com.google.android.gms.games.SNAPSHOT_METADATA") ? null : ((SnapshotMetadata)bundle0.getParcelable("com.google.android.gms.games.SNAPSHOT_METADATA"));
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult load(GoogleApiClient googleApiClient0, boolean z) {
        return googleApiClient0.enqueue(new zzdt(this, googleApiClient0, z));
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult open(GoogleApiClient googleApiClient0, SnapshotMetadata snapshotMetadata0) {
        return this.open(googleApiClient0, snapshotMetadata0.getUniqueName(), false, -1);
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult open(GoogleApiClient googleApiClient0, SnapshotMetadata snapshotMetadata0, int v) {
        return this.open(googleApiClient0, snapshotMetadata0.getUniqueName(), false, v);
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult open(GoogleApiClient googleApiClient0, String s, boolean z) {
        return this.open(googleApiClient0, s, z, -1);
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult open(GoogleApiClient googleApiClient0, String s, boolean z, int v) {
        return googleApiClient0.execute(new zzdu(this, googleApiClient0, s, z, v));
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult resolveConflict(GoogleApiClient googleApiClient0, String s, Snapshot snapshot0) {
        SnapshotMetadata snapshotMetadata0 = snapshot0.getMetadata();
        Builder snapshotMetadataChange$Builder0 = new Builder();
        snapshotMetadataChange$Builder0.fromMetadata(snapshotMetadata0);
        SnapshotMetadataChange snapshotMetadataChange0 = snapshotMetadataChange$Builder0.build();
        return googleApiClient0.execute(new zzdx(this, googleApiClient0, s, snapshotMetadata0.getSnapshotId(), snapshotMetadataChange0, snapshot0.getSnapshotContents()));
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult resolveConflict(GoogleApiClient googleApiClient0, String s, String s1, SnapshotMetadataChange snapshotMetadataChange0, SnapshotContents snapshotContents0) {
        return googleApiClient0.execute(new zzdx(this, googleApiClient0, s, s1, snapshotMetadataChange0, snapshotContents0));
    }
}

