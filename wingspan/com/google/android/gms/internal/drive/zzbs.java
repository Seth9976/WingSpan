package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.zzk;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

public final class zzbs extends zzdp implements DriveFolder {
    public zzbs(DriveId driveId0) {
        super(driveId0);
    }

    @Override  // com.google.android.gms.drive.DriveFolder
    public final PendingResult createFile(GoogleApiClient googleApiClient0, MetadataChangeSet metadataChangeSet0, DriveContents driveContents0) {
        return this.createFile(googleApiClient0, metadataChangeSet0, driveContents0, null);
    }

    @Override  // com.google.android.gms.drive.DriveFolder
    public final PendingResult createFile(GoogleApiClient googleApiClient0, MetadataChangeSet metadataChangeSet0, DriveContents driveContents0, ExecutionOptions executionOptions0) {
        if(executionOptions0 == null) {
            executionOptions0 = new Builder().build();
        }
        if(executionOptions0.zzn() != 0) {
            throw new IllegalStateException("May not set a conflict strategy for new file creation.");
        }
        if(metadataChangeSet0 == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        zzk zzk0 = zzk.zzg(metadataChangeSet0.getMimeType());
        if(zzk0 != null && zzk0.isFolder()) {
            throw new IllegalArgumentException("May not create folders using this method. Use DriveFolder.createFolder() instead of mime type application/vnd.google-apps.folder");
        }
        executionOptions0.zza(googleApiClient0);
        if(driveContents0 != null) {
            if(!(driveContents0 instanceof zzbi)) {
                throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
            }
            if(driveContents0.getDriveId() != null) {
                throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
            }
            if(driveContents0.zzk()) {
                throw new IllegalArgumentException("DriveContents are already closed.");
            }
        }
        zzbs.zzb(metadataChangeSet0);
        int v = zzbs.zza(driveContents0, zzk.zzg(metadataChangeSet0.getMimeType()));
        zzk zzk1 = zzk.zzg(metadataChangeSet0.getMimeType());
        return zzk1 == null || !zzk1.zzbh() ? googleApiClient0.execute(new zzbt(this, googleApiClient0, metadataChangeSet0, v, 0, executionOptions0)) : googleApiClient0.execute(new zzbt(this, googleApiClient0, metadataChangeSet0, v, 1, executionOptions0));
    }

    @Override  // com.google.android.gms.drive.DriveFolder
    public final PendingResult createFolder(GoogleApiClient googleApiClient0, MetadataChangeSet metadataChangeSet0) {
        if(metadataChangeSet0 == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        if(metadataChangeSet0.getMimeType() != null && !metadataChangeSet0.getMimeType().equals("application/vnd.google-apps.folder")) {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
        return googleApiClient0.execute(new zzbu(this, googleApiClient0, metadataChangeSet0));
    }

    @Override  // com.google.android.gms.drive.DriveFolder
    public final PendingResult listChildren(GoogleApiClient googleApiClient0) {
        return this.queryChildren(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.drive.DriveFolder
    public final PendingResult queryChildren(GoogleApiClient googleApiClient0, Query query0) {
        return new zzaf().query(googleApiClient0, zzbs.zza(query0, this.getDriveId()));
    }

    static int zza(DriveContents driveContents0, zzk zzk0) {
        if(driveContents0 == null) {
            return zzk0 == null || !zzk0.zzbh() ? 1 : 0;
        }
        int v = driveContents0.zzi().getRequestId();
        driveContents0.zzj();
        return v;
    }

    static Query zza(Query query0, DriveId driveId0) {
        com.google.android.gms.drive.query.Query.Builder query$Builder0 = new com.google.android.gms.drive.query.Query.Builder().addFilter(Filters.in(SearchableField.PARENTS, driveId0));
        if(query0 != null) {
            if(query0.getFilter() != null) {
                query$Builder0.addFilter(query0.getFilter());
            }
            query$Builder0.setPageToken(query0.getPageToken());
            query$Builder0.setSortOrder(query0.getSortOrder());
        }
        return query$Builder0.build();
    }

    static void zzb(MetadataChangeSet metadataChangeSet0) {
        if(metadataChangeSet0 == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        zzk zzk0 = zzk.zzg(metadataChangeSet0.getMimeType());
        if(zzk0 != null && (zzk0.zzbh() || zzk0.isFolder())) {
            throw new IllegalArgumentException("May not create shortcut files using this method. Use DriveFolder.createShortcutFile() instead.");
        }
    }
}

