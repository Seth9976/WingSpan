package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzak extends zzap {
    final ListenerHolder zza;
    final FusedLocationProviderClient zzb;

    zzak(FusedLocationProviderClient fusedLocationProviderClient0, ListenerHolder listenerHolder0) {
        this.zzb = fusedLocationProviderClient0;
        this.zza = listenerHolder0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) throws RemoteException {
        zzaz zzaz0 = (zzaz)object0;
        if(this.zza()) {
            zzal zzal0 = new zzal(this.zzb, ((TaskCompletionSource)object1));
            try {
                ListenerKey listenerHolder$ListenerKey0 = this.zza.getListenerKey();
                if(listenerHolder$ListenerKey0 != null) {
                    zzaz0.zzH(listenerHolder$ListenerKey0, zzal0);
                }
            }
            catch(RuntimeException runtimeException0) {
                ((TaskCompletionSource)object1).trySetException(runtimeException0);
            }
        }
    }
}

