package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;

final class zzbt extends zzby {
    private final MetadataChangeSet zzfd;
    private final int zzfe;
    private final int zzff;
    private final ExecutionOptions zzfg;
    private final zzbs zzfh;

    zzbt(zzbs zzbs0, GoogleApiClient googleApiClient0, MetadataChangeSet metadataChangeSet0, int v, int v1, ExecutionOptions executionOptions0) {
        this.zzfh = zzbs0;
        this.zzfd = metadataChangeSet0;
        this.zzfe = v;
        this.zzff = v1;
        this.zzfg = executionOptions0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        Context context0 = ((zzaw)api$AnyClient0).getContext();
        this.zzfd.zzq().zza(context0);
        zzw zzw0 = new zzw(this.zzfh.getDriveId(), this.zzfd.zzq(), this.zzfe, this.zzff, this.zzfg);
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(zzw0, new zzbv(this));
    }
}

