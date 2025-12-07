package com.google.android.gms.games.internal;

import com.google.android.gms.games.VideosClient.OnCaptureOverlayStateListener;

public final class zzm implements zzbq {
    public final int zza;

    public zzm(int v) {
        this.zza = v;
    }

    @Override  // com.google.android.gms.games.internal.zzbq
    public final void zza(Object object0) {
        ((OnCaptureOverlayStateListener)object0).onCaptureOverlayStateChanged(this.zza);
    }
}

