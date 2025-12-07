package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

final class zzca extends zzcl {
    final String zza;
    final long zzb;
    final String zzc;

    zzca(zzcm zzcm0, GoogleApiClient googleApiClient0, String s, long v, String s1) {
        this.zza = s;
        this.zzb = v;
        this.zzc = s1;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzbz)api$AnyClient0).zzaX(this, this.zza, this.zzb, this.zzc);
    }
}

