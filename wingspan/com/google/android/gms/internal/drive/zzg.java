package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.drive.events.ListenerToken;

public final class zzg implements ListenerToken {
    private final ListenerKey zzcy;
    private ICancelToken zzcz;

    public zzg(ListenerKey listenerHolder$ListenerKey0) {
        this.zzcz = null;
        this.zzcy = listenerHolder$ListenerKey0;
    }

    public final boolean cancel() {
        ICancelToken iCancelToken0 = this.zzcz;
        if(iCancelToken0 != null) {
            try {
                iCancelToken0.cancel();
                return true;
            }
            catch(RemoteException unused_ex) {
            }
        }
        return false;
    }

    public final void setCancelToken(ICancelToken iCancelToken0) {
        this.zzcz = iCancelToken0;
    }

    public final ListenerKey zzad() {
        return this.zzcy;
    }
}

