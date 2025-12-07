package com.google.android.gms.games.snapshot;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

@Deprecated
public interface Snapshots {
    @Deprecated
    public interface CommitSnapshotResult extends Result {
        SnapshotMetadata getSnapshotMetadata();
    }

    @Deprecated
    public interface DeleteSnapshotResult extends Result {
        String getSnapshotId();
    }

    @Deprecated
    public interface LoadSnapshotsResult extends Releasable, Result {
        SnapshotMetadataBuffer getSnapshots();
    }

    @Deprecated
    public interface OpenSnapshotResult extends Result {
        String getConflictId();

        Snapshot getConflictingSnapshot();

        SnapshotContents getResolutionSnapshotContents();

        Snapshot getSnapshot();
    }

    public static final int DISPLAY_LIMIT_NONE = -1;
    public static final String EXTRA_SNAPSHOT_METADATA = "com.google.android.gms.games.SNAPSHOT_METADATA";
    public static final String EXTRA_SNAPSHOT_NEW = "com.google.android.gms.games.SNAPSHOT_NEW";
    public static final int RESOLUTION_POLICY_HIGHEST_PROGRESS = 4;
    public static final int RESOLUTION_POLICY_LAST_KNOWN_GOOD = 2;
    public static final int RESOLUTION_POLICY_LONGEST_PLAYTIME = 1;
    public static final int RESOLUTION_POLICY_MANUAL = -1;
    public static final int RESOLUTION_POLICY_MOST_RECENTLY_MODIFIED = 3;

    PendingResult commitAndClose(GoogleApiClient arg1, Snapshot arg2, SnapshotMetadataChange arg3);

    PendingResult delete(GoogleApiClient arg1, SnapshotMetadata arg2);

    void discardAndClose(GoogleApiClient arg1, Snapshot arg2);

    int getMaxCoverImageSize(GoogleApiClient arg1);

    int getMaxDataSize(GoogleApiClient arg1);

    Intent getSelectSnapshotIntent(GoogleApiClient arg1, String arg2, boolean arg3, boolean arg4, int arg5);

    SnapshotMetadata getSnapshotFromBundle(Bundle arg1);

    PendingResult load(GoogleApiClient arg1, boolean arg2);

    PendingResult open(GoogleApiClient arg1, SnapshotMetadata arg2);

    PendingResult open(GoogleApiClient arg1, SnapshotMetadata arg2, int arg3);

    PendingResult open(GoogleApiClient arg1, String arg2, boolean arg3);

    PendingResult open(GoogleApiClient arg1, String arg2, boolean arg3, int arg4);

    PendingResult resolveConflict(GoogleApiClient arg1, String arg2, Snapshot arg3);

    PendingResult resolveConflict(GoogleApiClient arg1, String arg2, String arg3, SnapshotMetadataChange arg4, SnapshotContents arg5);
}

