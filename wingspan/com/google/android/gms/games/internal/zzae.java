package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult;

final class zzae implements CaptureCapabilitiesResult {
    private final Status zza;
    private final VideoCapabilities zzb;

    zzae(Status status0, VideoCapabilities videoCapabilities0) {
        this.zza = status0;
        this.zzb = videoCapabilities0;
    }

    @Override  // com.google.android.gms.games.video.Videos$CaptureCapabilitiesResult
    public final VideoCapabilities getCapabilities() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

