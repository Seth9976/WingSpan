package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zae;

final class zaat implements ConnectionCallbacks, OnConnectionFailedListener {
    final zaaw zaa;

    zaat(zaaw zaaw0, zaas zaas0) {
        this.zaa = zaaw0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle0) {
        ClientSettings clientSettings0 = (ClientSettings)Preconditions.checkNotNull(this.zaa.zar);
        ((zae)Preconditions.checkNotNull(this.zaa.zak)).zad(new zaar(this.zaa));
    }

    @Override  // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult0) {
        this.zaa.zab.lock();
        try {
            if(this.zaa.zaI(connectionResult0)) {
                this.zaa.zaA();
                this.zaa.zaF();
            }
            else {
                this.zaa.zaD(connectionResult0);
            }
        }
        finally {
            this.zaa.zab.unlock();
        }
    }

    @Override  // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int v) {
    }
}

