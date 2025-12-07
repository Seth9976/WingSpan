package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.zzbc;

final class zzau extends zzbc {
    private final ListenerHolder zza;

    zzau(ListenerHolder listenerHolder0) {
        this.zza = listenerHolder0;
    }

    public final void zzc() {
        synchronized(this) {
            this.zza.clear();
        }
    }

    @Override  // com.google.android.gms.location.zzbd
    public final void zzd(Location location0) {
        synchronized(this) {
            zzat zzat0 = new zzat(this, location0);
            this.zza.notifyListener(zzat0);
        }
    }
}

