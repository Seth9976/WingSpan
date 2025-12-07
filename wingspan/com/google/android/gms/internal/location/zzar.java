package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzaz;

final class zzar extends zzaz {
    private final ListenerHolder zza;

    zzar(ListenerHolder listenerHolder0) {
        this.zza = listenerHolder0;
    }

    public final void zzc() {
        synchronized(this) {
            this.zza.clear();
        }
    }

    @Override  // com.google.android.gms.location.zzba
    public final void zzd(LocationResult locationResult0) {
        zzap zzap0 = new zzap(this, locationResult0);
        this.zza.notifyListener(zzap0);
    }

    @Override  // com.google.android.gms.location.zzba
    public final void zze(LocationAvailability locationAvailability0) {
        zzaq zzaq0 = new zzaq(this, locationAvailability0);
        this.zza.notifyListener(zzaq0);
    }
}

