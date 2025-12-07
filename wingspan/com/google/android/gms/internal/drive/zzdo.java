package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.drive.events.OpenFileCallback;

final class zzdo implements Notifier {
    private final zzdg zzgp;

    zzdo(zzdk zzdk0, zzdg zzdg0) {
        this.zzgp = zzdg0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        this.zzgp.accept(((OpenFileCallback)object0));
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void onNotifyListenerFailed() {
    }
}

