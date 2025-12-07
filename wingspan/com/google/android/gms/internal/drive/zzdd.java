package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdd extends TaskApiCall {
    private final MetadataChangeSet zzfd;
    private final DriveResource zzfq;

    zzdd(zzch zzch0, MetadataChangeSet metadataChangeSet0, DriveResource driveResource0) {
        this.zzfd = metadataChangeSet0;
        this.zzfq = driveResource0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        Context context0 = ((zzaw)api$AnyClient0).getContext();
        this.zzfd.zzq().zza(context0);
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzhf(this.zzfq.getDriveId(), this.zzfd.zzq()), new zzhp(taskCompletionSource0));
    }
}

