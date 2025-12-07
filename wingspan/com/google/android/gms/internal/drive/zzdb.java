package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdb extends TaskApiCall {
    private final MetadataChangeSet zzfd;
    private final DriveFolder zzfz;

    zzdb(zzch zzch0, MetadataChangeSet metadataChangeSet0, DriveFolder driveFolder0) {
        this.zzfd = metadataChangeSet0;
        this.zzfz = driveFolder0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        Context context0 = ((zzaw)api$AnyClient0).getContext();
        this.zzfd.zzq().zza(context0);
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzy(this.zzfz.getDriveId(), this.zzfd.zzq()), new zzhk(taskCompletionSource0));
    }
}

