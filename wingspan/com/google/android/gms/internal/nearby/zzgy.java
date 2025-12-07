package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.internal.zzq;

public final class zzgy extends zzq {
    private final ListenerHolder zzjj;
    private boolean zzjl;

    public zzgy(ListenerHolder listenerHolder0) {
        this.zzjl = false;
        this.zzjj = listenerHolder0;
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzp
    public final void zza(Status status0) throws RemoteException {
        synchronized(this) {
            if(!this.zzjl) {
                zzgz zzgz0 = new zzgz(this, status0);
                this.zzjj.notifyListener(zzgz0);
                this.zzjl = true;
                return;
            }
            Log.wtf("NearbyMessagesCallbackWrapper", "Received multiple statuses: " + status0, new Exception());
        }
    }
}

