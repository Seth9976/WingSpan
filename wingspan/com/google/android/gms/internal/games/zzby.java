package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

final class zzby extends zzcj {
    final String zza;
    final int zzb;
    final int zzc;
    final int zzd;
    final boolean zze;

    zzby(zzcm zzcm0, GoogleApiClient googleApiClient0, String s, int v, int v1, int v2, boolean z) {
        this.zza = s;
        this.zzb = v;
        this.zzc = v1;
        this.zzd = v2;
        this.zze = z;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzbz)api$AnyClient0).zzax(this, this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}

