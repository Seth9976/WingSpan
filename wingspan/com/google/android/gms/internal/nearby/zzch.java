package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.AdvertisingOptions.Builder;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.Strategy;

final class zzch extends zzcw {
    private final String val$name;
    private final long zzcy;
    private final ListenerHolder zzcz;

    zzch(zzca zzca0, GoogleApiClient googleApiClient0, String s, long v, ListenerHolder listenerHolder0) {
        this.val$name = s;
        this.zzcy = v;
        this.zzcz = listenerHolder0;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        AdvertisingOptions advertisingOptions0 = new Builder().setStrategy(Strategy.P2P_CLUSTER).build();
        ((zzdu)((zzx)api$AnyClient0).getService()).zza(new zzga().zza(new zzbc(this)).zzi(this.val$name).zzj("__LEGACY_SERVICE_ID__").zzd(this.zzcy).zza(new zzag(this.zzcz)).zzg(advertisingOptions0).zzv());
    }
}

