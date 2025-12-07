package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

final class zzdx extends zzej {
    final String zza;
    final String zzb;
    final SnapshotMetadataChange zzc;
    final SnapshotContents zzd;

    zzdx(zzek zzek0, GoogleApiClient googleApiClient0, String s, String s1, SnapshotMetadataChange snapshotMetadataChange0, SnapshotContents snapshotContents0) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = snapshotMetadataChange0;
        this.zzd = snapshotContents0;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzbz)api$AnyClient0).zzaM(this, this.zza, this.zzb, this.zzc, this.zzd);
    }
}

