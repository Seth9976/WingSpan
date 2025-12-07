package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

final class zzdb extends zzdh {
    final int zza;
    final boolean zzb;

    zzdb(zzdi zzdi0, GoogleApiClient googleApiClient0, int v, boolean z) {
        this.zza = v;
        this.zzb = z;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzbz)api$AnyClient0).zzao(this, this.zza, false, this.zzb);
    }
}

