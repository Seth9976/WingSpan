package com.google.android.gms.games;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.internal.zzcg;

class zzl extends AbstractClientBuilder {
    zzl(zzk zzk0) {
    }

    @Override  // com.google.android.gms.common.api.Api$AbstractClientBuilder
    public final Client buildClient(Context context0, Looper looper0, ClientSettings clientSettings0, Object object0, ConnectionCallbacks googleApiClient$ConnectionCallbacks0, OnConnectionFailedListener googleApiClient$OnConnectionFailedListener0) {
        GamesOptions games$GamesOptions0 = (GamesOptions)object0;
        if(games$GamesOptions0 == null) {
            games$GamesOptions0 = new Builder(null).build();
        }
        return new zzbz(context0, looper0, clientSettings0, games$GamesOptions0, googleApiClient$ConnectionCallbacks0, googleApiClient$OnConnectionFailedListener0, zzcg.zza());
    }

    @Override  // com.google.android.gms.common.api.Api$BaseClientBuilder
    public final int getPriority() {
        return 1;
    }
}

