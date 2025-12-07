package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

final class zzv extends zzab {
    final String zza;
    final int zzb;

    zzv(zzac zzac0, String s, GoogleApiClient googleApiClient0, String s1, int v) {
        this.zza = s1;
        this.zzb = v;
        super(s, googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzbz)api$AnyClient0).zzZ(this, this.zza, this.zzb);
    }
}

