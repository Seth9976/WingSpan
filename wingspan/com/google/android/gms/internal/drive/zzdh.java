package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.zzk;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdh extends TaskApiCall {
    private final DriveFolder zzfj;
    private final MetadataChangeSet zzgc;
    private ExecutionOptions zzgd;
    private String zzge;
    private zzk zzgf;
    private final DriveContents zzo;

    zzdh(DriveFolder driveFolder0, MetadataChangeSet metadataChangeSet0, DriveContents driveContents0, ExecutionOptions executionOptions0, String s) {
        this.zzfj = driveFolder0;
        this.zzgc = metadataChangeSet0;
        this.zzo = driveContents0;
        this.zzgd = executionOptions0;
        this.zzge = null;
        Preconditions.checkNotNull(driveFolder0, "DriveFolder must not be null");
        Preconditions.checkNotNull(driveFolder0.getDriveId(), "Folder\'s DriveId must not be null");
        Preconditions.checkNotNull(metadataChangeSet0, "MetadataChangeSet must not be null");
        Preconditions.checkNotNull(executionOptions0, "ExecutionOptions must not be null");
        zzk zzk0 = zzk.zzg(metadataChangeSet0.getMimeType());
        this.zzgf = zzk0;
        if(zzk0 != null && zzk0.isFolder()) {
            throw new IllegalArgumentException("May not create folders using this method. Use DriveFolderManagerClient#createFolder() instead of mime type application/vnd.google-apps.folder");
        }
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
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        this.zzgd.zza(((zzaw)api$AnyClient0));
        this.zzgc.zzq().zza(((zzaw)api$AnyClient0).getContext());
        int v = zzbs.zza(this.zzo, this.zzgf);
        int v1 = this.zzgf == null || !this.zzgf.zzbh() ? 0 : 1;
        zzw zzw0 = new zzw(this.zzfj.getDriveId(), this.zzgc.zzq(), v, v1, this.zzgd);
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(zzw0, new zzhj(taskCompletionSource0));
    }
}

