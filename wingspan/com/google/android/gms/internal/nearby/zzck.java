package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

final class zzck extends zzcy {
    private final String zzcv;
    private final byte[] zzdb;
    private final ListenerHolder zzdd;

    zzck(zzca zzca0, GoogleApiClient googleApiClient0, String s, byte[] arr_b, ListenerHolder listenerHolder0) {
        this.zzcv = s;
        this.zzdb = arr_b;
        this.zzdd = listenerHolder0;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzdu)((zzx)api$AnyClient0).getService()).zza(new zzo().zza(new zzba(this)).zza(this.zzcv).zza(this.zzdb).zza(new zzar(this.zzdd)).zzb());
    }
}

