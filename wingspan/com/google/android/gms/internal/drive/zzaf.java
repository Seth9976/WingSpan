package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;

@Deprecated
public final class zzaf implements DriveApi {
    @Override  // com.google.android.gms.drive.DriveApi
    public final PendingResult fetchDriveId(GoogleApiClient googleApiClient0, String s) {
        return googleApiClient0.enqueue(new zzai(this, googleApiClient0, s));
    }

    @Override  // com.google.android.gms.drive.DriveApi
    public final DriveFolder getAppFolder(GoogleApiClient googleApiClient0) {
        zzaw zzaw0 = (zzaw)googleApiClient0.getClient(Drive.CLIENT_KEY);
        if(!zzaw0.zzag()) {
            throw new IllegalStateException("Client is not yet connected");
        }
        DriveId driveId0 = zzaw0.zzaf();
        return driveId0 != null ? new zzbs(driveId0) : null;
    }

    @Override  // com.google.android.gms.drive.DriveApi
    public final DriveFolder getRootFolder(GoogleApiClient googleApiClient0) {
        zzaw zzaw0 = (zzaw)googleApiClient0.getClient(Drive.CLIENT_KEY);
        if(!zzaw0.zzag()) {
            throw new IllegalStateException("Client is not yet connected");
        }
        DriveId driveId0 = zzaw0.zzae();
        return driveId0 != null ? new zzbs(driveId0) : null;
    }

    @Override  // com.google.android.gms.drive.DriveApi
    public final CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    @Override  // com.google.android.gms.drive.DriveApi
    public final PendingResult newDriveContents(GoogleApiClient googleApiClient0) {
        return googleApiClient0.enqueue(new zzah(this, googleApiClient0, 0x20000000));
    }

    @Override  // com.google.android.gms.drive.DriveApi
    public final OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    @Override  // com.google.android.gms.drive.DriveApi
    public final PendingResult query(GoogleApiClient googleApiClient0, Query query0) {
        if(query0 == null) {
            throw new IllegalArgumentException("Query must be provided.");
        }
        return googleApiClient0.enqueue(new zzag(this, googleApiClient0, query0));
    }

    @Override  // com.google.android.gms.drive.DriveApi
    public final PendingResult requestSync(GoogleApiClient googleApiClient0) {
        return googleApiClient0.execute(new zzaj(this, googleApiClient0));
    }
}

