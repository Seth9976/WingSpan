package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

final class zzak extends zzaq {
    final String zza;
    final int zzb;

    zzak(zzar zzar0, GoogleApiClient googleApiClient0, String s, int v) {
        this.zza = s;
        this.zzb = v;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzbz)api$AnyClient0).zzab(this.zza, this.zzb);
    }
}

