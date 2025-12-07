package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;

final class zzdt extends zzea {
    private final MetadataChangeSet zzfd;
    private final zzdp zzgq;

    zzdt(zzdp zzdp0, GoogleApiClient googleApiClient0, MetadataChangeSet metadataChangeSet0) {
        this.zzgq = zzdp0;
        this.zzfd = metadataChangeSet0;
        super(zzdp0, googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        Context context0 = ((zzaw)api$AnyClient0).getContext();
        this.zzfd.zzq().zza(context0);
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzhf(this.zzgq.zzk, this.zzfd.zzq()), new zzdy(this));
    }
}

