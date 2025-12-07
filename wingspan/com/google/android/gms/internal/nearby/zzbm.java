package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;

final class zzbm extends AbstractClientBuilder {
    @Override  // com.google.android.gms.common.api.Api$AbstractClientBuilder
    public final Client buildClient(Context context0, Looper looper0, ClientSettings clientSettings0, Object object0, ConnectionCallbacks googleApiClient$ConnectionCallbacks0, OnConnectionFailedListener googleApiClient$OnConnectionFailedListener0) {
        return new zzx(context0, looper0, clientSettings0, googleApiClient$ConnectionCallbacks0, googleApiClient$OnConnectionFailedListener0);
    }
}

