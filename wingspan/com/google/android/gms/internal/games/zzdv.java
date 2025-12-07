package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

final class zzdv extends zzea {
    final Snapshot zza;
    final SnapshotMetadataChange zzb;

    zzdv(zzek zzek0, GoogleApiClient googleApiClient0, Snapshot snapshot0, SnapshotMetadataChange snapshotMetadataChange0) {
        this.zza = snapshot0;
        this.zzb = snapshotMetadataChange0;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzbz)api$AnyClient0).zzO(this, this.zza, this.zzb);
    }
}

