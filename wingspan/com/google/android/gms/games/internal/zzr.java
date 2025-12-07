package com.google.android.gms.games.internal;

final class zzr extends zzay {
    final zzbq zza;

    zzr(zzbq zzbq0) {
        this.zza = zzbq0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        this.zza.zza(object0);
    }
}

