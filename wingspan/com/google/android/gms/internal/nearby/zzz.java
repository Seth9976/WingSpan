package com.google.android.gms.internal.nearby;

import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

final class zzz extends zzdk {
    private final ListenerHolder zzbe;
    private final Set zzbf;
    private final Set zzbg;

    zzz(ListenerHolder listenerHolder0) {
        this.zzbf = new ArraySet();
        this.zzbg = new ArraySet();
        this.zzbe = (ListenerHolder)Preconditions.checkNotNull(listenerHolder0);
    }

    final void shutdown() {
        synchronized(this) {
            for(Object object0: this.zzbf) {
                zzae zzae0 = new zzae(this, ((String)object0));
                this.zzbe.notifyListener(zzae0);
            }
            this.zzbf.clear();
            for(Object object1: this.zzbg) {
                zzaf zzaf0 = new zzaf(this, ((String)object1));
                this.zzbe.notifyListener(zzaf0);
            }
            this.zzbg.clear();
        }
    }

    @Override  // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzef zzef0) {
        zzad zzad0 = new zzad(this, zzef0);
        this.zzbe.notifyListener(zzad0);
    }

    @Override  // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzeh zzeh0) {
        synchronized(this) {
            this.zzbf.add(zzeh0.zzg());
            zzaa zzaa0 = new zzaa(this, zzeh0);
            this.zzbe.notifyListener(zzaa0);
        }
    }

    @Override  // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzen zzen0) {
        synchronized(this) {
            this.zzbf.remove(zzen0.zzg());
            Status status0 = zzx.zza(zzen0.getStatusCode());
            if(status0.isSuccess()) {
                this.zzbg.add(zzen0.zzg());
            }
            zzab zzab0 = new zzab(this, zzen0, status0);
            this.zzbe.notifyListener(zzab0);
        }
    }

    @Override  // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzep zzep0) {
        synchronized(this) {
            this.zzbg.remove(zzep0.zzg());
            zzac zzac0 = new zzac(this, zzep0);
            this.zzbe.notifyListener(zzac0);
        }
    }
}

