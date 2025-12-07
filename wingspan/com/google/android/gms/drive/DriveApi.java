package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.drive.query.Query;

@Deprecated
public interface DriveApi {
    @Deprecated
    public interface DriveContentsResult extends Result {
        DriveContents getDriveContents();
    }

    @Deprecated
    public interface DriveIdResult extends Result {
        DriveId getDriveId();
    }

    @Deprecated
    public interface MetadataBufferResult extends Releasable, Result {
        MetadataBuffer getMetadataBuffer();
    }

    @Deprecated
    PendingResult fetchDriveId(GoogleApiClient arg1, String arg2);

    @Deprecated
    DriveFolder getAppFolder(GoogleApiClient arg1);

    @Deprecated
    DriveFolder getRootFolder(GoogleApiClient arg1);

    @Deprecated
    CreateFileActivityBuilder newCreateFileActivityBuilder();

    @Deprecated
    PendingResult newDriveContents(GoogleApiClient arg1);

    @Deprecated
    OpenFileActivityBuilder newOpenFileActivityBuilder();

    @Deprecated
    PendingResult query(GoogleApiClient arg1, Query arg2);

    @Deprecated
    PendingResult requestSync(GoogleApiClient arg1);
}

