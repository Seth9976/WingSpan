package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

final class zabt implements Runnable {
    final ConnectionResult zaa;
    final zabu zab;

    zabt(zabu zabu0, ConnectionResult connectionResult0) {
        this.zab = zabu0;
        this.zaa = connectionResult0;
        super();
    }

    @Override
    public final void run() {
        zabq zabq0 = (zabq)this.zab.zaa.zan.get(this.zab.zac);
        if(zabq0 == null) {
            return;
        }
        if(this.zaa.isSuccess()) {
            zabu.zac(this.zab, true);
            if(this.zab.zab.requiresSignIn()) {
                this.zab.zah();
                return;
            }
            try {
                this.zab.zab.getRemoteService(null, this.zab.zab.getScopesForConnectionlessNonSignIn());
            }
            catch(SecurityException securityException0) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", securityException0);
                this.zab.zab.disconnect("Failed to get service from broker.");
                zabq0.zar(new ConnectionResult(10), null);
            }
            return;
        }
        zabq0.zar(this.zaa, null);
    }
}

