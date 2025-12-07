package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.DiscoveryOptions.Builder;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.Strategy;

final class zzci extends zzcy {
    private final String zzcn;
    private final long zzcy;
    private final ListenerHolder zzda;

    zzci(zzca zzca0, GoogleApiClient googleApiClient0, String s, long v, ListenerHolder listenerHolder0) {
        this.zzcn = s;
        this.zzcy = v;
        this.zzda = listenerHolder0;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        DiscoveryOptions discoveryOptions0 = new Builder().setStrategy(Strategy.P2P_CLUSTER).build();
        ((zzdu)((zzx)api$AnyClient0).getService()).zza(new zzge().zzf(new zzba(this)).zzk(this.zzcn).zze(this.zzcy).zza(new zzao(this.zzda)).zze(discoveryOptions0).zzw());
    }
}

