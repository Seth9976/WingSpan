package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

final class zzai extends zzan {
    final boolean zza;
    final String[] zzb;

    zzai(zzar zzar0, GoogleApiClient googleApiClient0, boolean z, String[] arr_s) {
        this.zza = z;
        this.zzb = arr_s;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzbz)api$AnyClient0).zzak(this, this.zza, this.zzb);
    }
}

