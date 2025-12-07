package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

final class zzdu extends zzej {
    final String zza;
    final boolean zzb;
    final int zzc;

    zzdu(zzek zzek0, GoogleApiClient googleApiClient0, String s, boolean z, int v) {
        this.zza = s;
        this.zzb = z;
        this.zzc = v;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzbz)api$AnyClient0).zzaI(this, this.zza, this.zzb, this.zzc);
    }
}

