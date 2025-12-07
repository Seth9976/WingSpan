package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;

final class zzaq implements Notifier {
    final LocationAvailability zza;

    zzaq(zzar zzar0, LocationAvailability locationAvailability0) {
        this.zza = locationAvailability0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((LocationCallback)object0).onLocationAvailability(this.zza);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void onNotifyListenerFailed() {
    }
}

