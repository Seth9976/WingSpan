package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

final class zzap implements Notifier {
    final LocationResult zza;

    zzap(zzar zzar0, LocationResult locationResult0) {
        this.zza = locationResult0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((LocationCallback)object0).onLocationResult(this.zza);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void onNotifyListenerFailed() {
    }
}

