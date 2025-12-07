package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.zzn;

final class zzbk extends zzav {
    private final zzbi zzev;
    private final MetadataChangeSet zzew;
    private final zzn zzex;

    zzbk(zzbi zzbi0, GoogleApiClient googleApiClient0, MetadataChangeSet metadataChangeSet0, zzn zzn0) {
        this.zzev = zzbi0;
        this.zzew = metadataChangeSet0;
        this.zzex = zzn0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        this.zzew.zzq().zza(((zzaw)api$AnyClient0).getContext());
        zzeo zzeo0 = (zzeo)((zzaw)api$AnyClient0).getService();
        MetadataBundle metadataBundle0 = this.zzew.zzq();
        zzeo0.zza(new zzm(this.zzev.zzes.getDriveId(), metadataBundle0, this.zzev.zzes.getRequestId(), this.zzev.zzes.zzb(), this.zzex), new zzgy(this));
    }
}

