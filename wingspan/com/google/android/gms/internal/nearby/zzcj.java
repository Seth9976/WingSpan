package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

final class zzcj extends zzcy {
    private final String val$name;
    private final String zzcv;
    private final byte[] zzdb;
    private final ListenerHolder zzdc;
    private final ListenerHolder zzdd;

    zzcj(zzca zzca0, GoogleApiClient googleApiClient0, String s, String s1, byte[] arr_b, ListenerHolder listenerHolder0, ListenerHolder listenerHolder1) {
        this.val$name = s;
        this.zzcv = s1;
        this.zzdb = arr_b;
        this.zzdc = listenerHolder0;
        this.zzdd = listenerHolder1;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzdu)((zzx)api$AnyClient0).getService()).zza(new zzfs().zzd(new zzba(this)).zzg(this.val$name).zzh(this.zzcv).zzc(this.zzdb).zzb(new zzar(this.zzdd)).zza(new zzai(this.zzdc)).zzt());
    }
}

