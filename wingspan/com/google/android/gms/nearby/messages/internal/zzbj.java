package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.nearby.messages.MessagesOptions;

final class zzbj extends AbstractClientBuilder {
    @Override  // com.google.android.gms.common.api.Api$AbstractClientBuilder
    public final Client buildClient(Context context0, Looper looper0, ClientSettings clientSettings0, Object object0, ConnectionCallbacks googleApiClient$ConnectionCallbacks0, OnConnectionFailedListener googleApiClient$OnConnectionFailedListener0) {
        return new zzah(context0, looper0, googleApiClient$ConnectionCallbacks0, googleApiClient$OnConnectionFailedListener0, clientSettings0, ((MessagesOptions)object0));
    }

    @Override  // com.google.android.gms.common.api.Api$BaseClientBuilder
    public final int getPriority() {
        return 0x7FFFFFFF;
    }
}

