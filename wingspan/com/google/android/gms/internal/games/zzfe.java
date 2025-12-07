package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult;

final class zzfe implements CaptureCapabilitiesResult {
    final Status zza;

    zzfe(zzfg zzfg0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.games.video.Videos$CaptureCapabilitiesResult
    public final VideoCapabilities getCapabilities() {
        return null;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

