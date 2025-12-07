package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos.CaptureStateResult;

final class zzaf implements CaptureStateResult {
    private final Status zza;
    private final CaptureState zzb;

    zzaf(Status status0, CaptureState captureState0) {
        this.zza = status0;
        this.zzb = captureState0;
    }

    @Override  // com.google.android.gms.games.video.Videos$CaptureStateResult
    public final CaptureState getCaptureState() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

