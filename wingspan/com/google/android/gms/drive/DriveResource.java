package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.Set;

public interface DriveResource {
    @Deprecated
    public interface MetadataResult extends Result {
        Metadata getMetadata();
    }

    @Deprecated
    PendingResult addChangeListener(GoogleApiClient arg1, ChangeListener arg2);

    @Deprecated
    PendingResult addChangeSubscription(GoogleApiClient arg1);

    @Deprecated
    PendingResult delete(GoogleApiClient arg1);

    DriveId getDriveId();

    @Deprecated
    PendingResult getMetadata(GoogleApiClient arg1);

    @Deprecated
    PendingResult listParents(GoogleApiClient arg1);

    @Deprecated
    PendingResult removeChangeListener(GoogleApiClient arg1, ChangeListener arg2);

    @Deprecated
    PendingResult removeChangeSubscription(GoogleApiClient arg1);

    @Deprecated
    PendingResult setParents(GoogleApiClient arg1, Set arg2);

    @Deprecated
    PendingResult trash(GoogleApiClient arg1);

    @Deprecated
    PendingResult untrash(GoogleApiClient arg1);

    @Deprecated
    PendingResult updateMetadata(GoogleApiClient arg1, MetadataChangeSet arg2);
}

