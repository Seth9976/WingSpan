package com.google.android.gms.games.internal;

import com.google.android.gms.games.video.Videos.CaptureOverlayStateListener;

public final class zzo implements zzbq {
    public final int zza;

    public zzo(int v) {
        this.zza = v;
    }

    @Override  // com.google.android.gms.games.internal.zzbq
    public final void zza(Object object0) {
        ((CaptureOverlayStateListener)object0).onCaptureOverlayStateChanged(this.zza);
    }
}

