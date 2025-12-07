package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.zzn;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcy extends TaskApiCall {
    private final MetadataChangeSet zzew;
    private final DriveContents zzfx;
    private final zzn zzfy;

    zzcy(zzch zzch0, zzn zzn0, DriveContents driveContents0, MetadataChangeSet metadataChangeSet0) {
        this.zzfy = zzn0;
        this.zzfx = driveContents0;
        this.zzew = metadataChangeSet0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        zzaw zzaw0 = (zzaw)api$AnyClient0;
        try {
            this.zzfy.zza(zzaw0);
        }
        catch(IllegalStateException illegalStateException0) {
            taskCompletionSource0.setException(illegalStateException0);
        }
        this.zzfx.zzj();
        Context context0 = zzaw0.getContext();
        this.zzew.zzq().zza(context0);
        zzeo zzeo0 = (zzeo)zzaw0.getService();
        DriveId driveId0 = this.zzfx.getDriveId();
        int v = this.zzfx.zzi().getRequestId();
        boolean z = this.zzfx.zzi().zzb();
        zzeo0.zza(new zzm(driveId0, this.zzew.zzq(), v, z, this.zzfy), new zzhr(taskCompletionSource0));
    }
}

