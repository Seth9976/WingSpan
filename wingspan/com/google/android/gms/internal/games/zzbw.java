package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

final class zzbw extends zzcg {
    final String zza;
    final int zzb;
    final int zzc;

    zzbw(zzcm zzcm0, GoogleApiClient googleApiClient0, String s, int v, int v1) {
        this.zza = s;
        this.zzb = v;
        this.zzc = v1;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzbz)api$AnyClient0).zzaz(this, null, this.zza, this.zzb, this.zzc);
    }
}

