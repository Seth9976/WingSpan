package com.google.android.gms.internal.nearby;

import androidx.collection.ArraySet;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

final class zzak extends zzds {
    private final ListenerHolder zzbe;
    private final Set zzbq;

    zzak(ListenerHolder listenerHolder0) {
        this.zzbq = new ArraySet();
        this.zzbe = (ListenerHolder)Preconditions.checkNotNull(listenerHolder0);
    }

    final void shutdown() {
        synchronized(this) {
            for(Object object0: this.zzbq) {
                zzan zzan0 = new zzan(this, ((String)object0));
                this.zzbe.notifyListener(zzan0);
            }
            this.zzbq.clear();
        }
    }

    @Override  // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzer zzer0) {
        synchronized(this) {
            this.zzbq.add(zzer0.zze());
            zzal zzal0 = new zzal(this, zzer0);
            this.zzbe.notifyListener(zzal0);
        }
    }

    @Override  // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzet zzet0) {
        synchronized(this) {
            this.zzbq.remove(zzet0.zze());
            zzam zzam0 = new zzam(this, zzet0);
            this.zzbe.notifyListener(zzam0);
        }
    }

    @Override  // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzfd zzfd0) {
    }
}

