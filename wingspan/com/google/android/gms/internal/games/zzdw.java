package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.SnapshotMetadata;

final class zzdw extends zzed {
    final SnapshotMetadata zza;

    zzdw(zzek zzek0, GoogleApiClient googleApiClient0, SnapshotMetadata snapshotMetadata0) {
        this.zza = snapshotMetadata0;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzbz)api$AnyClient0).zzQ(this, this.zza.getSnapshotId());
    }
}

